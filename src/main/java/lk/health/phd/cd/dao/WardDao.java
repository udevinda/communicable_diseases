package lk.health.phd.cd.dao;

import java.util.List;

import lk.health.phd.cd.models.Institute;
import lk.health.phd.cd.models.Ward;

public interface WardDao extends UniversalDao<Ward> {

	/**
	 * Get {@link Ward} by ID
	 * 
	 * @param inWardId
	 *            ID of the {@link Ward}
	 * @return {@link Ward}
	 */
	public Ward getWardById(final Long inWardId);

	/**
	 * Get {@link Ward} list related to the {@link Institute}
	 * 
	 * @param inInstituteId
	 *            Id of the considering {@link Institute}
	 * @return List of available {@link Ward}
	 */
	public List<Ward> getWardsByInstituteId(final Long inInstituteId);
}
