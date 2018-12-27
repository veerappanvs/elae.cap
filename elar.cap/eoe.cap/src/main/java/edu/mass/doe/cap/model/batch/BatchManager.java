package edu.mass.doe.cap.model.batch;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import edu.mass.doe.EOEAuthorization.exception.NesterException;
import edu.mass.doe.EOEAuthorization.exception.NoOrganizationFoundException;
import edu.mass.doe.EOEAuthorization.exception.NoPersonFoundException;
import edu.mass.doe.cap.dataservice.assessment.AssessmentService;
import edu.mass.doe.cap.dataservice.assessment.AssessmentTypeService;
import edu.mass.doe.cap.dataservice.assessment.DimensionService;
import edu.mass.doe.cap.dataservice.assessment.ElementRatingService;
import edu.mass.doe.cap.dataservice.assessment.ElementTypeService;
import edu.mass.doe.cap.dataservice.assessment.RatingTypeService;
import edu.mass.doe.cap.dataservice.batch.BatchService;
import edu.mass.doe.cap.dataservice.batch.BatchStagingService;
import edu.mass.doe.cap.dataservice.batch.UploadedDataService;
import edu.mass.doe.cap.dataservice.batch.UploadedRatingService;
import edu.mass.doe.cap.dataservice.entity.Batch;
import edu.mass.doe.cap.dataservice.entity.BatchStaging;
import edu.mass.doe.cap.dataservice.entity.DimensionType;
import edu.mass.doe.cap.dataservice.entity.ElementRating;
import edu.mass.doe.cap.dataservice.entity.ElementType;
import edu.mass.doe.cap.dataservice.entity.UploadedData;
import edu.mass.doe.cap.dataservice.entity.UploadedRating;
import edu.mass.doe.cap.dataservice.pojo.BatchInfo;
import edu.mass.doe.cap.dataservice.pojo.CandidateInfo;
import edu.mass.doe.cap.dataservice.pojo.CapData;
import edu.mass.doe.cap.dataservice.pojo.DimensionInfo;
import edu.mass.doe.cap.dataservice.pojo.ElementInfo;
import edu.mass.doe.cap.dataservice.pojo.ImportedCapInfo;
import edu.mass.doe.cap.dataservice.pojo.RatingInfo;
import edu.mass.doe.cap.dataservice.pojo.SupervisorInfo;
import edu.mass.doe.cap.model.assessment.AssessmentManager;
import edu.mass.doe.cap.model.candidate.CandidateManager;
import edu.mass.doe.cap.security.EOEUser;

/**
 * The Class BatchManager.
 */
@Component
public class BatchManager {
	private static Logger logger = LoggerFactory.getLogger(BatchManager.class);


	@Autowired
	private BatchService batchservice;

	@Autowired
	private BatchStagingService batchStagingService;

	@Autowired
	private ElementTypeService elementTypeService;

	@Autowired
	private ElementRatingService elementRatingService;

	@Autowired
	private DimensionService dimensionService;

	@Autowired
	private CandidateManager candidateManager;

	@Autowired
	private UploadedDataService uploadedDataService;

	@Autowired
	private UploadedRatingService uploadedRatingService;

	@Autowired
	private RatingTypeService ratingTypeService;

