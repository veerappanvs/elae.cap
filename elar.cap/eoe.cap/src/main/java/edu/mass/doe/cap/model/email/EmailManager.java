package edu.mass.doe.cap.model.email;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import edu.mass.doe.EOEAuthorization.DirAdminAccessUtil;
import edu.mass.doe.EOEAuthorization.exception.NesterException;
import edu.mass.doe.EOEAuthorization.exception.NoPersonFoundException;
import edu.mass.doe.cap.controllers.CandidateEnrollmentController;
import edu.mass.doe.cap.dataservice.candidate.CandidateService;
import edu.mass.doe.cap.dataservice.email.CommunicationService;
import edu.mass.doe.cap.dataservice.email.EmailTypeService;
import edu.mass.doe.cap.dataservice.entity.Communication;
import edu.mass.doe.cap.dataservice.entity.EmailType;
import edu.mass.doe.cap.dataservice.pojo.CapCycleInfo;
import edu.mass.doe.cap.dataservice.pojo.CapManagerInfo;
import edu.mass.doe.cap.dataservice.pojo.SupervisorInfo;
import edu.mass.doe.cap.mail.EmailService;
import edu.mass.doe.cap.security.EOEUser;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

/**
 * The Class EmailManager.
 */
@Component

public class EmailManager {

	private static Logger logger = LoggerFactory.getLogger(EmailManager.class);

	@Autowired
	private EmailTypeService emailTypeService;

	@Autowired
	private CommunicationService communicationService;

	@Autowired(required = true)
	public EmailService emailService;
	
	@Autowired
	private CandidateService candidateService;

	@Autowired
	private Environment env;

	/**
	 * Creates the sp event.
	 *
	 * @param cycleId the cycle id
	 * @param program the program
	 * @param startDate the start date
	 * @param personId the person id
	 * @param orgId the org id
	 * @param userName the user name
	 * @param pwd the pwd
	 * @throws MessagingException the messaging exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TemplateException the template exception
	 */
	public void createSpEvent(Long cycleId, String program, String startDate, Long personId,Long orgId ,String userName,
			String pwd) throws MessagingException, IOException, TemplateException {
		try {
			EmailType emailType = emailTypeService.findByPrimaryKey("2");

			Map<String, Object> emailModel = new HashMap<String, Object>();

			emailModel.put("program", program);
			emailModel.put("startDate", startDate);
			emailModel.put("userName", userName);
			emailModel.put("pwd", pwd);
			String text = emailService.getTextMessage(emailModel, emailType.getTemplate());
			Communication communication = new Communication();
			communication.setCycleId(cycleId);
			communication.setTypeCode(emailType.getTypecode());
			communication.setFrom(env.getProperty("cap.mail.from"));
			communication.setSubject(emailType.getSubject());
			communication.setEffDate(new Date());
			communication.setFile(text);
			communication.setPersonId(personId);
			communication=communicationService.create(communication);
			String to =null;
			
			try {
				to = DirAdminAccessUtil.getUserEmail(DirAdminAccessUtil.getUserIDByDAPersonID(personId.intValue()),
						orgId);
				communication.setTo(to);
				text = emailService.email(emailModel, emailType.getSubject(), to, emailType.getTemplate());
				communication.setSentDate(new Date());
			}catch(Exception e){
				logger.error("Error in sending email " + personId
						+ " org id" + orgId,e);
			}
			communicationService.update(communication);
			
		} catch (Exception e) {
			logger.error("error in sending email", e);
		}

	}

