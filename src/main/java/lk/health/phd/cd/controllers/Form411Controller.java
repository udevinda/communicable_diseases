package lk.health.phd.cd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lk.health.phd.cd.dao.DiseaseDao;
import lk.health.phd.cd.dao.Form411Dao;
import lk.health.phd.cd.dao.PatientContactDao;
import lk.health.phd.cd.dao.WorkflowDao;
import lk.health.phd.cd.dto.Form411FilterDto;
import lk.health.phd.cd.models.Disease;
import lk.health.phd.cd.models.Form411;
import lk.health.phd.cd.models.Form411.Sex;
import lk.health.phd.cd.models.PatientContact;
import lk.health.phd.cd.services.Form411Service;
import lk.health.phd.cd.services.WorkflowService;
import lk.health.phd.util.Util;

/**
 * Controller for Form411
 * 
 * @author admin
 *
 */

@Controller
@RequestMapping("/Form411")
public class Form411Controller {

	Logger logger = LoggerFactory.getLogger(Form411Controller.class);

	@Autowired
	private DiseaseDao diseaeDao;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private WorkflowDao workflowDao;

	@Autowired
	private PatientContactDao patientContactDao;

	@Autowired
	private Form411Dao form411Dao;

	@Autowired
	private Form411Service form411Service;

	/**
	 * Submit form 411
	 * 
	 * @param inForm544Id
	 *            Related form 544 ID.
	 * @param inName
	 *            Name of the patient.
	 * @param inAge
	 *            Age of the patient.
	 * @param inSex
	 *            Sex of the patient.
	 * @param inAddress
	 *            Address of the patient.
	 * @param inEthnicGroup
	 *            Ethnic group of the patient.
	 * @param inNotifiedDiseaseId
	 *            ID of the notified disease.
	 * @param inDiseaseNotifiedDate
	 *            Date which the disease has been notified.
	 * @param inConfirmedDiseaseaid
	 *            ID of the confirmed disease.
	 * @param inDiseaseConfirmedDate
	 *            Date which Disease is confirmed.
	 * @param inDateOfOnset
	 *            Date which patient is onset.
	 * @param inDateOfHospitalization
	 *            Date which the patient was hospitalized.
	 * @param inDateOfDischarged
	 *            Date which the patient was discharged.
	 * @param inHospital
	 *            Name of the hospital where the patient is hospitalized.
	 * @param inOutcome
	 *            What happened to the patient.
	 * @param inIsolated
	 *            Where the patient was isolated.
	 * @param inPatientMovement
	 *            What are the movement of the patient in the time of as a
	 *            patient.
	 * @param inLaboratoryFindings
	 *            Laboratory findings related to disease.
	 * @param inContacts
	 *            Details of the people who were contacted by the patient during
	 *            the illness time period.
	 * @param inPhiRange
	 *            Related PHI area.
	 * @param inMohArea
	 *            Related MOH area.
	 * @param inLongitude
	 *            Longitude of the patients residence location.
	 * @param inLattitude
	 *            Latitude of the patients residence location.
	 * @param model
	 *            {@link Model}
	 * @return
	 */
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public @ResponseBody String saveForm411(@RequestParam("form544Id") final Long inForm544Id,
			@RequestParam("name") final String inName, @RequestParam("age") final Integer inAge,
			@RequestParam("sex") final Form411.Sex inSex, @RequestParam("address") final String inAddress,
			@RequestParam("ethnicGroup") final Form411.EthnicGroup inEthnicGroup,
			@RequestParam("notifiedDiseaseId") final Long inNotifiedDiseaseId,
			@RequestParam("diseaseNotifiedDate") final String inDiseaseNotifiedDate,
			@RequestParam("confirmedDiseaseId") final Long inConfirmedDiseaseaid,
			@RequestParam("diseaseConfirmedDate") final String inDiseaseConfirmedDate,
			@RequestParam("dateOfOnset") final String inDateOfOnset,
			@RequestParam("dateOfHospitalization") final String inDateOfHospitalization,
			@RequestParam("dateOfDischarged") final String inDateOfDischarged,
			@RequestParam("hospital") final String inHospital, @RequestParam("outcome") final Form411.Outcome inOutcome,
			@RequestParam("isolated") final Form411.WhereIsolated inIsolated,
			@RequestParam("patientMovement") final String inPatientMovement,
			@RequestParam("laboratoryFindings") final String inLaboratoryFindings,
			@RequestParam("contacts") final String inContacts, @RequestParam("phiRange") final String inPhiRange,
			@RequestParam("mohArea") final String inMohArea, @RequestParam("longitude") final Double inLongitude,
			@RequestParam("lattitude") final Double inLattitude, Model model) {

		logger.info("Hit the /Form411/submit ");
		logger.info("Submitted user with Form544 ID " + inForm544Id);

		try {
			Form411 form411 = new Form411();
			form411.setAge(inAge);
			form411.setDateOfDischarged(Util.parseDate(inDateOfDischarged, "yyyy-MM-dd"));
			form411.setDateOfHospitalization(Util.parseDate(inDateOfHospitalization, "yyyy-MM-dd"));
			form411.setDateOfOnset(Util.parseDate(inDateOfOnset, "yyyy-MM-dd"));
			form411.setDiseaseAsNotified(getDisease(inNotifiedDiseaseId));
			form411.setDiseaseConfirmed(getDisease(inConfirmedDiseaseaid));
			form411.setDiseaseConfirmedDate(Util.parseDate(inDiseaseConfirmedDate, "yyyy-MM-dd"));
			form411.setDiseaseNotifiedDate(Util.parseDate(inDiseaseNotifiedDate, "yyyy-MM-dd"));
			form411.setEthnicGroup(inEthnicGroup);
			form411.setLaboratoryFindings(inLaboratoryFindings);
			form411.setLattitude(inLattitude);
			form411.setLongitude(inLongitude);
			form411.setMohArea(inMohArea);
			form411.setNameOfHospital(inHospital);
			form411.setOutcome(inOutcome);
			form411.setPatientAddress(inAddress);
			form411.setPatientName(inName);
			form411.setPatientsMovements(inPatientMovement);
			form411.setSex(inSex);
			form411.setWhereIsolated(inIsolated);
			form411.setPhiRange(inPhiRange);

			// persistPatientContacts(form411, inContacts);
			form411.setPatientContact(convertJsonArrayToContactPersonList(form411, inContacts));
			// TODO Need to do backend validation

			Long workflowId = workflowService.includeForm411(inForm544Id, form411);

			Form411 submitedForm411 = workflowDao.findWorkflowById(workflowId).getForm411();

			model.addAttribute("form411Object", submitedForm411);

		} catch (Exception e) {
			logger.error("Error occured " + e);
		}

		return null;

	}

