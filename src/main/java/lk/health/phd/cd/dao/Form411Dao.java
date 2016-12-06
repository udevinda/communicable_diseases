package lk.health.phd.cd.dao;

import java.util.List;

import lk.health.phd.cd.dto.Form411FilterDto;
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

	/**
	 * Filter Form411 records from DB according to the provided criteria and
	 * values.
	 * 
	 * @param inForm411FilterDto
	 *            Contains the criteria list and value used to filter
	 * @param inOffset
	 *            Starting point to search
	 * @param inLimit
	 *            Limit for the reult set.
	 * @return List of {@link Form411}
	 */
	public List<Form411> searchForm411BySearchingFields(final Form411FilterDto inForm411FilterDto,
			final Integer inOffset, final Integer inLimit);

	/**
	 * Counts the total possible result row count for given criteria and values.
	 * 
	 * @param inForm411FilterDto
	 *            Contains the criteria list and value used to filter
	 * @return Total possible result row count
	 */
	public Long searchCountForm411BySearchFields(final Form411FilterDto inForm411FilterDto);
}