	/**
	 * Creates the cycle event.
	 *
	 * @param cycleId the cycle id
	 * @param capCycleInfo the cap cycle info
	 * @throws MessagingException the messaging exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TemplateException the template exception
	 * @throws NesterException the nester exception
	 * @throws NoPersonFoundException the no person found exception
	 */
	public void createCycleEvent(Long cycleId, CapCycleInfo capCycleInfo)
			throws MessagingException, IOException, TemplateException, NesterException, NoPersonFoundException {
		Map<String, Object> emailModel = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
		String date = simpleDateFormat.format(capCycleInfo.getStartDate());
		
		EmailType emailType = emailTypeService.findByPrimaryKey("3");

		Communication communication = null;
		String to = null;
		emailModel = new HashMap<String, Object>();
		emailModel.put("program", capCycleInfo.getProgramName());
		emailModel.put("startDate", date);
		String text = emailService.getTextMessage(emailModel, emailType.getTemplate());
		
		try {	
		
			
			communication = new Communication();
			communication.setCycleId(capCycleInfo.getCycleId());
			communication.setTypeCode(emailType.getTypecode());			
			communication.setFrom(env.getProperty("cap.mail.from"));
			communication.setSubject(emailType.getSubject());
			communication.setEffDate(new Date());
			communication.setFile(text);
			communication.setPersonId(capCycleInfo.getPractitioner().getDaPersonId());
			communication=communicationService.create(communication);
			
			try {
				to = DirAdminAccessUtil
						.getUserEmail(
								DirAdminAccessUtil.getUserIDByDAPersonID(
										capCycleInfo.getPractitioner().getDaPersonId().intValue()),
								capCycleInfo.getOrgId());
				communication.setTo(to);
				text = emailService.email(emailModel, emailType.getSubject(), to, emailType.getTemplate());
				communication.setSentDate(new Date());

			}catch(Exception e){
				logger.error("Error in sending email " + capCycleInfo.getPractitioner().getDaPersonId()
						+ " org id" + capCycleInfo.getOrgId(),e);
			}
			
			communicationService.update(communication);
			
		} catch (Exception e) {
			logger.error("error in sending email", e);
		}

		try {
			emailType = emailTypeService.findByPrimaryKey("3");
			
			text = emailService.getTextMessage(emailModel, emailType.getTemplate());
			communication = new Communication();
			communication.setCycleId(capCycleInfo.getCycleId());
			communication.setTypeCode(emailType.getTypecode());
			communication.setFrom(env.getProperty("cap.mail.from"));
			communication.setSubject(emailType.getSubject());
			communication.setEffDate(new Date());
			communication.setFile(text);
			communication.setPersonId(capCycleInfo.getSupervisor().getDaPersonId());
			communication=communicationService.create(communication);
			
			try{
			to = DirAdminAccessUtil.getUserEmail(
					DirAdminAccessUtil.getUserIDByDAPersonID(capCycleInfo.getSupervisor().getDaPersonId().intValue()),
					capCycleInfo.getOrgId());
			communication.setTo(to);
			text = emailService.email(emailModel, emailType.getSubject(),  to,
					emailType.getTemplate());
			communication.setSentDate(new Date());
			}catch(Exception e){
				logger.error("Email Id not found for person id " + capCycleInfo.getSupervisor().getDaPersonId()
						+ " org id" + capCycleInfo.getOrgId(),e);
			}
			
			communicationService.update(communication);
			
		} catch (Exception e) {
			logger.error("error in sending email", e);
		}

		try {
			Long daPersonId=candidateService.getDaPersonId(capCycleInfo.getCandidatePersonId());
			
			emailType = emailTypeService.findByPrimaryKey("1");
			
			text = emailService.getTextMessage(emailModel, emailType.getTemplate());

			communication = new Communication();
			communication.setCycleId(capCycleInfo.getCycleId());
			communication.setTypeCode(emailType.getTypecode());
			communication.setFrom(env.getProperty("cap.mail.from"));
			communication.setSubject(emailType.getSubject());
			communication.setEffDate(new Date());
			communication.setFile(text);
			communication.setPersonId(daPersonId);
			communication=communicationService.create(communication);
			
			try{
			to = DirAdminAccessUtil.getElarEmailId(daPersonId.intValue());
			communication.setTo(to);
			emailService.email(emailModel, emailType.getSubject(), to,
					emailType.getTemplate());
			communication.setSentDate(new Date());
			}catch (Exception e) {
				logger.error("Email Id not found for Elar person id " + capCycleInfo.getCandidatePersonId()
				+ " org id" + capCycleInfo.getOrgId(),e);
			}

			communicationService.update(communication);
			
		} catch (Exception e) {
			logger.error("error in sending email", e);
		}
	}

