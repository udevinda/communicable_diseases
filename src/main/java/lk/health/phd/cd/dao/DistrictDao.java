package lk.health.phd.cd.dao;

import java.util.List;

import lk.health.phd.cd.models.District;

/**
 * DAO for District model
 * 
 * @author admin
 *
 */
public interface DistrictDao extends UniversalDao<District> {

	/**
	 * Returns all the available {@link District}
	 * 
	 * @return List of {@link District}
	 */
	public List<District> getAllDistrict();

}
