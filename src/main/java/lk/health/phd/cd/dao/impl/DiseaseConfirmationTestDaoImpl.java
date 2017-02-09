package lk.health.phd.cd.dao.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import lk.health.phd.cd.dao.DiseaseConfirmationTestDao;
import lk.health.phd.cd.models.DiseaseConfirmationTest;

/**
 * 
 * @author admin
 *
 */

@Repository("diseaseConfirmationDao")
public class DiseaseConfirmationTestDaoImpl extends UniversalDaoImpl<DiseaseConfirmationTest>
		implements DiseaseConfirmationTestDao {

	/**
	 * {@inheritDoc}
	 */
	public DiseaseConfirmationTest getDiseaseConfirmationTestByForm544Id(final Long inForm544Id) {
		Session session = getCurrentSession();

		return (DiseaseConfirmationTest) session.createCriteria(DiseaseConfirmationTest.class)
				.add(Restrictions.eq("form544.id", inForm544Id)).uniqueResult();
	}

}
