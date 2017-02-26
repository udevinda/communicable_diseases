package lk.health.phd.cd.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import lk.health.phd.cd.dao.DiseaseConfirmationTestDao;
import lk.health.phd.cd.dao.Form544Dao;
import lk.health.phd.cd.dao.MohAreaDao;
import lk.health.phd.cd.dao.WorkflowDao;
import lk.health.phd.cd.dto.DiseaseVsPatientSummaryDto;
import lk.health.phd.cd.dto.MohAreaVsDiseaseSummaryDto;
import lk.health.phd.cd.models.DiseaseConfirmationTest;
import lk.health.phd.cd.models.District;
import lk.health.phd.cd.models.Form544;
import lk.health.phd.cd.models.MohArea;
import lk.health.phd.cd.services.Form544Service;
import lk.health.phd.cd.services.WorkflowService;

/**
 * 
 * @author admin
 *
 */

@Service("form544Service")
@Transactional
public class Form544ServiceImpl implements Form544Service {

	Logger logger = LoggerFactory.getLogger(Form544ServiceImpl.class);

	@Autowired
	private Form544Dao form544Dao;

	@Autowired
	private WorkflowDao workflowDao;

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private DiseaseConfirmationTestDao diseaseConfirmationTestDao;

	@Autowired
	private MohAreaDao mohAreaDao;

	/**
	 * {@inheritDoc}
	 */
	public Form544 updateForm544ById(final Long inForm544Id, final Form544 inForm544,
			final DiseaseConfirmationTest inDiseaseConfirmationTest) {

		// TODO validate for null
		Form544 form544 = form544Dao.findForm544ById(inForm544Id);
		logger.debug("Form544 ID : " + form544.getId() + " retrived from DB.");

		form544.setAge(inForm544.getAge());
		form544.setBhtNo(inForm544.getBhtNo());
		form544.setDateOfAdmission(inForm544.getDateOfAdmission());
		form544.setDateOfOnset(inForm544.getDateOfOnset());
		form544.setDisease(inForm544.getDisease());
		form544.setInstitute(inForm544.getInstitute());
		form544.setSerialNo(inForm544.getSerialNo());
		form544.setNotifierName(inForm544.getNotifierName());
		form544.setNotifierStatus(inForm544.getNotifierStatus());
		form544.setPatientHomeAddress(inForm544.getPatientHomeAddress());
		form544.setPatientName(inForm544.getPatientName());
		form544.setPatientsHomePhoneNo(inForm544.getPatientsHomePhoneNo());
		form544.setPeaditiricPatientsGurdianName(inForm544.getPeaditiricPatientsGurdianName());
		form544.setSex(inForm544.getSex());
		form544.setSystemNotifiedDate(inForm544.getSystemNotifiedDate());
		form544.setWard(inForm544.getWard());
		form544.setMohArea(inForm544.getMohArea());
		form544.setNotificationByUnitDate(inForm544.getNotificationByUnitDate());
		form544.setNotificationToMohDate(inForm544.getNotificationToMohDate());
		form544.setRemarks(inForm544.getRemarks());

		DiseaseConfirmationTest diseaseConfirmationTest = diseaseConfirmationTestDao
				.getDiseaseConfirmationTestByForm544Id(form544.getId());
		diseaseConfirmationTest.setNameOfLab(inDiseaseConfirmationTest.getNameOfLab());
		diseaseConfirmationTest.setResult(inDiseaseConfirmationTest.getResult());
		diseaseConfirmationTest.setSampleCollectionDate(inDiseaseConfirmationTest.getSampleCollectionDate());
		diseaseConfirmationTest.setTestName(inDiseaseConfirmationTest.getTestName());

		form544Dao.merge(form544);
		diseaseConfirmationTestDao.merge(diseaseConfirmationTest);
		logger.debug("Form544 ID : " + form544.getId() + " updated and persisted to DB.");

		return form544;
	}