	/**
	 * Adds the supervior event.
	 *
	 * @param cycleId the cycle id
	 * @param capCycleInfo the cap cycle info
	 * @throws MessagingException the messaging exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TemplateException the template exception
	 * @throws NesterException the nester exception
	 * @throws NoPersonFoundException the no person found exception
	 */
	public void addSuperviorEvent(Long cycleId, CapCycleInfo capCycleInfo)
				throws MessagingException, IOException, TemplateException, NesterException, NoPersonFoundException {
			Map<String, Object> emailModel = null;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
			String date = simpleDateFormat.format(capCycleInfo.getStartDate());
			
			EmailType emailType = emailTypeService.findByPrimaryKey("3");

			Communication communication = null;
			String to = null;
			emailModel = new HashMap<String, Object>();
			emailModel.put("program", capCycleInfo.getProgramName());
			emailModel.put("startDate", date);
			String text = emailService.getTextMessage(emailModel, emailType.getTemplate());
		
			try {
				emailType = emailTypeService.findByPrimaryKey("3");
				
				text = emailService.getTextMessage(emailModel, emailType.getTemplate());
			
				communication = new Communication();
				communication.setCycleId(capCycleInfo.getCycleId());
				communication.setTypeCode(emailType.getTypecode());
				communication.setFrom(env.getProperty("cap.mail.from"));
				communication.setSubject(emailType.getSubject());
				communication.setEffDate(new Date());
				communication.setFile(text);
				communication.setPersonId(capCycleInfo.getSupervisor().getDaPersonId());
				communication=communicationService.create(communication);
				
				try{
				to = DirAdminAccessUtil.getUserEmail(
						DirAdminAccessUtil.getUserIDByDAPersonID(capCycleInfo.getSupervisor().getDaPersonId().intValue()),
						capCycleInfo.getOrgId());
				communication.setTo(to);
				text = emailService.email(emailModel, emailType.getSubject(),  to,
						emailType.getTemplate());
				communication.setSentDate(new Date());
				}catch(Exception e){
					logger.error("Email Id not found for person id " + capCycleInfo.getSupervisor().getDaPersonId()
							+ " org id" + capCycleInfo.getOrgId(),e);
				}			
				
				communicationService.update(communication);
				
			} catch (Exception e) {
				logger.error("error in sending email", e);
			}
	}
	
