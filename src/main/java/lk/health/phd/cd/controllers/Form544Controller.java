package lk.health.phd.cd.controllers;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

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
import lk.health.phd.cd.dto.Form544FilterDto;
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

	/**
	 * 
	 * Controller for submit Form544.
	 * 
	 * @param inNic
	 *            patient national identity card
	 * @param inInstitute
	 *            where patient is admitted
	 * @param inDiseaseId
	 *            ID value of the specific disease
	 * @param inPatientName
	 *            patient name
	 * @param inDateOfOnset
	 *            Patient's onset date
	 * @param inPeaditiricPatientsGurdianName
	 *            Pediatric patients guardian name
	 * @param inDateOfAdmission
	 *            date of admission
	 * @param inBhtNo
	 *            Bead head ticket number
	 * @param inWard
	 *            Ward number
	 * @param inAge
	 *            Age of patient
	 * @param inSex
	 *            Sex of patient
	 * @param inPatientHomeAddress
	 *            Address of the patient
	 * @param inPatientsHomePhoneNo
	 *            patient phone number
	 * @param inNotifierName
	 *            notifier name
	 * @param inNotifierStatus
	 *            notifier status
	 * @return
	 */
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String saveForm544(@RequestParam("nic") final String inNic,
			@RequestParam("institute") final String inInstitute, @RequestParam("disease") final Long inDiseaseId,
			@RequestParam("patientName") final String inPatientName,
			@RequestParam("dateOfOnset") final String inDateOfOnset,
			@RequestParam("peaditiricPatientsGurdianName") final String inPeaditiricPatientsGurdianName,
			@RequestParam("dateOfAdmission") final String inDateOfAdmission, @RequestParam("bhtNo") final Long inBhtNo,
			@RequestParam("ward") final String inWard, @RequestParam("age") final Integer inAge,
			@RequestParam("sex") final Form544.Sex inSex,
			@RequestParam("patientHomeAddress") final String inPatientHomeAddress,
			@RequestParam("patientsHomePhoneNo") final String inPatientsHomePhoneNo,
			@RequestParam("notifierName") final String inNotifierName,
			@RequestParam("notifierStatus") final String inNotifierStatus) {

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

	/**
	 * View the saved Form544 details by given ID.
	 * 
	 * @param inform544Id
	 *            Form544 ID
	 * @return
	 */
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

	/**
	 * Update Form544 details.
	 * 
	 * @param inForm544Id
	 *            Existing form 544 ID
	 * @param inNic
	 *            National ID number of the patient.
	 * @param inInstitute
	 *            Institute where patient is admitted.
	 * @param inDiseaseId
	 *            {@link Disease} ID related to the particular patient.
	 * @param inPatientName
	 *            Patient's name
	 * @param inDateOfOnset
	 *            Patient date of onset
	 * @param inPeaditiricPatientsGurdianName
	 *            Pediatric patients guardian name
	 * @param inDateOfAdmission
	 *            Date of admission
	 * @param inBhtNo
	 *            Bead head ticket number
	 * @param inWard
	 *            Ward number where patient is admitted.
	 * @param inAge
	 *            Age of the patient
	 * @param inSex
	 *            {@link Sex} of the patient
	 * @param inPatientHomeAddress
	 *            Patient's home address
	 * @param inPatientsHomePhoneNo
	 *            Patient's home phone number
	 * @param inNotifierName
	 *            Notifier name
	 * @param inNotifierStatus
	 *            Notifier status
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateForm544(@RequestParam("form544Id") final Long inForm544Id,
			@RequestParam("nic") final String inNic, @RequestParam("institute") final String inInstitute,
			@RequestParam("disease") final Long inDiseaseId, @RequestParam("patientName") final String inPatientName,
			@RequestParam("dateOfOnset") final String inDateOfOnset,
			@RequestParam("peaditiricPatientsGurdianName") final String inPeaditiricPatientsGurdianName,
			@RequestParam("dateOfAdmission") final String inDateOfAdmission, @RequestParam("bhtNo") final Long inBhtNo,
			@RequestParam("ward") final String inWard, @RequestParam("age") final Integer inAge,
			@RequestParam("sex") final Form544.Sex inSex,
			@RequestParam("patientHomeAddress") final String inPatientHomeAddress,
			@RequestParam("patientsHomePhoneNo") final String inPatientsHomePhoneNo,
			@RequestParam("notifierName") final String inNotifierName,
			@RequestParam("notifierStatus") final String inNotifierStatus) {

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

	@RequestMapping(value = "/filterBy", method = RequestMethod.POST)
	public ModelMap searchForm544ByCriteria(@RequestParam("nic") final String inPatientNic,
			@RequestParam("institute") final String inInstitute, @RequestParam("disease") final Long inDiseaseId,
			@RequestParam("patientName") final String inPatientName, @RequestParam("bhtNo") final Long inBhtNo,
			@RequestParam("ward") final String inWard, @RequestParam("sex") final Form544.Sex inSex,
			@RequestParam("nic") final String inNic, @RequestParam("notifierName") final String inNotifierName,
			@RequestParam("dateOfOnsetFrom") final String inDateOfOnsetFrom,
			@RequestParam("dateOfOnsetTo") final String inDateOfOnsetTo,
			@RequestParam("dateOfAdmissionFrom") final String inDateOfAdmissionFrom,
			@RequestParam("dateOfAdmissionTo") final String inDateOfAdmissionTo,
			@RequestParam("ageFrom") final Integer inAgeFrom, @RequestParam("ageTo") final Integer inAgeTo,
			@RequestParam("offset") final Integer inOffset, @RequestParam("limit") final Integer inLimit) {

		logger.info("Hit the /Form544/filterBy ");

		try {
			Form544FilterDto form544FilterDto = new Form544FilterDto();
			form544FilterDto.setBhtNo(inBhtNo);
			form544FilterDto.setDisease(getDisease(inDiseaseId));
			form544FilterDto.setInstitute(inInstitute);
			form544FilterDto.setPatientName(inPatientName);
			form544FilterDto.setPatientNic(inPatientNic);
			form544FilterDto.setSex(inSex);
			form544FilterDto.setWard(inWard);
			form544FilterDto.setNotifierName(inNotifierName);
			form544FilterDto.setAgeFrom(inAgeFrom);
			form544FilterDto.setAgeTo(inAgeTo);
			form544FilterDto.setDateOfAdmissionFrom(Util.parseDate(inDateOfAdmissionFrom, "dd/MM/yyyy"));
			form544FilterDto.setDateOfAdmissionTo(Util.parseDate(inDateOfAdmissionTo, "dd/MM/yyyy"));
			form544FilterDto.setDateOfOnsetFrom(Util.parseDate(inDateOfOnsetFrom, "dd/MM/yyyy"));
			form544FilterDto.setDateOfOnsetTo(Util.parseDate(inDateOfOnsetTo, "dd/MM/yyyy"));

			List<Form544> form544List = form544Dao.searchForm544BySearchFields(form544FilterDto, inOffset, inLimit);

			logger.info("Returned result set size : " + form544List.size());

			return null;
		} catch (Exception e) {
			logger.error("Error occured ", e);

			return null;
		}

	}

	private Disease getDisease(final Long inDiseaseId) {
		Disease disease = diseaeDao.findDiseaseById(inDiseaseId);

		return disease;
	}

}
