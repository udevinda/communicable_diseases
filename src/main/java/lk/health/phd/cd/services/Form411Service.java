package lk.health.phd.cd.services;

import lk.health.phd.cd.models.Form411;

/**
 * 
 * @author admin
 *
 */
public interface Form411Service {

	/**
	 * Update existing Form411 object by new attributes.
	 * 
	 * @param inForm411Id
	 *            Id of the existing {@link Form411}
	 * @param inForm411
	 *            New {@link Form411} object
	 * @return {@link Form411}
	 */
	public Form411 updateForm411ById(final Long inForm411Id, final Form411 inForm411);
}
