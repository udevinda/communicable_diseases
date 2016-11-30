package lk.health.phd.cd.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import lk.health.phd.cd.dao.Form544Dao;
import lk.health.phd.cd.dto.Form544FilterDto;
import lk.health.phd.cd.models.Form544;

/**
 * 
 * @author admin
 *
 */

@Repository("form544Dao")
public class Form544DaoImpl extends UniversalDaoImpl<Form544> implements Form544Dao {

	/**
	 * {@inheritDoc}
	 */
	public Form544 findForm544ById(final Long inForm544Id) {
		Session session = getCurrentSession();

		return (Form544) session.createCriteria(Form544.class).add(Restrictions.eq("id", inForm544Id)).uniqueResult();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Form544> searchForm544BySearchFields(final Form544FilterDto inForm544FilterDto, final Integer inOffset,
			final Integer inLimit) {

		Session session = getCurrentSession();

		Criteria criteria = session.createCriteria(Form544.class);

		if (inForm544FilterDto.getBhtNo() != null) {
			criteria.add(Restrictions.eq("bhtNo", inForm544FilterDto.getBhtNo()));
		}
		if (inForm544FilterDto.getInstitute() != null && !(inForm544FilterDto.getInstitute().isEmpty())) {
			criteria.add(Restrictions.eq("institute", inForm544FilterDto.getInstitute()));
		}
		if (inForm544FilterDto.getNotifierName() != null && !(inForm544FilterDto.getNotifierName().isEmpty())) {
			criteria.add(Restrictions.eq("notifierName", inForm544FilterDto.getNotifierName()));
		}
		if (inForm544FilterDto.getPatientName() != null && !(inForm544FilterDto.getPatientName().isEmpty())) {
			criteria.add(Restrictions.eq("patientName", inForm544FilterDto.getPatientName()));
		}
		if (inForm544FilterDto.getPatientNic() != null && !(inForm544FilterDto.getPatientNic().isEmpty())) {
			criteria.add(Restrictions.eq("nic", inForm544FilterDto.getPatientNic()));
		}
		if (inForm544FilterDto.getSex() != null) {
			criteria.add(Restrictions.eq("sex", inForm544FilterDto.getSex()));
		}
		if (inForm544FilterDto.getWard() != null && !(inForm544FilterDto.getWard().isEmpty())) {
			criteria.add(Restrictions.eq("ward", inForm544FilterDto.getWard()));
		}
		if (inForm544FilterDto.getDisease() != null) {
			criteria.add(Restrictions.eq("disease", inForm544FilterDto.getDisease()));
		}
		if (inForm544FilterDto.getAgeFrom() != null) {
			criteria.add(Restrictions.ge("age", inForm544FilterDto.getAgeFrom()));
		}
		if (inForm544FilterDto.getAgeTo() != null) {
			criteria.add(Restrictions.le("age", inForm544FilterDto.getAgeTo()));
		}
		if (inForm544FilterDto.getDateOfAdmissionFrom() != null) {
			criteria.add(Restrictions.ge("dateOfAdmission", inForm544FilterDto.getDateOfAdmissionFrom()));
		}
		if (inForm544FilterDto.getDateOfAdmissionTo() != null) {
			criteria.add(Restrictions.le("dateOfAdmission", inForm544FilterDto.getDateOfAdmissionTo()));
		}
		if (inForm544FilterDto.getDateOfOnsetFrom() != null) {
			criteria.add(Restrictions.ge("dateOfOnset", inForm544FilterDto.getDateOfOnsetFrom()));
		}
		if (inForm544FilterDto.getDateOfOnsetTo() != null) {
			criteria.add(Restrictions.le("dateOfOnset", inForm544FilterDto.getDateOfOnsetTo()));
		}

		criteria.setMaxResults(inLimit);
		criteria.setFirstResult(inOffset);

		return criteria.list();
	}

	/**
	 * {@inheritDoc}
	 */
	public Long searchCountForm544BySearchFields(Form544FilterDto inForm544FilterDto) {
		Session session = getCurrentSession();

		Criteria criteria = session.createCriteria(Form544.class);

		if (inForm544FilterDto.getBhtNo() != null) {
			criteria.add(Restrictions.eq("bhtNo", inForm544FilterDto.getBhtNo()));
		}
		if (inForm544FilterDto.getInstitute() != null && !(inForm544FilterDto.getInstitute().isEmpty())) {
			criteria.add(Restrictions.eq("institute", inForm544FilterDto.getInstitute()));
		}
		if (inForm544FilterDto.getNotifierName() != null && !(inForm544FilterDto.getNotifierName().isEmpty())) {
			criteria.add(Restrictions.eq("notifierName", inForm544FilterDto.getNotifierName()));
		}
		if (inForm544FilterDto.getPatientName() != null && !(inForm544FilterDto.getPatientName().isEmpty())) {
			criteria.add(Restrictions.eq("patientName", inForm544FilterDto.getPatientName()));
		}
		if (inForm544FilterDto.getPatientNic() != null && !(inForm544FilterDto.getPatientNic().isEmpty())) {
			criteria.add(Restrictions.eq("nic", inForm544FilterDto.getPatientNic()));
		}
		if (inForm544FilterDto.getSex() != null) {
			criteria.add(Restrictions.eq("sex", inForm544FilterDto.getSex()));
		}
		if (inForm544FilterDto.getWard() != null && !(inForm544FilterDto.getWard().isEmpty())) {
			criteria.add(Restrictions.eq("ward", inForm544FilterDto.getWard()));
		}
		if (inForm544FilterDto.getDisease() != null) {
			criteria.add(Restrictions.eq("disease", inForm544FilterDto.getDisease()));
		}
		if (inForm544FilterDto.getAgeFrom() != null) {
			criteria.add(Restrictions.ge("age", inForm544FilterDto.getAgeFrom()));
		}
		if (inForm544FilterDto.getAgeTo() != null) {
			criteria.add(Restrictions.le("age", inForm544FilterDto.getAgeTo()));
		}
		if (inForm544FilterDto.getDateOfAdmissionFrom() != null) {
			criteria.add(Restrictions.ge("dateOfAdmission", inForm544FilterDto.getDateOfAdmissionFrom()));
		}
		if (inForm544FilterDto.getDateOfAdmissionTo() != null) {
			criteria.add(Restrictions.le("dateOfAdmission", inForm544FilterDto.getDateOfAdmissionTo()));
		}
		if (inForm544FilterDto.getDateOfOnsetFrom() != null) {
			criteria.add(Restrictions.ge("dateOfOnset", inForm544FilterDto.getDateOfOnsetFrom()));
		}
		if (inForm544FilterDto.getDateOfOnsetTo() != null) {
			criteria.add(Restrictions.le("dateOfOnset", inForm544FilterDto.getDateOfOnsetTo()));
		}

		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}

}