	/**
	 * View the content for the given Form 411 ID.
	 * 
	 * @param inForm411Id
	 *            Form 411 ID.
	 * @param model
	 *            {@link Model} to transfer date to the UI.
	 * @return form411_view.html page
	 */
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewForm411(@RequestParam("form411Id") final Long inForm411Id, Model model) {
		logger.info("Hit the /Form411/view ");
		logger.info("Request view for Form544 ID " + inForm411Id);

		Form411 form411 = form411Dao.findForm411ById(inForm411Id);
		logger.info("Retrieved details for patient " + form411.getPatientName());

		model.addAttribute("form411Object", form411);

		return "form411_view";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateForm411(@RequestParam("form411Id") final Long inForm411Id,
			@RequestParam("name") final String inName, @RequestParam("age") final Integer inAge,
			@RequestParam("sex") final Form411.Sex inSex, @RequestParam("address") final String inAddress,
			@RequestParam("ethnicGroup") final Form411.EthnicGroup inEthnicGroup,
			@RequestParam("notifiedDiseaseId") final Long inNotifiedDiseaseId,
			@RequestParam("diseaseNotifiedDate") final String inDiseaseNotifiedDate,
			@RequestParam("confirmedDiseaseId") final Long inConfirmedDiseaseaid,
			@RequestParam("diseaseConfirmedDate") final String inDiseaseConfirmedDate,
			@RequestParam("dateOfOnset") final String inDateOfOnset,
			@RequestParam("dateOfHospitalization") final String inDateOfHospitalization,
			@RequestParam("dateOfDischarged") final String inDateOfDischarged,
			@RequestParam("hospital") final String inHospital, @RequestParam("outcome") final Form411.Outcome inOutcome,
			@RequestParam("isolated") final Form411.WhereIsolated inIsolated,
			@RequestParam("patientMovement") final String inPatientMovement,
			@RequestParam("laboratoryFindings") final String inLaboratoryFindings,
			@RequestParam("contacts") final String inContacts, @RequestParam("phiRange") final String inPhiRange,
			@RequestParam("mohArea") final String inMohArea, @RequestParam("longitude") final Double inLongitude,
			@RequestParam("lattitude") final Double inLattitude, Model model) {

		logger.info("Hit the /Form411/update ");
		logger.info("Request update for Form411 ID " + inForm411Id);

		try {
			Form411 form411 = new Form411();
			form411.setAge(inAge);
			form411.setDateOfDischarged(Util.parseDate(inDateOfDischarged, "yyyy-MM-dd"));
			form411.setDateOfHospitalization(Util.parseDate(inDateOfHospitalization, "yyyy-MM-dd"));
			form411.setDateOfOnset(Util.parseDate(inDateOfOnset, "yyyy-MM-dd"));
			form411.setDiseaseAsNotified(getDisease(inNotifiedDiseaseId));
			form411.setDiseaseConfirmed(getDisease(inConfirmedDiseaseaid));
			form411.setDiseaseConfirmedDate(Util.parseDate(inDiseaseConfirmedDate, "yyyy-MM-dd"));
			form411.setDiseaseNotifiedDate(Util.parseDate(inDiseaseNotifiedDate, "yyyy-MM-dd"));
			form411.setEthnicGroup(inEthnicGroup);
			form411.setLaboratoryFindings(inLaboratoryFindings);
			form411.setLattitude(inLattitude);
			form411.setLongitude(inLongitude);
			form411.setMohArea(inMohArea);
			form411.setNameOfHospital(inHospital);
			form411.setOutcome(inOutcome);
			form411.setPatientAddress(inAddress);
			form411.setPatientName(inName);
			form411.setPatientsMovements(inPatientMovement);
			form411.setSex(inSex);
			form411.setWhereIsolated(inIsolated);
			form411.setPhiRange(inPhiRange);

			Form411 updatedForm411 = form411Service.updateForm411ById(inForm411Id, form411);
			model.addAttribute("form544Id", updatedForm411.getId());
			logger.info("Updated Form 411 ID : " + updatedForm411.getId());

		} catch (Exception e) {
			logger.info("An error occured when updating Form411");
			logger.error("Error occured ", e);
		}

		return "form411_create";

	}

	/**
	 * Controller for Form411 filtering.
	 * 
	 * @param inName
	 *            Name of the patient
	 * @param inAgeFrom
	 *            Beginning of age range to consider.
	 * @param inAgeTo
	 *            End of age range to consider
	 * @param inSex
	 *            {@link Form411.Sex} of the patient
	 * @param inEthnicGroup
	 *            {@link Form411.EthnicGroup} of the patient
	 * @param inNotifiedDiseaseId
	 *            Notified Disease ID
	 * @param inNotifiedDateFrom
	 *            Starting date of period to consider related to when a disease
	 *            is notified
	 * @param inNotifiedDateTo
	 *            End Date of period to consider related to when a disease is
	 *            notified.
	 * @param inConfirmrdDiseaseId
	 *            Disease ID
	 * @param inConfirmedDateFrom
	 *            Starting date of period to consider related to when a disease
	 *            is confirmed.
	 * @param inConfirmedDateTo
	 *            End date of period to consider related to when a disease is
	 *            confirmed.
	 * @param inDateOnsetFrom
	 *            Starting date of period to consider when On set.
	 * @param inDateOnsetTo
	 *            End date of period to consider when On set.
	 * @param inHospitalizedFrom
	 *            Starting date of period to consider when hospitalized.
	 * @param inHospitalizedTo
	 *            End date of period to consider when hospitalized.
	 * @param inDischargedFrom
	 *            Starting date of period to consider when discharged
	 * @param inDischargedTo
	 *            End date of period to consider when discharged
	 * @param inHospital
	 *            Name of the hospital
	 * @param inOutcome
	 *            {@link Form411.Outcome}
	 * @param inIsolated
	 *            {@link Form411.WhereIsolated}
	 * @param inPhiRange
	 *            PHI range to consider
	 * @param inMohRange
	 *            MOH range to consider
	 * @return JSONobject including the result record set
	 */
	@RequestMapping(value = "/filterBy", method = RequestMethod.POST)
	public @ResponseBody JSONObject searchForm411ByCriteria(@RequestParam("name") final String inName,
			@RequestParam("ageFrom") final Integer inAgeFrom, @RequestParam("ageTo") final Integer inAgeTo,
			@RequestParam("sex") final Form411.Sex inSex,
			@RequestParam("ethnicGroup") final Form411.EthnicGroup inEthnicGroup,
			@RequestParam("notifiedDiseaseId") final Long inNotifiedDiseaseId,
			@RequestParam("notifiedDateFrom") final String inNotifiedDateFrom,
			@RequestParam("notifiedDateTo") final String inNotifiedDateTo,
			@RequestParam("confirmedDiseaseId") final Long inConfirmrdDiseaseId,
			@RequestParam("confirmedDateFrom") final String inConfirmedDateFrom,
			@RequestParam("confirmedDateTo") final String inConfirmedDateTo,
			@RequestParam("dateOnsetFrom") final String inDateOnsetFrom,
			@RequestParam("dateOnsetTo") final String inDateOnsetTo,
			@RequestParam("hospitalizedFrom") final String inHospitalizedFrom,
			@RequestParam("hospitalizedTo") final String inHospitalizedTo,
			@RequestParam("dischargedFrom") final String inDischargedFrom,
			@RequestParam("dischargedTo") final String inDischargedTo,
			@RequestParam("hospital") final String inHospital, @RequestParam("outcome") final Form411.Outcome inOutcome,
			@RequestParam("isolated") final Form411.WhereIsolated inIsolated,
			@RequestParam("phiRange") final String inPhiRange, @RequestParam("mohRange") final String inMohRange,
			@RequestParam("offset") final Integer inOffset, @RequestParam("limit") final Integer inLimit) {

		logger.info("Hit the /Form411/filterBy ");

		try {
			Form411FilterDto form411FilterDto = new Form411FilterDto();

			form411FilterDto.setAgeFrom(inAgeFrom);
			form411FilterDto.setAgeTo(inAgeTo);
			form411FilterDto.setConfirmedDateFrom(Util.parseDate(inConfirmedDateFrom, "yyyy-MM-dd"));
			form411FilterDto.setConfirmedDateTo(Util.parseDate(inConfirmedDateTo, "yyyy-MM-dd"));
			form411FilterDto.setConfirmedDisease(getDisease(inConfirmrdDiseaseId));
			form411FilterDto.setDateOnsetFrom(Util.parseDate(inDateOnsetFrom, "yyyy-MM-dd"));
			form411FilterDto.setDateOnsetTo(Util.parseDate(inDateOnsetTo, "yyyy-MM-dd"));
			form411FilterDto.setDischargedFrom(Util.parseDate(inDischargedFrom, "yyyy-MM-dd"));
			form411FilterDto.setDischargedTo(Util.parseDate(inDischargedTo, "yyyy-MM-dd"));
			form411FilterDto.setEthnicGroup(inEthnicGroup);
			form411FilterDto.setHospital(inHospital);
			form411FilterDto.setHospitalizedFrom(Util.parseDate(inHospitalizedFrom, "yyyy-MM-dd"));
			form411FilterDto.setHospitalizedTo(Util.parseDate(inHospitalizedTo, "yyyy-MM-dd"));
			form411FilterDto.setIsolated(inIsolated);
			form411FilterDto.setMohRange(inMohRange);
			form411FilterDto.setNotifiedDateFrom(Util.parseDate(inNotifiedDateFrom, "yyyy-MM-dd"));
			form411FilterDto.setNotifiedDateTo(Util.parseDate(inNotifiedDateTo, "yyyy-MM-dd"));
			form411FilterDto.setNotifiedDisease(getDisease(inNotifiedDiseaseId));
			form411FilterDto.setOutcome(inOutcome);
			form411FilterDto.setPatientName(inName);
			form411FilterDto.setPhiRange(inPhiRange);
			form411FilterDto.setSex(inSex);

			List<Form411> form411s = form411Dao.searchForm411BySearchingFields(form411FilterDto, inOffset, inLimit);
			Long totalRowCount = form411Dao.searchCountForm411BySearchFields(form411FilterDto);

			JSONObject obj = new JSONObject();
			obj.put("form411List", form411s);
			obj.put("totalRowCount", totalRowCount);

			logger.info("Returned result set size : " + form411s.size());

			return obj;
		} catch (Exception e) {
			logger.error("Error occured ", e);

			return null;
		}

	}

	/**
	 * Return the disease object by ID.
	 * 
	 * @param inDiseaseId
	 *            ID of the considering disease.
	 * @return {@link Disease}
	 */
	private Disease getDisease(final Long inDiseaseId) {
		Disease disease = diseaeDao.findDiseaseById(inDiseaseId);

		return disease;
	}

	/**
	 * Convert sent JSON string to a JSON array and create PatientContact object
	 * list
	 * 
	 * @param inForm411
	 *            {@link Form411} object
	 * @param inJsonString
	 *            JSON string including person contact list.
	 * @return List of {@link PatientContact}
	 */
	private List<PatientContact> convertJsonArrayToContactPersonList(final Form411 inForm411,
			final String inJsonString) {
		List<PatientContact> patientContactList = new ArrayList<PatientContact>();

		try {
			Gson gson = new Gson();
			JsonParser jsonParser = new JsonParser();
			JsonArray jsonArray = (JsonArray) jsonParser.parse(inJsonString);

			for (int i = 0; i < jsonArray.size(); i++) {
				PatientContact patientContact = new PatientContact();
				JsonObject contactJsonObj = jsonArray.get(i).getAsJsonObject();
				patientContact.setName(contactJsonObj.get("name").toString().replaceAll("\"", ""));

				patientContact.setAge(Integer.parseInt(contactJsonObj.get("age").toString().replaceAll("\"", "")));
				patientContact.setObservation(contactJsonObj.get("observation").toString().replaceAll("\"", ""));
				patientContact.setDateSeen(
						Util.parseDate(contactJsonObj.get("dateSeen").toString().replaceAll("\"", ""), "yyyy-MM-dd"));

				patientContactList.add(patientContact);
			}

		} catch (Exception e) {
			logger.error("Error occured " + e);
		}

		return patientContactList;
	}

}
