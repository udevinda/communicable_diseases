package lk.health.phd.cd.dao;

import lk.health.phd.cd.models.Institute;

/**
 * DAO for {@link Institute} model
 * 
 * @author admin
 *
 */
public interface InstituteDao extends UniversalDao<Institute>{
	
	/**
	 * Get {@link Institute} by ID
	 * 
	 * @param inInstituteId
	 *            ID of the {@link Institute}
	 * @return {@link Institute}
	 */
	public Institute getInstituteById(final Long inIntituteId);
}
