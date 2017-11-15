package lk.health.phd.cd.dao;

import java.util.List;

import lk.health.phd.cd.models.District;
import lk.health.phd.cd.models.Institute;

/**
 * DAO for {@link Institute} model
 * 
 * @author admin
 *
 */
public interface InstituteDao extends UniversalDao<Institute> {

	/**
	 * Get {@link Institute} by ID
	 * 
	 * @param inInstituteId
	 *            ID of the {@link Institute}
	 * @return {@link Institute}
	 */
	public Institute getInstituteById(final Long inIntituteId);

	/**
	 * Get {@link Institute} list related to the {@link District}
	 * 
	 * @param inDistrictId
	 *            Id of the considering {@link District}
	 * @return List of available {@link Institute}
	 */
	public List<Institute> getInstitutesByDistrictId(final Long inDistrictId);
}