	/**
	 * Adds the practitioner event.
	 *
	 * @param cycleId the cycle id
	 * @param capCycleInfo the cap cycle info
	 * @param practitioner the practitioner
	 * @throws TemplateNotFoundException the template not found exception
	 * @throws MalformedTemplateNameException the malformed template name exception
	 * @throws ParseException the parse exception
	 * @throws TemplateException the template exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void addPractitionerEvent(Long cycleId, CapCycleInfo capCycleInfo,SupervisorInfo practitioner) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, TemplateException, IOException{
		

		Map<String, Object> emailModel = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
		String date = simpleDateFormat.format(capCycleInfo.getStartDate());
		
		EmailType emailType = emailTypeService.findByPrimaryKey("3");

		Communication communication = null;
		String to = null;
		emailModel = new HashMap<String, Object>();
		emailModel.put("program", capCycleInfo.getProgramName());
		emailModel.put("startDate", date);
		String text = emailService.getTextMessage(emailModel, emailType.getTemplate());
	
		try {
			
			communication = new Communication();
			communication.setCycleId(capCycleInfo.getCycleId());
			communication.setTypeCode(emailType.getTypecode());
			communication.setFrom(env.getProperty("cap.mail.from"));
			communication.setSubject(emailType.getSubject());
			communication.setEffDate(new Date());
			communication.setFile(text);
			communication.setPersonId(practitioner.getDaPersonId());
			communication=communicationService.create(communication);
			
			try{
			to = DirAdminAccessUtil.getUserEmail(
					DirAdminAccessUtil.getUserIDByDAPersonID(practitioner.getDaPersonId().intValue()),
					capCycleInfo.getOrgId());
			text = emailService.email(emailModel, emailType.getSubject(), to, emailType.getTemplate());
			communication.setSentDate(new Date());
			communication.setTo(to);
			}catch(Exception e){
				logger.error("Email Id not found for person id " + practitioner.getDaPersonId()
				+ " org id" + capCycleInfo.getOrgId(),e);
			}
			
			communicationService.update(communication);
			
		} catch (Exception e) {
			logger.error("error in sending email", e);
		}

		
	}
	
	/**
	 * Cycle close.
	 *
	 * @param cycleId the cycle id
	 * @param capCycleInfo the cap cycle info
	 * @throws MessagingException the messaging exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TemplateException the template exception
	 */
	public void cycleClose(Long cycleId, CapCycleInfo capCycleInfo) throws MessagingException, IOException, TemplateException {
		EmailType emailType = null;
		Map<String, Object> emailModel = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
		String date = simpleDateFormat.format(capCycleInfo.getStartDate());

		Communication communication = null;
		String to = null;
		emailModel = new HashMap<String, Object>();
		emailModel.put("program", capCycleInfo.getProgramName());
		emailModel.put("startDate", date);
		emailType = emailTypeService.findByPrimaryKey("5");
		String text = emailService.getTextMessage(emailModel, emailType.getTemplate());
		try {
			
			Long daPersonId=candidateService.getDaPersonId(capCycleInfo.getCandidatePersonId());
			
			
			communication = new Communication();
			communication.setCycleId(capCycleInfo.getCycleId());
			communication.setTypeCode(emailType.getTypecode());
			communication.setFrom(env.getProperty("cap.mail.from"));
			communication.setSubject(emailType.getSubject());
			communication.setEffDate(new Date());
			communication.setFile(text);
			communication.setPersonId(daPersonId);
			communication=communicationService.create(communication);
			
			try{
			to = DirAdminAccessUtil.getElarEmailId(daPersonId.intValue());
			communication.setTo(to);
			text = emailService.email(emailModel, emailType.getSubject(), to,
					emailType.getTemplate());
			
			communication.setSentDate(new Date());
			}catch(Exception e){
				logger.error("Email Id not found for Elar person id " + capCycleInfo.getCandidatePersonId()
				+ " org id" + capCycleInfo.getOrgId(),e);
			}
			
			communicationService.update(communication);
			
		} catch (Exception e) {
			logger.error("error in sending email", e);
		}

	}
	
