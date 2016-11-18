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
	 * @param form544FilterDto
	 * @return List of {@link Form544}
	 */
	public List<Form544> searchForm544BySearchFields(final Form544FilterDto form544FilterDto);
}
