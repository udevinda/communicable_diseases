package lk.health.phd.cd.dao;

import java.util.List;

import lk.health.phd.cd.models.District;
import lk.health.phd.cd.models.MohArea;

/**
 * DAO for {@link MohArea}
 * 
 * @author admin
 *
 */
public interface MohAreaDao extends UniversalDao<MohArea> {

	/**
	 * Get list of {@link MohArea}}
	 * 
	 * @param districtId
	 *            Id of the {@link District}
	 * @return List of {@link District}
	 */
	public List<MohArea> getMohAreaByDistrictId(final Long inDistrictId);

	/**
	 * Returns the {@link MohArea} by record ID
	 * 
	 * @param inMohId
	 *            ID of the MOH area
	 * @return {@link MohArea}
	 */
	public MohArea findMohAreaById(final Long inMohId);
}
