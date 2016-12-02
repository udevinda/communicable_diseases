package lk.health.phd.cd.dao;

import lk.health.phd.cd.models.Form411;

/**
 * DAO for form 411.
 * 
 * @author admin
 *
 */
public interface Form411Dao extends UniversalDao<Form411> {

	/**
	 * Retrieve Form411 record by Form411 record ID.
	 * 
	 * @param form411Id
	 *            Id value of the Form411.
	 * @return {@link Form411}
	 */
	public Form411 findForm411ById(final Long inForm411Id);
}