	/**
	 * Upload staging.
	 *
	 * @param fileName the file name
	 * @param records the records
	 * @param batchInfo the batch info
	 */
	public void uploadStaging(String fileName, List<CapData> records, BatchInfo batchInfo) {

		Long personId = ((EOEUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getPersonId();

		Batch batch = new Batch();
		batch.setCode("101");
		batch.setPersonId(personId);
		batch.setFileName(fileName);
		batch.setInternalFileName(fileName);
		batch.setEffDate(new Date());
		List<BatchStaging> batchRecords = new ArrayList<BatchStaging>();
		batch.setRecords(batchRecords);

		records.stream().forEach(record -> {
			BatchStaging batchRecord = new BatchStaging();
			batchRecord.setBatch(batch);
			batchRecord.setEffDate(new Date());
			batchRecord.setCol0(record.getCol0());
			batchRecord.setCol1(record.getCol1());
			batchRecord.setCol2(record.getCol2());
			batchRecord.setCol3(record.getCol3());
			batchRecord.setCol4(record.getCol4());
			batchRecord.setCol5(record.getCol5());
			batchRecord.setCol6(record.getCol6());
			batchRecord.setCol7(record.getCol7());
			batchRecord.setCol8(record.getCol8());
			batchRecord.setCol9(record.getCol9());
			batchRecord.setCol10(record.getCol10());
			batchRecord.setCol11(record.getCol11());
			batchRecord.setCol12(record.getCol12());
			batchRecord.setCol15(record.getCol13());
			batchRecord.setCol16(record.getCol14());
			batchRecord.setCol17(record.getCol15());
			batchRecord.setCol18(record.getCol16());
			batchRecord.setCol19(record.getCol17());
			batchRecord.setCol20(record.getCol18());
			batchRecord.setCol21(record.getCol19());
			batchRecord.setCol22(record.getCol20());
			batchRecord.setCol23(record.getCol21());
			batchRecord.setCol24(record.getCol22());
			batchRecord.setCol25(record.getCol23());
			batchRecord.setCol26(record.getCol24());
			batchRecord.setCol27(record.getCol25());
			batchRecord.setCol28(record.getCol26());
			batchRecord.setCol29(record.getCol27());
			batchRecord.setCol30(record.getCol28());
			batchRecord.setCol31(record.getCol29());
			batchRecord.setCol32(record.getCol30());
			batchRecord.setCol33(record.getCol31());
			batchRecord.setCol34(record.getCol32());
			batchRecord.setCol35(record.getCol33());
			batchRecord.setCol36(record.getCol34());
			batchRecord.setCol37(record.getCol35());
			batchRecord.setCol38(record.getCol36());
			batchRecord.setCol39(record.getCol37());
			batchRecord.setCol40(record.getCol38());
			batchRecord.setCol41(record.getCol39());
			batchRecord.setCol42(record.getCol40());
			batchRecord.setCol43(record.getCol41());
			batchRecord.setCol44(record.getCol42());
			batchRecord.setCol45(record.getCol43());
			batchRecord.setCol46(record.getCol44());
			batchRecord.setCol47(record.getCol45());
			batchRecord.setCol48(record.getCol46());
			batchRecord.setCol49(record.getCol47());
			batchRecord.setCol50(record.getCol48());
			batchRecord.setCol51(record.getCol49());
			batchRecord.setCol52(record.getCol50());

			batchRecords.add(batchRecord);

		});

		Batch btch = batchservice.create(batch);
		int errCount = batchservice.load(btch).intValue();
		batchInfo.setBatchId(btch.getUploadId());
		batchInfo.setErrcount(errCount);
	}

	/**
	 * Download error.
	 *
	 * @param batchId the batch id
	 * @return the list
	 */
	public List<CapData> downloadError(Long batchId) {
		Batch batch = batchservice.findByPrimaryKey(batchId);

		List<BatchStaging> records = batch.getRecords();
		List<CapData> capRecords = new ArrayList<CapData>();

		records.stream().forEach(record -> {

			CapData batchRecord = new CapData();
			batchRecord.setCol0(record.getCol0());
			batchRecord.setCol1(record.getCol1());
			batchRecord.setCol2(record.getCol2());
			batchRecord.setCol3(record.getCol3());
			batchRecord.setCol4(record.getCol4());
			batchRecord.setCol5(record.getCol5());
			batchRecord.setCol6(record.getCol6());
			batchRecord.setCol7(record.getCol7());
			batchRecord.setCol8(record.getCol8());
			batchRecord.setCol9(record.getCol9());
			batchRecord.setCol10(record.getCol10());
			batchRecord.setCol11(record.getCol11());
			batchRecord.setCol12(record.getCol12());
			batchRecord.setCol13(record.getCol15());
			batchRecord.setCol14(record.getCol16());
			batchRecord.setCol15(record.getCol17());
			batchRecord.setCol16(record.getCol18());
			batchRecord.setCol17(record.getCol19());
			batchRecord.setCol18(record.getCol20());
			batchRecord.setCol19(record.getCol21());
			batchRecord.setCol20(record.getCol22());
			batchRecord.setCol21(record.getCol23());
			batchRecord.setCol22(record.getCol24());
			batchRecord.setCol23(record.getCol25());
			batchRecord.setCol24(record.getCol26());
			batchRecord.setCol25(record.getCol27());
			batchRecord.setCol26(record.getCol28());
			batchRecord.setCol27(record.getCol29());
			batchRecord.setCol28(record.getCol30());
			batchRecord.setCol29(record.getCol31());
			batchRecord.setCol30(record.getCol32());
			batchRecord.setCol31(record.getCol33());
			batchRecord.setCol32(record.getCol34());
			batchRecord.setCol33(record.getCol35());
			batchRecord.setCol34(record.getCol36());
			batchRecord.setCol35(record.getCol37());
			batchRecord.setCol36(record.getCol38());
			batchRecord.setCol37(record.getCol39());
			batchRecord.setCol38(record.getCol40());
			batchRecord.setCol39(record.getCol41());
			batchRecord.setCol40(record.getCol42());
			batchRecord.setCol41(record.getCol43());
			batchRecord.setCol42(record.getCol44());
			batchRecord.setCol43(record.getCol45());
			batchRecord.setCol44(record.getCol46());
			batchRecord.setCol45(record.getCol47());
			batchRecord.setCol46(record.getCol48());
			batchRecord.setCol47(record.getCol49());
			batchRecord.setCol48(record.getCol50());
			batchRecord.setCol49(record.getCol51());
			batchRecord.setCol50(record.getCol52());

			List<String> errors = new ArrayList<String>();
			batchRecord.setErrors(errors);
			record.getErrors().forEach(error -> {
				errors.add(error.getDesc());
			});

			capRecords.add(batchRecord);

		});

		return capRecords;
	}

	/**
	 * Delete uploaded data.
	 *
	 * @param importId the import id
	 */
	public void deleteUploadedData(Long importId) {
		UploadedData uploadedData = uploadedDataService.findByPrimaryKey(importId);

		uploadedData.getRatings().stream().forEach(uploadedRating -> {
			uploadedRating.setExpDate(new Date());
			uploadedRatingService.update(uploadedRating);
		});

		uploadedData.setExpDate(new Date());

		uploadedDataService.update(uploadedData);
	}

	/**
	 * Gets the imported cap report.
	 *
	 * @param orgCode the org code
	 * @param year the year
	 * @return the imported cap report
	 * @throws RemoteException the remote exception
	 * @throws NesterException the nester exception
	 * @throws NoOrganizationFoundException the no organization found exception
	 * @throws NoPersonFoundException the no person found exception
	 */
	public List<ImportedCapInfo> getImportedCapReport(String orgCode,String year)
			throws RemoteException, NesterException, NoOrganizationFoundException, NoPersonFoundException {
		List<ImportedCapInfo> records = new ArrayList<ImportedCapInfo>();
		Calendar schoolEndDate = Calendar.getInstance();
		schoolEndDate.setTime(new Date());
		schoolEndDate.set(Calendar.MONTH, Calendar.JUNE);
		schoolEndDate.set(Calendar.DAY_OF_MONTH, 30);
		
		Calendar todaysDate = Calendar.getInstance();
		todaysDate.setTime(new Date());
		int yr= todaysDate.get(Calendar.YEAR);
		yr=todaysDate.compareTo(schoolEndDate)>0?yr+1:yr;
		String fromYear=year;
		String toYear=year;
		
		if(year.equals("0"))
			fromYear=String.valueOf(yr-2);
		
		if(year.equals("0"))
			toYear=String.valueOf(yr);
		records = uploadedDataService.getImportedCapInfoReport(orgCode, fromYear, toYear);

		return records;
	}

	/**
	 * Gets the uploaded data info.
	 *
	 * @param orgCode the org code
	 * @param uploadId the upload id
	 * @return the uploaded data info
	 * @throws NesterException the nester exception
	 * @throws NoOrganizationFoundException the no organization found exception
	 * @throws RemoteException the remote exception
	 * @throws NoPersonFoundException the no person found exception
	 */
	public ImportedCapInfo getUploadedDataInfo(String orgCode,Long uploadId)
			throws NesterException, NoOrganizationFoundException, RemoteException, NoPersonFoundException {
		return uploadedDataService.getImportedDataInfo(orgCode, uploadId);
	}
	
}
