package lk.health.phd.cd.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
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
	public List<Form544> searchForm544BySearchFields(final Form544FilterDto inForm544FilterDto) {

		Session session = getCurrentSession();

		Criteria criteria = session.createCriteria(Form544.class);

		if (inForm544FilterDto.getBhtNo() != null) {
			criteria.add(Restrictions.eq("bhtNo", inForm544FilterDto.getBhtNo()));
		}
		if (inForm544FilterDto.getInstitute() != null) {
			criteria.add(Restrictions.eq("institute", inForm544FilterDto.getInstitute()));
		}
		if (inForm544FilterDto.getNotifierName() != null) {
			criteria.add(Restrictions.eq("notifierName", inForm544FilterDto.getNotifierName()));
		}
		if (inForm544FilterDto.getPatientName() != null) {
			criteria.add(Restrictions.eq("patientName", inForm544FilterDto.getPatientName()));
		}
		

		return null;
	}

}
