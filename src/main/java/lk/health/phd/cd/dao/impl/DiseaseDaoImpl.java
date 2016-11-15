package lk.health.phd.cd.dao.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import lk.health.phd.cd.dao.DiseaseDao;
import lk.health.phd.cd.models.Disease;

/**
 * 
 * @author admin
 *
 */

@Repository("diseaseDao")
public class DiseaseDaoImpl extends UniversalDaoImpl<Disease> implements DiseaseDao {

	/**
	 * {@inheritDoc}
	 */
	public Disease findDiseaseById(final Long inDiseaseId) {
		Session session = getCurrentSession();

		return (Disease) session.createCriteria(Disease.class).add(Restrictions.eq("id", inDiseaseId)).uniqueResult();
	}

}