	/**
	 * Cycle auto close notification.
	 *
	 * @param cycleId the cycle id
	 * @param capCycleInfo the cap cycle info
	 * @param typeId the type id
	 * @param jobInfo the job info
	 * @throws MessagingException the messaging exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TemplateException the template exception
	 */
	public void cycleAutoCloseNotification(Long cycleId, CapCycleInfo capCycleInfo,String typeId,String jobInfo) throws MessagingException, IOException, TemplateException {
		EmailType emailType = null;
		Map<String, Object> emailModel = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
		String date = simpleDateFormat.format(capCycleInfo.getStartDate());
		Communication communication = null;
		emailModel = new HashMap<String, Object>();
		emailModel.put("program", capCycleInfo.getProgramName());
		emailModel.put("startDate", date);
		boolean isProd= System.getProperty("us.ma.state.edu.env_name").equals("prod");
		if(!isProd)
			emailModel.put("jobInfo", jobInfo);

		
		emailType = emailTypeService.findByPrimaryKey(typeId);
		
		String text = emailService.getTextMessage(emailModel, emailType.getTemplate());

		List<CapManagerInfo> managers = capCycleInfo.getManagers();
			
		for (CapManagerInfo capManagerInfo : managers) {
			try {
				
				communication = new Communication();
				communication.setCycleId(capCycleInfo.getCycleId());
				communication.setTypeCode(emailType.getTypecode());
				communication.setTo(capManagerInfo.getEmailId());
				communication.setFrom(env.getProperty("cap.mail.from"));
				communication.setSubject(emailType.getSubject());
				communication.setEffDate(new Date());
				communication.setFile(text);
				communication.setPersonId(capManagerInfo.getPersonId());
				communication=communicationService.create(communication);
				
				if (capManagerInfo.getEmailId() == null)
					throw new Exception("Email Id not found for person id " + capManagerInfo.getPersonId() + " org id"
							+ capCycleInfo.getOrgId());

				text = emailService.email(emailModel, emailType.getSubject(), capManagerInfo.getEmailId(),
						emailType.getTemplate());
				
				communication.setSentDate(new Date());
				communicationService.update(communication);

				
			} catch (Exception e) {
				logger.error("error in sending email", e);
			}
		}
		

	}
	
	
	/**
	 * Annual auto close notification.
	 *
	 * @param cycles the cycles
	 * @param typeId the type id
	 * @param jobInfo the job info
	 * @throws MessagingException the messaging exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TemplateException the template exception
	 */
	public void annualAutoCloseNotification(List<CapCycleInfo> cycles, String typeId,String jobInfo)
			throws MessagingException, IOException, TemplateException {

		Map<Long, CapManagerInfo> managers = new HashMap<Long, CapManagerInfo>();
		Map<Long,Boolean> emailConfirmation = new HashMap<Long,Boolean>();


		for (CapCycleInfo capCycleInfo : cycles) {
			for (CapManagerInfo manager : capCycleInfo.getManagers()) {
				managers.put(manager.getPersonId(), manager);
			}
		}

		EmailType emailType = null;
		Map<String, Object> emailModel = null;
		Communication communication = null;
		emailModel = new HashMap<String, Object>();
		boolean isProd= System.getProperty("us.ma.state.edu.env_name").equals("prod");
		if(!isProd)
			emailModel.put("jobInfo", jobInfo);

		emailType = emailTypeService.findByPrimaryKey(typeId);
		String text = emailService.getTextMessage(emailModel, emailType.getTemplate());


		for (Map.Entry<Long, CapManagerInfo> entry : managers.entrySet()) {
			CapManagerInfo capManagerInfo = entry.getValue();
			try {
				if (capManagerInfo.getEmailId() == null)
					throw new Exception("Email Id not found for person id " + capManagerInfo.getPersonId());

				text = emailService.email(emailModel, emailType.getSubject(), capManagerInfo.getEmailId(),
						emailType.getTemplate());
				
				emailConfirmation.put(capManagerInfo.getPersonId(), true);
			} catch (Exception e) {
				logger.error("error in sending email", e);
			}

		}

		
		text = emailService.getTextMessage(emailModel, emailType.getTemplate());

		for (CapCycleInfo capCycleInfo : cycles) {

			for (CapManagerInfo capManagerInfo : capCycleInfo.getManagers()) {

				try {
					communication = new Communication();
					communication.setCycleId(capCycleInfo.getCycleId());
					communication.setTypeCode(emailType.getTypecode());
					communication.setTo(capManagerInfo.getEmailId());
					communication.setFrom(env.getProperty("cap.mail.from"));
					communication.setSubject(emailType.getSubject());
					communication.setEffDate(new Date());
					communication.setFile(text);
					communication.setPersonId(capManagerInfo.getPersonId());
					communication = communicationService.create(communication);

					if (capManagerInfo.getEmailId() == null)
						throw new Exception("Email Id not found for person id " + capManagerInfo.getPersonId()
								+ " org id" + capCycleInfo.getOrgId());

					if (emailConfirmation.containsKey(capManagerInfo.getPersonId())) {
						communication.setSentDate(new Date());
						communicationService.update(communication);
					}

				} catch (Exception e) {
					logger.error("error in sending email", e);
				}
			}
		}

	}
	
