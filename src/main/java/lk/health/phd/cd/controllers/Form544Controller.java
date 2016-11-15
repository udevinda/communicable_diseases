package lk.health.phd.cd.controllers;

import java.sql.Date;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lk.health.phd.cd.dao.DiseaseDao;
import lk.health.phd.cd.models.Disease;
import lk.health.phd.cd.models.Form544;
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

			workflowService.includeForm544(null, form544);

		} catch (Exception e) {
			logger.error("Error occured " + e);
		}

		return null;
	}

	private Disease getDisease(final Long inDiseaseId) {
		Disease disease = diseaeDao.findDiseaseById(inDiseaseId);

		return disease;
	}

}
