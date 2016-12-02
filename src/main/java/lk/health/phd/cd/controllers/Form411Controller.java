package lk.health.phd.cd.controllers;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import lk.health.phd.cd.dao.DiseaseDao;
import lk.health.phd.cd.dao.Form411Dao;
import lk.health.phd.cd.dao.WorkflowDao;
import lk.health.phd.cd.models.Disease;
import lk.health.phd.cd.models.Form411;
import lk.health.phd.cd.models.PatientContacts;
import lk.health.phd.cd.models.Workflow;
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
			form411.setPatientContacts(convertJsonArrayToContactPersonList(inContacts));
			form411.setPatientName(inName);
			form411.setPatientsMovements(inPatientMovement);
			form411.setSex(inSex);
			form411.setWhereIsolated(inIsolated);
			form411.setPhiRange(inPhiRange);

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

	private List<PatientContacts> convertJsonArrayToContactPersonList(final String inJsonString) {
		List<PatientContacts> patientContactList = new ArrayList<PatientContacts>();
		try {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

			Type collectionType = new TypeToken<Collection<PatientContacts>>() {
			}.getType();
			patientContactList = gson.fromJson(inJsonString, collectionType);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return patientContactList;
	}
}
