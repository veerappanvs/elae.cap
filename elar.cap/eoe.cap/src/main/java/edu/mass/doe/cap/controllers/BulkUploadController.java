
package edu.mass.doe.cap.controllers;

import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import edu.mass.doe.EOEAuthorization.DirAdminAccessUtil;
import edu.mass.doe.cap.dataservice.batch.DataReader;
import edu.mass.doe.cap.dataservice.entity.BatchError;
import edu.mass.doe.cap.dataservice.pojo.BatchInfo;
import edu.mass.doe.cap.dataservice.pojo.CapCycleInfo;
import edu.mass.doe.cap.dataservice.pojo.CapData;
import edu.mass.doe.cap.dataservice.pojo.EvidenceFileInfo;
import edu.mass.doe.cap.file.io.FileSystemStorageService;
import edu.mass.doe.cap.file.io.StorageService;
import edu.mass.doe.cap.model.batch.BatchManager;
import edu.mass.doe.cap.security.EOEUser;
import edu.mass.doe.cap.util.CAPValidationUtil;
import edu.mass.doe.cap.util.CapUtil;

/**
 * The Class BulkUploadController.
 */
@Controller
@RequestMapping("batchload")
@SessionAttributes("batchInfo")
public class BulkUploadController {

	@Autowired
	private DataReader dataReader;

	@Autowired
	private BatchManager batchManager;

	@Autowired
	private ResourceLoader resourceLoader;

	/**
	 * Load meeting.
	 *
	 * @param model the model
	 * @return the string
	 * @throws Exception the exception
	 */
	@RequestMapping
	public String loadMeeting(Model model) throws Exception {

		BatchInfo batchInfo = new BatchInfo();
		model.addAttribute("batchInfo", batchInfo);
		return ".bulkUploadForm";
	}

