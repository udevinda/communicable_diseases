package lk.health.phd.cd.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import lk.health.phd.cd.dao.DistrictDao;
import lk.health.phd.cd.models.Disease;
import lk.health.phd.cd.models.District;

@Repository("districtDao")
public class DistrictDaoImpl extends UniversalDaoImpl<District> implements DistrictDao {

	/**
	 * {@inheritDoc}
	 */
	public List<District> getAllDistrict() {
		Session session = getCurrentSession();

		return session.createCriteria(District.class).setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
				.addOrder(Order.asc("id")).list();
	}

	public District getDistrictById(Long inDistrictId) {
		Session session = getCurrentSession();

		return (District) session.createCriteria(District.class).add(Restrictions.eq("id", inDistrictId))
				.uniqueResult();
	}

}
