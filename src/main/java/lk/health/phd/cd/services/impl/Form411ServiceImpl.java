package lk.health.phd.cd.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.health.phd.cd.dao.Form411Dao;
import lk.health.phd.cd.models.Form411;
import lk.health.phd.cd.services.Form411Service;

@Service("form411Service")
@Transactional
public class Form411ServiceImpl implements Form411Service {

	Logger logger = LoggerFactory.getLogger(Form411ServiceImpl.class);

	@Autowired
	Form411Dao form411Dao;

	/**
	 * {@inheritDoc}
	 */
	public Form411 updateForm411ById(final Long inForm411Id, final Form411 inForm411) {
		// TODO validate for null
		Form411 form411 = form411Dao.findForm411ById(inForm411Id);

		form411.setAge(inForm411.getAge());
		form411.setDateOfDischarged(inForm411.getDateOfDischarged());
		form411.setDateOfHospitalization(inForm411.getDateOfHospitalization());
		form411.setDateOfOnset(inForm411.getDateOfOnset());
		form411.setDiseaseAsNotified(inForm411.getDiseaseAsNotified());
		form411.setDiseaseConfirmed(inForm411.getDiseaseConfirmed());
		form411.setDiseaseConfirmedDate(inForm411.getDiseaseConfirmedDate());
		form411.setDiseaseNotifiedDate(inForm411.getDiseaseNotifiedDate());
		form411.setEthnicGroup(inForm411.getEthnicGroup());
		form411.setLaboratoryFindings(inForm411.getLaboratoryFindings());
		form411.setLattitude(inForm411.getLattitude());
		form411.setLongitude(inForm411.getLongitude());
		form411.setMohArea(inForm411.getMohArea());
		form411.setNameOfHospital(inForm411.getNameOfHospital());
		form411.setOutcome(inForm411.getOutcome());
		form411.setPatientAddress(inForm411.getPatientAddress());
		form411.setPatientContact(inForm411.getPatientContact());
		form411.setPatientName(inForm411.getPatientName());
		form411.setPatientsMovements(inForm411.getPatientsMovements());
		form411.setPhiRange(inForm411.getPhiRange());
		form411.setSex(inForm411.getSex());
		form411.setWhereIsolated(inForm411.getWhereIsolated());

		form411Dao.merge(form411);

		logger.debug("Form411 ID : " + form411.getId() + " updated and persisted to DB.");

		return form411;
	}

}
