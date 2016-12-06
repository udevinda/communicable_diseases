package lk.health.phd.cd.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import lk.health.phd.cd.dao.Form411Dao;
import lk.health.phd.cd.dto.Form411FilterDto;
import lk.health.phd.cd.models.Form411;

@Repository("form411Dao")
public class Form411DaoImpl extends UniversalDaoImpl<Form411> implements Form411Dao {

	/**
	 * {@inheritDoc}
	 */
	public Form411 findForm411ById(final Long inForm411Id) {
		Session session = getCurrentSession();

		return (Form411) session.createCriteria(Form411.class).add(Restrictions.eq("id", inForm411Id)).uniqueResult();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Form411> searchForm411BySearchingFields(Form411FilterDto inForm411FilterDto, Integer inOffset,
			Integer inLimit) {

		Session session = getCurrentSession();

		Criteria criteria = session.createCriteria(Form411.class);

		if (inForm411FilterDto.getAgeFrom() != null) {
			criteria.add(Restrictions.ge("age", inForm411FilterDto.getAgeFrom()));
		}
		if (inForm411FilterDto.getAgeTo() != null) {
			criteria.add(Restrictions.le("age", inForm411FilterDto.getAgeTo()));
		}
		if (inForm411FilterDto.getConfirmedDateFrom() != null) {
			criteria.add(Restrictions.ge("diseaseConfirmedDate", inForm411FilterDto.getConfirmedDateFrom()));
		}
		if (inForm411FilterDto.getConfirmedDateTo() != null) {
			criteria.add(Restrictions.le("diseaseConfirmedDate", inForm411FilterDto.getConfirmedDateTo()));
		}
		if (inForm411FilterDto.getConfirmedDisease() != null) {
			criteria.add(Restrictions.eq("diseaseConfirmed", inForm411FilterDto.getConfirmedDisease()));
		}
		if (inForm411FilterDto.getDateOnsetFrom() != null) {
			criteria.add(Restrictions.ge("dateOfOnset", inForm411FilterDto.getDateOnsetFrom()));
		}
		if (inForm411FilterDto.getDateOnsetTo() != null) {
			criteria.add(Restrictions.le("dateOfOnset", inForm411FilterDto.getDateOnsetTo()));
		}
		if (inForm411FilterDto.getDischargedFrom() != null) {
			criteria.add(Restrictions.ge("dateOfDischarged", inForm411FilterDto.getDischargedFrom()));
		}
		if (inForm411FilterDto.getDischargedTo() != null) {
			criteria.add(Restrictions.le("dateOfDischarged", inForm411FilterDto.getDischargedTo()));
		}
		if (inForm411FilterDto.getEthnicGroup() != null) {
			criteria.add(Restrictions.eq("ethnicGroup", inForm411FilterDto.getEthnicGroup()));
		}
		if (inForm411FilterDto.getHospital() != null && !(inForm411FilterDto.getHospital().isEmpty())) {
			criteria.add(Restrictions.eq("nameOfHospital", inForm411FilterDto.getHospital()));
		}
		if (inForm411FilterDto.getHospitalizedFrom() != null) {
			criteria.add(Restrictions.ge("dateOfHospitalization", inForm411FilterDto.getHospitalizedFrom()));
		}
		if (inForm411FilterDto.getHospitalizedTo() != null) {
			criteria.add(Restrictions.le("dateOfHospitalization", inForm411FilterDto.getHospitalizedTo()));
		}
		if (inForm411FilterDto.getIsolated() != null) {
			criteria.add(Restrictions.eq("whereIsolated", inForm411FilterDto.getIsolated()));
		}
		if (inForm411FilterDto.getMohRange() != null && !(inForm411FilterDto.getMohRange().isEmpty())) {
			criteria.add(Restrictions.eq("mohArea", inForm411FilterDto.getMohRange()));
		}
		if (inForm411FilterDto.getNotifiedDateFrom() != null) {
			criteria.add(Restrictions.ge("diseaseNotifiedDate", inForm411FilterDto.getNotifiedDateFrom()));
		}
		if (inForm411FilterDto.getNotifiedDateTo() != null) {
			criteria.add(Restrictions.le("diseaseNotifiedDate", inForm411FilterDto.getNotifiedDateTo()));
		}
		if (inForm411FilterDto.getNotifiedDisease() != null) {
			criteria.add(Restrictions.eq("diseaseAsNotified", inForm411FilterDto.getNotifiedDisease()));
		}
		if (inForm411FilterDto.getOutcome() != null) {
			criteria.add(Restrictions.eq("outcome", inForm411FilterDto.getOutcome()));
		}
		if (inForm411FilterDto.getPatientName() != null && !(inForm411FilterDto.getPatientName().isEmpty())) {
			criteria.add(Restrictions.eq("patientName", inForm411FilterDto.getPatientName()));
		}
		if (inForm411FilterDto.getPhiRange() != null && !(inForm411FilterDto.getPhiRange().isEmpty())) {
			criteria.add(Restrictions.eq("phiRange", inForm411FilterDto.getPhiRange()));
		}
		if (inForm411FilterDto.getSex() != null) {
			criteria.add(Restrictions.eq("sex", inForm411FilterDto.getSex()));
		}

		criteria.setMaxResults(inLimit);
		criteria.setFirstResult(inOffset);

		return criteria.list();
	}

	public Long searchCountForm411BySearchFields(Form411FilterDto inForm411FilterDto) {
		Session session = getCurrentSession();

		Criteria criteria = session.createCriteria(Form411.class);

		if (inForm411FilterDto.getAgeFrom() != null) {
			criteria.add(Restrictions.ge("age", inForm411FilterDto.getAgeFrom()));
		}
		if (inForm411FilterDto.getAgeTo() != null) {
			criteria.add(Restrictions.le("age", inForm411FilterDto.getAgeTo()));
		}
		if (inForm411FilterDto.getConfirmedDateFrom() != null) {
			criteria.add(Restrictions.ge("diseaseConfirmedDate", inForm411FilterDto.getConfirmedDateFrom()));
		}
		if (inForm411FilterDto.getConfirmedDateTo() != null) {
			criteria.add(Restrictions.le("diseaseConfirmedDate", inForm411FilterDto.getConfirmedDateTo()));
		}
		if (inForm411FilterDto.getConfirmedDisease() != null) {
			criteria.add(Restrictions.eq("diseaseConfirmed", inForm411FilterDto.getConfirmedDisease()));
		}
		if (inForm411FilterDto.getDateOnsetFrom() != null) {
			criteria.add(Restrictions.ge("dateOfOnset", inForm411FilterDto.getDateOnsetFrom()));
		}
		if (inForm411FilterDto.getDateOnsetTo() != null) {
			criteria.add(Restrictions.le("dateOfOnset", inForm411FilterDto.getDateOnsetTo()));
		}
		if (inForm411FilterDto.getDischargedFrom() != null) {
			criteria.add(Restrictions.ge("dateOfDischarged", inForm411FilterDto.getDischargedFrom()));
		}
		if (inForm411FilterDto.getDischargedTo() != null) {
			criteria.add(Restrictions.le("dateOfDischarged", inForm411FilterDto.getDischargedTo()));
		}
		if (inForm411FilterDto.getEthnicGroup() != null) {
			criteria.add(Restrictions.eq("ethnicGroup", inForm411FilterDto.getEthnicGroup()));
		}
		if (inForm411FilterDto.getHospital() != null && !(inForm411FilterDto.getHospital().isEmpty())) {
			criteria.add(Restrictions.eq("nameOfHospital", inForm411FilterDto.getHospital()));
		}
		if (inForm411FilterDto.getHospitalizedFrom() != null) {
			criteria.add(Restrictions.ge("dateOfHospitalization", inForm411FilterDto.getHospitalizedFrom()));
		}
		if (inForm411FilterDto.getHospitalizedTo() != null) {
			criteria.add(Restrictions.le("dateOfHospitalization", inForm411FilterDto.getHospitalizedTo()));
		}
		if (inForm411FilterDto.getIsolated() != null) {
			criteria.add(Restrictions.eq("whereIsolated", inForm411FilterDto.getIsolated()));
		}
		if (inForm411FilterDto.getMohRange() != null && !(inForm411FilterDto.getMohRange().isEmpty())) {
			criteria.add(Restrictions.eq("mohArea", inForm411FilterDto.getMohRange()));
		}
		if (inForm411FilterDto.getNotifiedDateFrom() != null) {
			criteria.add(Restrictions.ge("diseaseNotifiedDate", inForm411FilterDto.getNotifiedDateFrom()));
		}
		if (inForm411FilterDto.getNotifiedDateTo() != null) {
			criteria.add(Restrictions.le("diseaseNotifiedDate", inForm411FilterDto.getNotifiedDateTo()));
		}
		if (inForm411FilterDto.getNotifiedDisease() != null) {
			criteria.add(Restrictions.eq("diseaseAsNotified", inForm411FilterDto.getNotifiedDisease()));
		}
		if (inForm411FilterDto.getOutcome() != null) {
			criteria.add(Restrictions.eq("outcome", inForm411FilterDto.getOutcome()));
		}
		if (inForm411FilterDto.getPatientName() != null && !(inForm411FilterDto.getPatientName().isEmpty())) {
			criteria.add(Restrictions.eq("patientName", inForm411FilterDto.getPatientName()));
		}
		if (inForm411FilterDto.getPhiRange() != null && !(inForm411FilterDto.getPhiRange().isEmpty())) {
			criteria.add(Restrictions.eq("phiRange", inForm411FilterDto.getPhiRange()));
		}
		if (inForm411FilterDto.getSex() != null) {
			criteria.add(Restrictions.eq("sex", inForm411FilterDto.getSex()));
		}

		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}

}
