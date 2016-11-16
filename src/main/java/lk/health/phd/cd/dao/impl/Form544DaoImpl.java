package lk.health.phd.cd.dao.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import lk.health.phd.cd.dao.Form544Dao;
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

}