	/**
	 * Cycle auto close.
	 *
	 * @param cycleId the cycle id
	 * @param capCycleInfo the cap cycle info
	 * @param typeId the type id
	 * @param jobInfo the job info
	 * @throws MessagingException the messaging exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TemplateException the template exception
	 */
	public void cycleAutoClose(Long cycleId, CapCycleInfo capCycleInfo,String typeId,String jobInfo) throws MessagingException, IOException, TemplateException {
		EmailType emailType = null;
		Map<String, Object> emailModel = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
		String date = simpleDateFormat.format(capCycleInfo.getStartDate());
		String text = "";
		Communication communication = null;
		String to = null;
		emailModel = new HashMap<String, Object>();
		emailModel.put("program", capCycleInfo.getProgramName());
		emailModel.put("startDate", date);
		boolean isProd= System.getProperty("us.ma.state.edu.env_name").equals("prod");
		if(!isProd)
			emailModel.put("jobInfo", jobInfo);

		try {
			emailType = emailTypeService.findByPrimaryKey(typeId);
			
			Long daPersonId=candidateService.getDaPersonId(capCycleInfo.getCandidatePersonId());
			
			
			text = emailService.getTextMessage(emailModel, emailType.getTemplate());
			communication = new Communication();
			communication.setCycleId(capCycleInfo.getCycleId());
			communication.setTypeCode(emailType.getTypecode());			
			communication.setFrom(env.getProperty("cap.mail.from"));
			communication.setSubject(emailType.getSubject());
			communication.setEffDate(new Date());
			communication.setFile(text);
			communication.setPersonId(daPersonId);
			communication=communicationService.create(communication);
	
			try{
				to = DirAdminAccessUtil.getElarEmailId(daPersonId.intValue());
				}catch(Exception e){
					logger.error("Email Id not found for Elar person id " + capCycleInfo.getCandidatePersonId()
					+ " org id" + capCycleInfo.getOrgId(),e);
				}
			communication.setTo(to);
			text = emailService.email(emailModel, emailType.getSubject(), to,
					emailType.getTemplate());
			communication.setSentDate(new Date());
			communicationService.update(communication);

			
		} catch (Exception e) {
			logger.error("error in sending email", e);
		}

	}
	
	
	/**
	 * Data deletion.
	 *
	 * @param cycleId the cycle id
	 * @param capCycleInfo the cap cycle info
	 * @throws MessagingException the messaging exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TemplateException the template exception
	 */
	public void dataDeletion(Long cycleId, CapCycleInfo capCycleInfo) throws MessagingException, IOException, TemplateException {
		EmailType emailType = null;
		Map<String, Object> emailModel = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
		String date = simpleDateFormat.format(capCycleInfo.getStartDate());
		String text = "";
		Communication communication = null;
		String to = null;
		emailModel = new HashMap<String, Object>();
		emailModel.put("program", capCycleInfo.getProgramName());
		emailModel.put("startDate", date);

		try {
			emailType = emailTypeService.findByPrimaryKey("6");
			
			to = DirAdminAccessUtil.getUserEmail(
					DirAdminAccessUtil.getUserIDByDAPersonID(capCycleInfo.getSupervisor().getDaPersonId().intValue()),
					capCycleInfo.getOrgId());
			if (to == null)
				throw new Exception("Email Id not found for person id " + capCycleInfo.getSupervisor().getDaPersonId()
						+ " org id" + capCycleInfo.getOrgId());

			text = emailService.email(emailModel, emailType.getSubject(), to, emailType.getTemplate());

			communication = new Communication();
			communication.setCycleId(capCycleInfo.getCycleId());
			communication.setTypeCode(emailType.getTypecode());
			communication.setTo(to);
			communication.setFrom(env.getProperty("cap.mail.from"));
			communication.setSubject(emailType.getSubject());
			communication.setEffDate(new Date());
			communication.setSentDate(new Date());
			communication.setFile(text);
			communication.setPersonId(capCycleInfo.getSupervisor().getDaPersonId());
			communicationService.create(communication);
		} catch (Exception e) {
			logger.error("error in sending email", e);
		}

	}
	
