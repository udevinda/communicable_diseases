package lk.health.phd.cd.controllers;

import java.sql.Date;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lk.health.phd.cd.dao.DiseaseDao;
import lk.health.phd.cd.dao.Form544Dao;
import lk.health.phd.cd.models.Disease;
import lk.health.phd.cd.models.Form544;
import lk.health.phd.cd.services.Form544Service;
import lk.health.phd.cd.services.WorkflowService;
import lk.health.phd.util.Util;

/**
 * 
 * @author admin
 * 
 *         Controller for Form544.
 *
 */

@Controller
@RequestMapping("/Form544")
public class Form544Controller {

	@Autowired
	WorkflowService workflowService;

	@Autowired
	DiseaseDao diseaeDao;

	@Autowired
	Form544Dao form544Dao;

	@Autowired
	Form544Service form544Service;

	Logger logger = LoggerFactory.getLogger(Form544Controller.class);

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String saveForm544(@RequestParam("nic") String inNic, @RequestParam("institute") String inInstitute,
			@RequestParam("disease") Long inDiseaseId, @RequestParam("patientName") String inPatientName,
			@RequestParam("dateOfOnset") String inDateOfOnset,
			@RequestParam("peaditiricPatientsGurdianName") String inPeaditiricPatientsGurdianName,
			@RequestParam("dateOfAdmission") String inDateOfAdmission, @RequestParam("bhtNo") Long inBhtNo,
			@RequestParam("ward") String inWard, @RequestParam("age") Integer inAge,
			@RequestParam("sex") Form544.Sex inSex, @RequestParam("patientHomeAddress") String inPatientHomeAddress,
			@RequestParam("patientsHomePhoneNo") String inPatientsHomePhoneNo,
			@RequestParam("notifierName") String inNotifierName,
			@RequestParam("notifierStatus") String inNotifierStatus) {

		logger.info("Hit the /Form544/submit ");
		logger.info("Submitted user with NIC " + inNic);

		try {
			Form544 form544 = new Form544();
			form544.setAge(inAge);
			form544.setBhtNo(inBhtNo);
			form544.setDateOfAdmission(Util.parseDate(inDateOfAdmission, "dd/MM/yyyy"));
			form544.setDateOfOnset(Util.parseDate(inDateOfOnset, "dd/MM/yyyy"));
			form544.setDisease(getDisease(inDiseaseId));
			form544.setInstitute(inInstitute);
			form544.setNic(inNic);
			form544.setNotifierName(inNotifierName);
			form544.setNotifierStatus(inNotifierStatus);
			form544.setPatientHomeAddress(inPatientHomeAddress);
			form544.setPatientName(inPatientName);
			form544.setPatientsHomePhoneNo(inPatientsHomePhoneNo);
			form544.setPeaditiricPatientsGurdianName(inPeaditiricPatientsGurdianName);
			form544.setSex(inSex);
			form544.setSystemNotifiedDate(Util.getSystemTime());
			form544.setWard(inWard);

			// TODO Need to do backend validation

			workflowService.includeForm544(null, form544);

		} catch (Exception e) {
			logger.error("Error occured " + e);
		}

		return null;
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelMap viewForm544(@RequestParam("form544Id") final Long inform544Id) {

		logger.info("Hit the /Form544/view ");
		logger.info("Request view for Form544 ID " + inform544Id);

		Form544 form544 = form544Dao.findForm544ById(inform544Id);
		logger.info("Retrieved details for patient " + form544.getPatientName());

		ModelMap modelMap = new ModelMap();
		modelMap.put("age", form544.getAge());
		modelMap.put("bhtNo", form544.getBhtNo());
		modelMap.put("dateOfAdmission", form544.getDateOfAdmission());
		modelMap.put("dateOfOnset", form544.getDateOfOnset());
		modelMap.put("diseaseName", form544.getDisease().getDiseaseName());
		modelMap.put("institute", form544.getInstitute());
		modelMap.put("nic", form544.getNic());
		modelMap.put("notifierName", form544.getNotifierName());
		modelMap.put("notifierStatus", form544.getNotifierStatus());
		modelMap.put("patientHomeAddress", form544.getPatientHomeAddress());
		modelMap.put("patientName", form544.getPatientName());
		modelMap.put("patientHomePhoneNo", form544.getPatientsHomePhoneNo());
		modelMap.put("peaditiricPatientsGurdianName", form544.getPeaditiricPatientsGurdianName());
		modelMap.put("sex", form544.getSex());
		modelMap.put("systemNotifiedNae", form544.getSystemNotifiedDate());
		modelMap.put("ward", form544.getWard());
		modelMap.put("form544Id", form544.getId());

		return modelMap;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateForm544(@RequestParam("form544Id") Long inForm544Id, @RequestParam("nic") String inNic,
			@RequestParam("institute") String inInstitute, @RequestParam("disease") Long inDiseaseId,
			@RequestParam("patientName") String inPatientName, @RequestParam("dateOfOnset") String inDateOfOnset,
			@RequestParam("peaditiricPatientsGurdianName") String inPeaditiricPatientsGurdianName,
			@RequestParam("dateOfAdmission") String inDateOfAdmission, @RequestParam("bhtNo") Long inBhtNo,
			@RequestParam("ward") String inWard, @RequestParam("age") Integer inAge,
			@RequestParam("sex") Form544.Sex inSex, @RequestParam("patientHomeAddress") String inPatientHomeAddress,
			@RequestParam("patientsHomePhoneNo") String inPatientsHomePhoneNo,
			@RequestParam("notifierName") String inNotifierName,
			@RequestParam("notifierStatus") String inNotifierStatus) {

		logger.info("Hit the /Form544/update ");
		logger.info("Request update for Form544 ID " + inForm544Id);

		ModelMap modelMap = new ModelMap();

		try {
			Form544 form544 = new Form544();
			form544.setAge(inAge);
			form544.setBhtNo(inBhtNo);
			form544.setDateOfAdmission(Util.parseDate(inDateOfAdmission, "dd/MM/yyyy"));
			form544.setDateOfOnset(Util.parseDate(inDateOfOnset, "dd/MM/yyyy"));
			form544.setDisease(getDisease(inDiseaseId));
			form544.setInstitute(inInstitute);
			form544.setNic(inNic);
			form544.setNotifierName(inNotifierName);
			form544.setNotifierStatus(inNotifierStatus);
			form544.setPatientHomeAddress(inPatientHomeAddress);
			form544.setPatientName(inPatientName);
			form544.setPatientsHomePhoneNo(inPatientsHomePhoneNo);
			form544.setPeaditiricPatientsGurdianName(inPeaditiricPatientsGurdianName);
			form544.setSex(inSex);
			form544.setSystemNotifiedDate(Util.getSystemTime());
			form544.setWard(inWard);

			Form544 updatedForm544 = form544Service.updateForm544ById(inForm544Id, form544);
			modelMap.put("form544Id", updatedForm544.getId());
			logger.info("Form544 updated system time " + updatedForm544.getSystemNotifiedDate());
		} catch (Exception e) {
			logger.info("An error occured when updating Form544");
			logger.error("Error occured ", e);
		}

		return null;
	}

	private Disease getDisease(final Long inDiseaseId) {
		Disease disease = diseaeDao.findDiseaseById(inDiseaseId);

		return disease;
	}

}
