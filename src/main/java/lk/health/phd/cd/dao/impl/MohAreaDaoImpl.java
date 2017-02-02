package lk.health.phd.cd.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import lk.health.phd.cd.dao.MohAreaDao;
import lk.health.phd.cd.models.MohArea;

@Repository("mohAreaDao")
public class MohAreaDaoImpl extends UniversalDaoImpl<MohArea> implements MohAreaDao {

	public List<MohArea> getMohAreaByDistrictId(final Long districtId) {
		Session session = getCurrentSession();

		return (List<MohArea>) session.createCriteria(MohArea.class).add(Restrictions.eq("district.id", districtId))
				.list();
	}

}
