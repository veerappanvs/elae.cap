package edu.mass.doe.cap.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUploadBase.SizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import edu.mass.doe.EOEAuthorization.DirAdminAccessUtil;
import edu.mass.doe.cap.dataservice.pojo.CapCycleInfo;
import edu.mass.doe.cap.dataservice.pojo.EvidenceFileInfo;
import edu.mass.doe.cap.file.io.FileSystemStorageService;
import edu.mass.doe.cap.file.io.StorageService;
import edu.mass.doe.cap.security.EOEUser;
import edu.mass.doe.cap.util.CAPValidationUtil;
import edu.mass.doe.cap.util.CapUtil;

/**
 * The Class TagEvidenceController.
 */
@Controller
@RequestMapping("tagfile")
@SessionAttributes("evidenceFileInfo")
public class TagEvidenceController extends BaseCycleInformation {

	@Autowired
	private FileSystemStorageService storageService;

	/**
	 * Load meeting.
	 *
	 * @param cycleId the cycle id
	 * @param model the model
	 * @return the string
	 * @throws Exception the exception
	 */
	@RequestMapping
	public String loadMeeting(@RequestParam("cycleId") Long cycleId, Model model) throws Exception {

		model.addAttribute("evidenceFileInfo", getFileInfo());

		
		 return ".uploadForm";
	}

	/**
	 * Gets the file info.
	 *
	 * @return the file info
	 */
	private EvidenceFileInfo getFileInfo() {
		EvidenceFileInfo evidenceFileInfo = new EvidenceFileInfo();
		evidenceFileInfo.setAttributes(evidenceFileManager.geAttributeInfo());
		evidenceFileInfo.setEvidenceTypes(evidenceFileManager.getEvidenceTypes());
		return evidenceFileInfo;
	}

	/**
	 * Load file.
	 *
	 * @param cycleId the cycle id
	 * @param model the model
	 * @throws Exception the exception
	 */
	@ModelAttribute
	public void loadFile(@RequestParam("cycleId") Long cycleId, Model model) throws Exception {
		
		model.addAttribute("evidenceFiles", evidenceFileManager.getEvidenceFiles(cycleId));
		CapCycleInfo cycleInfo = cycleManager.getCycleInfo(cycleId);
		model.addAttribute("cycleInfo", cycleInfo);
		model.addAttribute("canUpload", cycleInfo.getCycleStatusCode()==null);
		
	}

	/**
	 * Handle file upload.
	 *
	 * @param evidenceFileInfo the evidence file info
	 * @param result the result
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws MaxUploadSizeExceededException the max upload size exceeded exception
	 */
	@PostMapping
	public String handleFileUpload(@ModelAttribute("evidenceFileInfo") EvidenceFileInfo evidenceFileInfo,
			BindingResult result) throws IOException,MaxUploadSizeExceededException {
		if (validate( evidenceFileInfo, result))
		{
			evidenceFileManager.save(evidenceFileInfo, evidenceFileInfo.getFile());
			 return "redirect:tagfile?cycleId="+evidenceFileInfo.getCycleId();
		}
		 return ".uploadForm";
	}

	/**
	 * Validate.
	 *
	 * @param evidenceFileInfo the evidence file info
	 * @param bindingResult the binding result
	 * @return true, if successful
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private boolean validate(EvidenceFileInfo evidenceFileInfo, BindingResult bindingResult)
			throws IOException {
		boolean result = true;

		result = CAPValidationUtil.validateFile(evidenceFileInfo.getFile(), evidenceFileInfo.getCycleId(), storageService, "file",
				bindingResult, new Object[] {});

		return result;
	}
	
	/**
	 * Handle file down load.
	 *
	 * @param fileId the file id
	 * @param cycleId the cycle id
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@RequestMapping("download")
    @ResponseBody
	public ResponseEntity<Resource> handleFileDownLoad(@RequestParam("fileId")Long fileId,@RequestParam("cycleId")Long cycleId) throws Exception {
		
		List<EvidenceFileInfo> evidenceFiles=evidenceFileManager.getEvidenceFiles(cycleId);
		
		String fileName="";
		String contentType="";
		
		for(EvidenceFileInfo evidenceFileInfo:evidenceFiles){
			if(evidenceFileInfo.getFileId().equals(fileId)){
				fileName=evidenceFileInfo.getInternalFileName();
				contentType=evidenceFileInfo.getExternalFileName();
				break;
			}
		}
		if(fileName.length()<1)
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		Resource file = storageService.loadAsResource(fileId.toString(), cycleId);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + fileName + "\"").header(HttpHeaders.CONTENT_TYPE, contentType).body(file);
		
	}
	
	
	/**
	 * Handle file delete.
	 *
	 * @param fileId the file id
	 * @param cycleId the cycle id
	 * @return the response entity
	 */
	@RequestMapping("delete")
    @ResponseBody
	public ResponseEntity handleFileDelete(@RequestParam("fileId")Long fileId,@RequestParam("cycleId")Long cycleId) {
		
		try{
		List<EvidenceFileInfo> evidenceFiles=evidenceFileManager.getEvidenceFiles(cycleId);
		
		
		Long personId=null;
		
		for(EvidenceFileInfo evidenceFileInfo:evidenceFiles){
			if(evidenceFileInfo.getFileId().equals(fileId)){				
				personId=evidenceFileInfo.getPersonId();
				break;
			}
		}
		if(personId==null)
			throw new Exception("File not found");
		
		boolean canDelete=false;
		String storedUserRoleCode =DirAdminAccessUtil.getUserInfo(DirAdminAccessUtil.getUserIDByDAPersonID(personId.intValue()), env.getProperty("app.name")).getUserRoles()[0];

		if(storedUserRoleCode.equals("3")){
			canDelete=((EOEUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
			.getPersonId().equals(personId);
		}else if(CapUtil.isManager()||CapUtil.isSupervisor()&&(storedUserRoleCode.equals("723")||storedUserRoleCode.equals("722"))){
			canDelete=true;
		}else if(CapUtil.ispractitioner()&&storedUserRoleCode.equals("724")){
			canDelete=true;
		}
		
		if(cycleManager.getCycleInfo(cycleId).getCycleStatusCode()!=null)
			canDelete= false;
		
		if(!canDelete)
			throw new Exception("Cannot delete");
		
		evidenceFileManager.delete(fileId, cycleId);
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
		}
		
		
		return ResponseEntity.status(HttpStatus.OK).body(null); 
		

		
	}
	

	
}
