package lk.health.phd.cd.services;

import lk.health.phd.cd.models.DiseaseConfirmationTest;
import lk.health.phd.cd.models.Form544;

/**
 * 
 * @author admin
 *
 */
public interface Form544Service {

	/**
	 * Update form544 by given ID.
	 * 
	 * @param inForm544Id
	 *            Id of the form544 record.
	 * @param inForm544
	 *            object of form544.
	 * @param inDiseaseConfirmationTest
	 *            object of {@link DiseaseConfirmationTest}
	 * @return {@link Form544}
	 */
	public Form544 updateForm544ById(final Long inForm544Id, final Form544 inForm544,
			final DiseaseConfirmationTest inDiseaseConfirmationTest);

	/**
	 * Create {@link Form544}
	 * 
	 * @param inForm544
	 *            {@link Form544} object
	 * @return Persisted {@link Form544}
	 */
	public Form544 createForm544(final Form544 inForm544, final DiseaseConfirmationTest inDiseaseConfirmationTest);

	/**
	 * Generate {@link Form544} serial number as
	 * total_count_of_form544_for_current_month/
	 * total_count_of_form544_for_current_year
	 * 
	 * @return Returns the form544 serial number as a string
	 */
	public String generateForm544SerialNo();
}