	/**
	 * Download template.
	 *
	 * @param model the model
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@RequestMapping("template")
	@ResponseBody
	public ResponseEntity<Resource> downloadTemplate(Model model) throws Exception {
		Resource resource = resourceLoader.getResource("classpath:BatchuploadTemplate.csv");
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "BatchuploadTemplate.csv" + "\"")
				.header(HttpHeaders.CONTENT_TYPE, "text/csv").body(resource);
	}

	/**
	 * Handle download error file.
	 *
	 * @param batchId the batch id
	 * @param model the model
	 * @return the http entity
	 * @throws UnexpectedInputException the unexpected input exception
	 * @throws ParseException the parse exception
	 * @throws Exception the exception
	 */
	@RequestMapping("errorLog")
	@ResponseBody
	public HttpEntity<byte[]> handleDownloadErrorFile(@RequestParam("batchId") Long batchId, Model model) throws UnexpectedInputException, ParseException, Exception {
		
		List<CapData> capData = new ArrayList<CapData>();
		ByteArrayOutputStream io = new ByteArrayOutputStream();
		
		Workbook workbook =  buildExcelDocument(batchManager.downloadError(batchId));
		workbook.write(io);

		if (null != workbook && null != io) {
			io.close();
		}
		
		

		byte[] documentContent = io.toByteArray();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(
				MediaType.parseMediaType("application/vnd.ms-excel"));
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"error_"+batchId+".xls\"");
		headers.setContentLength(documentContent.length);
		return new ResponseEntity<byte[]>(documentContent, headers, HttpStatus.OK);
	}

	/**
	 * Handle file upload.
	 *
	 * @param batchInfo the batch info
	 * @param model the model
	 * @param result the result
	 * @return the string
	 * @throws UnexpectedInputException the unexpected input exception
	 * @throws ParseException the parse exception
	 * @throws Exception the exception
	 */
	@PostMapping
	public String handleFileUpload(@ModelAttribute("batchInfo") BatchInfo batchInfo, Model model, BindingResult result)
			throws UnexpectedInputException, ParseException, Exception {
		List<CapData> records = new ArrayList<CapData>();
		if (CAPValidationUtil.validateCAPFile(batchInfo.getFile(), "file", result, new Object[] {})) {
			try {
				records = dataReader.read(batchInfo.getFile());
			} catch (ParseException p) {
				result.rejectValue("file", "cap.bulk.upload.invalid.template", new Object[] {}, null);
				return ".bulkUploadForm";
			}
			
			
			if(records.size()<1){
				result.rejectValue("file", "cap.file.empty", new Object[] {}, null);
				return ".bulkUploadForm";
			}
			
			String fileName = batchInfo.getFile().getOriginalFilename();
			int idx = fileName.lastIndexOf("\\") > -1 ? fileName.lastIndexOf("\\") + 1 : 0;

			batchManager.uploadStaging(fileName.substring(idx, fileName.length()), records,batchInfo);
		}
		return ".bulkUploadForm";
	}

	/**
	 * Builds the excel document.
	 *
	 * @param records the records
	 * @return the workbook
	 * @throws Exception the exception
	 */
	public Workbook buildExcelDocument(List<CapData> records) throws Exception {

		Workbook workbook = new HSSFWorkbook();

		// create a new Excel sheet
		HSSFSheet sheet = (HSSFSheet) workbook.createSheet("Error Log");
		sheet.setDefaultColumnWidth(30);

		// create style for header cells
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Sans-serif");
		//style.setFillForegroundColor(HSSFColor.BLUE.index);
		//style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		//font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);
		
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setBorderRight(CellStyle.BORDER_THIN);

		// create header row
		HSSFRow header = sheet.createRow(0);

		header.createCell(0).setCellValue("Organization");
		header.getCell(0).setCellStyle(style);

		header.createCell(1).setCellValue("Practicum District");
		header.getCell(1).setCellStyle(style);

		header.createCell(2).setCellValue("Practicum School");
		header.getCell(2).setCellStyle(style);

		header.createCell(3).setCellValue("School Year");
		header.getCell(3).setCellStyle(style);

		header.createCell(4).setCellValue("Program");
		header.getCell(4).setCellStyle(style);

		header.createCell(5).setCellValue("Candidate MEPID");
		header.getCell(5).setCellStyle(style);

		header.createCell(6).setCellValue("Candidate First Name");
		header.getCell(6).setCellStyle(style);

		header.createCell(7).setCellValue("Candidate Last Name");
		header.getCell(7).setCellStyle(style);

		header.createCell(8).setCellValue("Candidate E-Mail Address");
		header.getCell(8).setCellStyle(style);

		header.createCell(9).setCellValue("PS Name");
		header.getCell(9).setCellStyle(style);

		header.createCell(10).setCellValue("PS E-Mail");
		header.getCell(10).setCellStyle(style);


		header.createCell(11).setCellValue("SP Name");
		header.getCell(11).setCellStyle(style);

		header.createCell(12).setCellValue("SP MEPID");
		header.getCell(12).setCellStyle(style);

		header.createCell(13).setCellValue("SP E-Mail");
		header.getCell(13).setCellStyle(style);

		header.createCell(14).setCellValue("F1A4Q");
		header.getCell(14).setCellStyle(style);

		header.createCell(15).setCellValue("F1A4S");
		header.getCell(15).setCellStyle(style);

		header.createCell(16).setCellValue("F1A4C");
		header.getCell(16).setCellStyle(style);

		header.createCell(17).setCellValue("F1B2Q");
		header.getCell(17).setCellStyle(style);

		header.createCell(18).setCellValue("F1B2S");
		header.getCell(18).setCellStyle(style);

		header.createCell(19).setCellValue("F1B2C");
		header.getCell(19).setCellStyle(style);

		header.createCell(20).setCellValue("F2A3Q");
		header.getCell(20).setCellStyle(style);

		header.createCell(21).setCellValue("F2A3S");
		header.getCell(21).setCellStyle(style);

		header.createCell(22).setCellValue("F2A3C");
		header.getCell(22).setCellStyle(style);

		header.createCell(23).setCellValue("F2B1Q");
		header.getCell(23).setCellStyle(style);

		header.createCell(24).setCellValue("F2B1S");
		header.getCell(24).setCellStyle(style);

		header.createCell(25).setCellValue("F2B1C");
		header.getCell(25).setCellStyle(style);

		header.createCell(26).setCellValue("F2D2Q");
		header.getCell(26).setCellStyle(style);
		
		header.createCell(27).setCellValue("F2D2S");
		header.getCell(27).setCellStyle(style);

		header.createCell(28).setCellValue("F2D2C");
		header.getCell(28).setCellStyle(style);

		header.createCell(29).setCellValue("F4A1Q");
		header.getCell(29).setCellStyle(style);

		header.createCell(30).setCellValue("F4A1S");
		header.getCell(30).setCellStyle(style);

		header.createCell(31).setCellValue("F4A1C");
		header.getCell(31).setCellStyle(style);

		header.createCell(32).setCellValue("S1A4Q");
		header.getCell(32).setCellStyle(style);

		header.createCell(33).setCellValue("S1A4S");
		header.getCell(33).setCellStyle(style);

		header.createCell(34).setCellValue("S1A4C");
		header.getCell(34).setCellStyle(style);

		header.createCell(35).setCellValue("S1B2Q");
		header.getCell(35).setCellStyle(style);

		header.createCell(36).setCellValue("S1B2S");
		header.getCell(36).setCellStyle(style);

		header.createCell(37).setCellValue("S1B2C");
		header.getCell(37).setCellStyle(style);

		header.createCell(38).setCellValue("S2A3Q");
		header.getCell(38).setCellStyle(style);

		header.createCell(39).setCellValue("S2A3S");
		header.getCell(39).setCellStyle(style);

		header.createCell(40).setCellValue("S2B1Q");
		header.getCell(40).setCellStyle(style);

		header.createCell(41).setCellValue("S2B1S");
		header.getCell(41).setCellStyle(style);

		header.createCell(42).setCellValue("S2B1C");
		header.getCell(42).setCellStyle(style);

		header.createCell(43).setCellValue("S2D2Q");
		header.getCell(43).setCellStyle(style);

		header.createCell(44).setCellValue("S2B1C");
		header.getCell(44).setCellStyle(style);

		header.createCell(45).setCellValue("S2D2S");
		header.getCell(45).setCellStyle(style);

		header.createCell(46).setCellValue("S2D2C");
		header.getCell(46).setCellStyle(style);

		header.createCell(47).setCellValue("S4A1Q");
		header.getCell(47).setCellStyle(style);

		header.createCell(48).setCellValue("S4A1S");
		header.getCell(48).setCellStyle(style);

		header.createCell(49).setCellValue("S4A1C");
		header.getCell(49).setCellStyle(style);

		header.createCell(50).setCellValue("Ready To Teach");
		header.getCell(50).setCellStyle(style);

		header.createCell(51).setCellValue("Data Source	Error");
		header.getCell(51).setCellStyle(style);

		style = workbook.createCellStyle();
		font = workbook.createFont();
		font.setFontName("Sans-serif");
		//style.setFillForegroundColor(HSSFColor.BLUE.index);
		//style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		//font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setBorderRight(CellStyle.BORDER_THIN);
		// create data rows
		int rowCount = 1;
 	
		for (CapData record : records) {
			
			for (String error : record.getErrors()) {
				
				HSSFRow aRow = sheet.createRow(rowCount++);
				aRow.createCell(0).setCellValue(record.getCol0());
				aRow.getCell(0).setCellStyle(style);			
				aRow.createCell(1).setCellValue(record.getCol1());
				aRow.getCell(1).setCellStyle(style);
				aRow.createCell(2).setCellValue(record.getCol2());
				aRow.getCell(2).setCellStyle(style);
				aRow.createCell(3).setCellValue(record.getCol3());
				aRow.getCell(3).setCellStyle(style);
				aRow.createCell(4).setCellValue(record.getCol4());
				aRow.getCell(4).setCellStyle(style);
				aRow.createCell(5).setCellValue(record.getCol5());
				aRow.getCell(5).setCellStyle(style);
				aRow.createCell(6).setCellValue(record.getCol6());
				aRow.getCell(6).setCellStyle(style);
				aRow.createCell(7).setCellValue(record.getCol7());
				aRow.getCell(7).setCellStyle(style);
				aRow.createCell(8).setCellValue(record.getCol8());
				aRow.getCell(8).setCellStyle(style);
				aRow.createCell(9).setCellValue(record.getCol9());
				aRow.getCell(9).setCellStyle(style);
				aRow.createCell(10).setCellValue(record.getCol10());
				aRow.getCell(10).setCellStyle(style);
				aRow.createCell(11).setCellValue(record.getCol11());
				aRow.getCell(11).setCellStyle(style);
				aRow.createCell(12).setCellValue(record.getCol12());
				aRow.getCell(012).setCellStyle(style);
				aRow.createCell(13).setCellValue(record.getCol13());
				aRow.getCell(13).setCellStyle(style);
				aRow.createCell(14).setCellValue(record.getCol14());
				aRow.getCell(14).setCellStyle(style);
				aRow.createCell(15).setCellValue(record.getCol15());
				aRow.getCell(15).setCellStyle(style);
				aRow.createCell(16).setCellValue(record.getCol16());
				aRow.getCell(16).setCellStyle(style);
				aRow.createCell(17).setCellValue(record.getCol17());
				aRow.getCell(17).setCellStyle(style);
				aRow.createCell(18).setCellValue(record.getCol18());
				aRow.getCell(18).setCellStyle(style);
				aRow.createCell(19).setCellValue(record.getCol19());
				aRow.getCell(19).setCellStyle(style);
				aRow.createCell(20).setCellValue(record.getCol20());
				aRow.getCell(20).setCellStyle(style);				
				aRow.createCell(21).setCellValue(record.getCol21());
				aRow.getCell(21).setCellStyle(style);
				aRow.createCell(22).setCellValue(record.getCol22());
				aRow.getCell(22).setCellStyle(style);
				aRow.createCell(23).setCellValue(record.getCol23());
				aRow.getCell(23).setCellStyle(style);
				aRow.createCell(24).setCellValue(record.getCol24());
				aRow.getCell(24).setCellStyle(style);
				aRow.createCell(25).setCellValue(record.getCol25());
				aRow.getCell(25).setCellStyle(style);
				aRow.createCell(26).setCellValue(record.getCol26());
				aRow.getCell(26).setCellStyle(style);
				aRow.createCell(27).setCellValue(record.getCol27());
				aRow.getCell(27).setCellStyle(style);
				aRow.createCell(28).setCellValue(record.getCol28());
				aRow.getCell(28).setCellStyle(style);
				aRow.createCell(29).setCellValue(record.getCol29());
				aRow.getCell(29).setCellStyle(style);
				aRow.createCell(30).setCellValue(record.getCol30());
				aRow.getCell(30).setCellStyle(style);
				aRow.createCell(31).setCellValue(record.getCol31());
				aRow.getCell(31).setCellStyle(style);
				aRow.createCell(32).setCellValue(record.getCol32());
				aRow.getCell(32).setCellStyle(style);
				aRow.createCell(33).setCellValue(record.getCol33());
				aRow.getCell(33).setCellStyle(style);
				aRow.createCell(34).setCellValue(record.getCol34());
				aRow.getCell(34).setCellStyle(style);
				aRow.createCell(35).setCellValue(record.getCol35());
				aRow.getCell(35).setCellStyle(style);
				aRow.createCell(36).setCellValue(record.getCol36());
				aRow.getCell(36).setCellStyle(style);
				aRow.createCell(37).setCellValue(record.getCol37());
				aRow.getCell(37).setCellStyle(style);
				aRow.createCell(38).setCellValue(record.getCol38());
				aRow.getCell(38).setCellStyle(style);
				aRow.createCell(39).setCellValue(record.getCol39());
				aRow.getCell(39).setCellStyle(style);
				aRow.createCell(40).setCellValue(record.getCol40());
				aRow.getCell(40).setCellStyle(style);
				aRow.createCell(41).setCellValue(record.getCol41());
				aRow.getCell(41).setCellStyle(style);
				aRow.createCell(42).setCellValue(record.getCol42());
				aRow.getCell(42).setCellStyle(style);
				aRow.createCell(43).setCellValue(record.getCol43());
				aRow.getCell(43).setCellStyle(style);
				aRow.createCell(44).setCellValue(record.getCol44());
				aRow.getCell(44).setCellStyle(style);
				aRow.createCell(45).setCellValue(record.getCol45());
				aRow.getCell(45).setCellStyle(style);
				aRow.createCell(46).setCellValue(record.getCol46());
				aRow.getCell(46).setCellStyle(style);
				aRow.createCell(47).setCellValue(record.getCol47());
				aRow.getCell(47).setCellStyle(style);
				aRow.createCell(48).setCellValue(record.getCol48());
				aRow.getCell(48).setCellStyle(style);
				aRow.createCell(49).setCellValue(record.getCol49());
				aRow.getCell(49).setCellStyle(style);
				aRow.createCell(50).setCellValue(record.getCol50());
				aRow.getCell(50).setCellStyle(style);
				aRow.createCell(51).setCellValue(error);
				sheet.setColumnWidth(51, 65280);
				aRow.getCell(51).setCellStyle(style);

			}
			
			if(record.getErrors().size()>1){
			for(int i=0;i<=50;i++){
				sheet.addMergedRegion(new CellRangeAddress(rowCount-(record.getErrors().size()),rowCount-1,i,i));
			}
			}

		}

		return workbook;
	}

}
