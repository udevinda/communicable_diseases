package lk.health.phd.cd.dao;

import lk.health.phd.cd.models.DiseaseConfirmationTest;
import lk.health.phd.cd.models.Form544;

/**
 * DAO class for {@link DiseaseConfirmationTes}
 * 
 * @author admin
 *
 */
public interface DiseaseConfirmationTestDao extends UniversalDao<DiseaseConfirmationTest> {

	/**
	 * Return the {@link DiseaseConfirmationTest} for the given {@link Form544}
	 * ID
	 * 
	 * @param inForm544Id
	 *            ID value of the {@link Form544}
	 * @return {@link DiseaseConfirmationTest}
	 */
	public DiseaseConfirmationTest getDiseaseConfirmationTestByForm544Id(final Long inForm544Id);
}
