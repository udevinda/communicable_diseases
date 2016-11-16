package lk.health.phd.cd.services;

import org.springframework.stereotype.Service;

import lk.health.phd.cd.models.Form544;

public interface Form544Service {

	/**
	 * Update form544 by given ID.
	 * 
	 * @param inForm544Id
	 *            Id of the form544 record.
	 * @param inForm544
	 *            object of form544.
	 * @return {@link Form544}
	 */
	public Form544 updateForm544ById(final Long inForm544Id, final Form544 inForm544);
}