	/**
	 * Data deletion TC.
	 *
	 * @param cycleId the cycle id
	 * @param capCycleInfo the cap cycle info
	 * @throws MessagingException the messaging exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TemplateException the template exception
	 */
	public void DataDeletionTC(Long cycleId, CapCycleInfo capCycleInfo) throws MessagingException, IOException, TemplateException {
		EmailType emailType = null;
		Map<String, Object> emailModel = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
		String date = simpleDateFormat.format(capCycleInfo.getStartDate());
		String text = "";
		Communication communication = null;
		String to = null;
		emailModel = new HashMap<String, Object>();
		emailModel.put("program", capCycleInfo.getProgramName());
		emailModel.put("startDate", date);

		try {
			emailType = emailTypeService.findByPrimaryKey("7");
			
			Long daPersonId=candidateService.getDaPersonId(capCycleInfo.getCandidatePersonId());
			
			
			to = DirAdminAccessUtil.getElarEmailId(daPersonId.intValue());
			if (to == null)
				throw new Exception("Email Id not found for Elar person id " + capCycleInfo.getCandidatePersonId()
						+ " org id" + capCycleInfo.getOrgId());
			text = emailService.email(emailModel, emailType.getSubject(), to,
					emailType.getTemplate());

			communication = new Communication();
			communication.setCycleId(capCycleInfo.getCycleId());
			communication.setTypeCode(emailType.getTypecode());
			communication.setTo(to);
			communication.setFrom(env.getProperty("cap.mail.from"));
			communication.setSubject(emailType.getSubject());
			communication.setEffDate(new Date());
			communication.setSentDate(new Date());
			communication.setFile(text);
			communication.setPersonId(capCycleInfo.getCandidatePersonId());
			communicationService.create(communication);
		} catch (Exception e) {
			logger.error("error in sending email", e);
		}

	}
	
