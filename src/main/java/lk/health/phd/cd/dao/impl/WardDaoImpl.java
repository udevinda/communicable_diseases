package lk.health.phd.cd.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import lk.health.phd.cd.dao.WardDao;
import lk.health.phd.cd.models.Ward;

@Repository("wardDao")
public class WardDaoImpl extends UniversalDaoImpl<Ward> implements WardDao {

	public Ward getWardById(Long inWardId) {
		Session session = getCurrentSession();

		return (Ward) session.createCriteria(Ward.class).add(Restrictions.eq("id", inWardId)).uniqueResult();
	}

	public List<Ward> getWardsByInstituteId(Long inInstituteId) {
		Session session = getCurrentSession();

		return (List<Ward>) session.createCriteria(Ward.class).add(Restrictions.eq("institute.id", inInstituteId))
				.list();
	}

}
