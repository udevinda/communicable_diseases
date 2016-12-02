package lk.health.phd.cd.dao.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import lk.health.phd.cd.dao.Form411Dao;
import lk.health.phd.cd.models.Form411;
import lk.health.phd.cd.models.Form544;

@Repository("form411Dao")
public class Form411DaoImpl extends UniversalDaoImpl<Form411> implements Form411Dao {

	public Form411 findForm411ById(final Long inForm411Id) {
		Session session = getCurrentSession();

		return (Form411) session.createCriteria(Form411.class).add(Restrictions.eq("id", inForm411Id)).uniqueResult();
	}

}