	/**
	 * {@inheritDoc}
	 */
	public Form544 createForm544(final Form544 inForm544, final DiseaseConfirmationTest inDiseaseConfirmationTest) {
		Long workflowId = workflowService.includeForm544(null, inForm544);
		Form544 persistedForm544 = form544Dao
				.findForm544ById(workflowDao.findWorkflowById(workflowId).getForm544().getId());

		DiseaseConfirmationTest diseaseConfirmationTest = inDiseaseConfirmationTest;
		diseaseConfirmationTest.setForm544(persistedForm544);
		diseaseConfirmationTestDao.save(diseaseConfirmationTest);

		return persistedForm544;
	}

	/**
	 * {@inheritDoc}
	 */
	public String generateForm544SerialNo() {
		String serialNoMonthPart = form544Dao.getForm544CountForCurrentMonth() + "";
		String serialNoYearPart = form544Dao.getForm544CountForCurrentYear() + "";

		return serialNoMonthPart + "/" + serialNoYearPart;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<MohAreaVsDiseaseSummaryDto> generateMohAreaVaDiseaseSummary(final Long inDistrictId,
			final int inLowerDateYear, final int inLowerDateMonth, final int inUpperDateYear,
			final int inUpperDateMonth) {
		List<MohArea> mohAreas = mohAreaDao.getMohAreaByDistrictId(inDistrictId);
		List<MohAreaVsDiseaseSummaryDto> mohAreaVsDiseaseSummaryDtos = new ArrayList<MohAreaVsDiseaseSummaryDto>();

		String lowerDateLimit = inLowerDateYear + "-" + inLowerDateMonth + "-" + 1;
		String upperDateLimit = inUpperDateYear + "-" + inUpperDateMonth + "-" + 31;

		for (int i = 0; i < mohAreas.size(); i++) {
			List diseaseCountForGivenMohAreaList = form544Dao.getEachDiseaseCountForGivenMohArea(mohAreas.get(i),
					lowerDateLimit, upperDateLimit);
			List<DiseaseVsPatientSummaryDto> diseaseVsPatientSummaryDtos = new ArrayList<DiseaseVsPatientSummaryDto>();

			MohAreaVsDiseaseSummaryDto areaVsDiseaseSummaryDto = new MohAreaVsDiseaseSummaryDto();
			for (int x = 0; x < diseaseCountForGivenMohAreaList.size(); x++) {

				String diseaseCountForGivenMohAreaListItemJsonStr = new Gson()
						.toJson(diseaseCountForGivenMohAreaList.get(x));

				JsonParser jsonParser = new JsonParser();

				JsonElement diseaseCountForGivenMohAreaListItemJsonObj = jsonParser
						.parse(diseaseCountForGivenMohAreaListItemJsonStr);
				int patientCount = diseaseCountForGivenMohAreaListItemJsonObj.getAsJsonObject().get("count").getAsInt();
				JsonElement disease = diseaseCountForGivenMohAreaListItemJsonObj.getAsJsonObject().get("disease");
				String diseaseName = disease.getAsJsonObject().get("diseaseName").getAsString();

				DiseaseVsPatientSummaryDto diseaseVsPatientSummaryDto = new DiseaseVsPatientSummaryDto();
				diseaseVsPatientSummaryDto.setDiseaseName(diseaseName);
				diseaseVsPatientSummaryDto.setCount(patientCount);

				diseaseVsPatientSummaryDtos.add(diseaseVsPatientSummaryDto);
			}
			areaVsDiseaseSummaryDto.setMohArea(((MohArea) mohAreas.get(i)).getMohAreaName());
			areaVsDiseaseSummaryDto.setDiseaseVsPatientSummaryDtos(diseaseVsPatientSummaryDtos);

			mohAreaVsDiseaseSummaryDtos.add(areaVsDiseaseSummaryDto);
		}

		return mohAreaVsDiseaseSummaryDtos;
	}

}