	/**
	 * New message.
	 *
	 * @param cycleId the cycle id
	 * @param capCycleInfo the cap cycle info
	 * @throws MessagingException the messaging exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TemplateException the template exception
	 */
	public void newMessage(Long cycleId, CapCycleInfo capCycleInfo) throws MessagingException, IOException, TemplateException {
		
		
		Long fromDaPersonId=((EOEUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getPersonId();
		
		EmailType emailType = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
		String date = simpleDateFormat.format(capCycleInfo.getStartDate());
		Communication communication = null;
		String to = null;
		final Map<String, Object>  emailModel = new HashMap<String, Object>();
		emailModel.put("program", capCycleInfo.getProgramName());
		emailModel.put("startDate", date);
		emailType = emailTypeService.findByPrimaryKey("8");
		String text = emailService.getTextMessage(emailModel, emailType.getTemplate());


		if(!fromDaPersonId.equals(capCycleInfo.getSupervisor().getDaPersonId())){
		try {
			
			communication = new Communication();
			communication.setCycleId(capCycleInfo.getCycleId());
			communication.setTypeCode(emailType.getTypecode());
			communication.setFrom(env.getProperty("cap.mail.from"));
			communication.setSubject(emailType.getSubject());
			communication.setEffDate(new Date());
			communication.setFile(text);
			communication.setPersonId(capCycleInfo.getSupervisor().getDaPersonId());
			communication=communicationService.create(communication);
			
			try{
			to = DirAdminAccessUtil.getUserEmail(
					DirAdminAccessUtil.getUserIDByDAPersonID(capCycleInfo.getSupervisor().getDaPersonId().intValue()),
					capCycleInfo.getOrgId());
			communication.setTo(to);
			text = emailService.email(emailModel, emailType.getSubject(), to, emailType.getTemplate());
			communication.setSentDate(new Date());
			}catch(Exception e){
				logger.error("Email Id not found for person id " + capCycleInfo.getSupervisor().getDaPersonId()
						+ " org id" + capCycleInfo.getOrgId(),e);
			}
			
			
			communicationService.update(communication);


			
		} catch (Exception e) {
			logger.error("error in sending email", e);
		}
		}
		
		

		List<SupervisorInfo> practitioners=	capCycleInfo.getPractitioners();
			
		practitioners.forEach(practitioner->{
			if(!fromDaPersonId.equals(practitioner.getDaPersonId())){
			try{
			EmailType eType = 	emailTypeService.findByPrimaryKey("8");;
			String emailText = emailService.getTextMessage(emailModel, eType.getTemplate());	
			
			Communication pcommunication = new Communication();
			pcommunication.setCycleId(capCycleInfo.getCycleId());
			pcommunication.setTypeCode(eType.getTypecode());
			
			pcommunication.setFrom(env.getProperty("cap.mail.from"));
			pcommunication.setSubject(eType.getSubject());
			pcommunication.setEffDate(new Date());
			pcommunication.setFile(emailText);
			pcommunication.setPersonId(practitioner.getDaPersonId());
			pcommunication=communicationService.create(pcommunication);
			try{
			String toEmail= DirAdminAccessUtil.getUserEmail(
					DirAdminAccessUtil.getUserIDByDAPersonID(practitioner.getDaPersonId().intValue()),
					capCycleInfo.getOrgId());
			 pcommunication.setTo(toEmail);
			 emailService.email(emailModel, eType.getSubject(), toEmail, eType.getTemplate());
			 pcommunication.setSentDate(new Date());
			
			}catch(Exception e){
				logger.error("Email Id not found for person id " + practitioner.getDaPersonId()
				+ " org id" + capCycleInfo.getOrgId(),e);
			}
			 communicationService.update(pcommunication);


			} catch (Exception e) {
				logger.error("error in sending email", e);
			}
			}});
			
		if(!fromDaPersonId.equals(capCycleInfo.getCandidatePersonId())){
		try {
			emailType = emailTypeService.findByPrimaryKey("9");
			text = emailService.getTextMessage(emailModel, emailType.getTemplate());	
			Long daPersonId=candidateService.getDaPersonId(capCycleInfo.getCandidatePersonId());
			communication = new Communication();
			communication.setCycleId(capCycleInfo.getCycleId());
			communication.setTypeCode(emailType.getTypecode());
			communication.setFrom(env.getProperty("cap.mail.from"));
			communication.setSubject(emailType.getSubject());
			communication.setEffDate(new Date());
			communication.setFile(text);
			communication.setPersonId(daPersonId);
			communication=communicationService.create(communication);
			
			try{
			to = DirAdminAccessUtil.getElarEmailId(daPersonId.intValue());
			communication.setTo(to);			
			text = emailService.email(emailModel, emailType.getSubject(), to,
					emailType.getTemplate());
			communication.setSentDate(new Date());
			}catch(Exception e){
				logger.error("Email Id not found for Elar person id " + capCycleInfo.getCandidatePersonId()
				+ " org id" + capCycleInfo.getOrgId(),e);
			}
			
			communicationService.update(communication);
		} catch (Exception e) {
			logger.error("error in sending email", e);
		}
		}

	}
	
	
	
	
	
}
