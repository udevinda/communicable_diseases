package lk.health.phd.cd.dao;

import java.util.List;

import lk.health.phd.cd.models.Disease;

/**
 * DAO class for Disease Enity.
 * 
 * @author admin
 *
 */
public interface DiseaseDao extends UniversalDao<Disease> {

	/**
	 * Returns the particular Disease record by Id.
	 * 
	 * @param diseaseId
	 *            ID of the record.
	 * @return {@link Disease}
	 */
	public Disease findDiseaseById(final Long diseaseId);

	/**
	 * Returns all available diseases.
	 * 
	 * @return List of {@link Disease}
	 */
	public List<Disease> getAllDiseases();
}
