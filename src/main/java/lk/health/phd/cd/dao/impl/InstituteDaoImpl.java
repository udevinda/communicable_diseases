package lk.health.phd.cd.dao.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import lk.health.phd.cd.dao.InstituteDao;
import lk.health.phd.cd.models.Institute;

@Repository("instituteDao")
public class InstituteDaoImpl extends UniversalDaoImpl<Institute> implements InstituteDao {

	/**
	 * {@inheritDoc}
	 */
	public Institute getInstituteById(final Long inIntituteId) {
		Session session = getCurrentSession();

		return (Institute) session.createCriteria(Institute.class).add(Restrictions.eq("id", inIntituteId))
				.uniqueResult();
	}

}
