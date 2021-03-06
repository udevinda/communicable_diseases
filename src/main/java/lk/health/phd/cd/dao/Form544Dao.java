package lk.health.phd.cd.dao;

import java.util.List;

import lk.health.phd.cd.dto.Form544FilterDto;
import lk.health.phd.cd.models.Form544;

/**
 * DAO class for Form544 entity.
 * 
 * @author admin
 *
 */
public interface Form544Dao extends UniversalDao<Form544> {

	/**
	 * Retrieve form544 record by Form544 record ID.
	 * 
	 * @param form544Id
	 *            Id value of the Form544.
	 * @return {@link Form544}
	 */
	public Form544 findForm544ById(final Long form544Id);

	/**
	 * Retrieve list of {@link Form544} objects according to given searching
	 * field values.
	 * 
	 * @param inForm544FilterDto
	 *            DTO which contains all available filtering parameters and with
	 *            values
	 * @param inOffset
	 *            Starting index which is used in backend resultset pagination
	 * @param inLimit
	 *            Number of records per page limit for backend pagination
	 * @return List of {@link Form544}
	 */
	public List<Form544> searchForm544BySearchFields(final Form544FilterDto inForm544FilterDto, final Integer inOffset,
			final Integer inLimit);

	/**
	 * Returns the total count of available records for given filtering
	 * criteria.
	 * 
	 * @param inForm544FilterDto
	 *            DTO including searching parameters.
	 * @return Count of total records.
	 */
	public Long searchCountForm544BySearchFields(final Form544FilterDto inForm544FilterDto);
}
