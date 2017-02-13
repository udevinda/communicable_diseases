package lk.health.phd.cd.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.health.phd.cd.dao.DiseaseConfirmationTestDao;
import lk.health.phd.cd.dao.Form544Dao;
import lk.health.phd.cd.dao.WorkflowDao;
import lk.health.phd.cd.models.DiseaseConfirmationTest;
import lk.health.phd.cd.models.Form544;
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

}
