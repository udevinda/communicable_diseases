package lk.health.phd.cd.services;

import java.util.List;

import lk.health.phd.cd.dto.MohAreaVsDiseaseSummaryDto;
import lk.health.phd.cd.dto.WardVsDiseaseSummaryDto;
import lk.health.phd.cd.models.Disease;
import lk.health.phd.cd.models.DiseaseConfirmationTest;
import lk.health.phd.cd.models.District;
import lk.health.phd.cd.models.Form544;
import lk.health.phd.cd.models.MohArea;

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

	/**
	 * Generate the summary of total number of reported cases according each
	 * {@link MohArea} of a {@link District} under specified {@link Disease}
	 * 
	 * @param inDistrictId
	 *            ID of the {@link District}
	 * @param inLowerDateYear
	 *            Lower date year to consider in report generation
	 * @param inLowerDateMonth
	 *            Lower date month to consider in report generation
	 * @param inUpperDateYear
	 *            Upper date year to consider in report generation
	 * @param inUpperDateMonth
	 *            Upper date month to consider in report generation
	 * @return List of {@link MohAreaVsDiseaseSummaryDto}
	 */
	public List<MohAreaVsDiseaseSummaryDto> generateMohAreaVaDiseaseSummary(final Long inDistrictId,
			final int inLowerDateYear, final int inLowerDateMonth, final int inUpperDateYear,
			final int inUpperDateMonth);

	/**
	 * Generate the summary of total number of reported cases according to each
	 * ward of a institute under specified disease
	 * 
	 * @param inInstitute
	 *            Name of the institute
	 * @param inLowerDateYear
	 *            Lower date year to consider in report generation
	 * @param inLowerDateMonth
	 *            Lower date month to consider in report generation
	 * @param inUpperDateYear
	 *            Upper date year to consider in report generation
	 * @param inUpperDateMonth
	 *            Upper date month to consider in report generation
	 * @return List of {@link WardVsDiseaseSummaryDto}
	 */
	public List<WardVsDiseaseSummaryDto> generateWardVsDiseaseSummary(final String inInstitute,
			final int inLowerDateYear, final int inLowerDateMonth, final int inUpperDateYear,
			final int inUpperDateMonth);

	/**
	 * Generate the list of total disease count for each month for a specific
	 * disease and specific district.
	 * 
	 * @param inDisease
	 *            {@link Disease}
	 * @param inDistrictId
	 *            ID of the {@link District}
	 * @param inYear
	 *            Year to consider
	 * @return List of group of disease counts for each month.
	 */
	public List generateMonthlyDiseaseTrendDataSet(final Disease inDisease, final Long inDistrictId,
			final String inYear);

	/**
	 * Generates the age list from the reported form 544s according to the
	 * parameters.
	 * 
	 * @param inDisease
	 *            {@link Disease}
	 * @param inDistrictId
	 *            ID of the {@link District}
	 * @param inYear
	 *            Year to consider
	 * @param inMonth
	 *            Month to consider
	 * @return List of age values
	 */
	public List generateAgeListForAgeWiseGraph(final Disease inDisease, final Long inDistrictId, final String inYear,
			final String inMonth);

	/**
	 * Generate the {@link Form544} details list considering the
	 * {@link District}, {@link Disease} and
	 * {@link Form544.notificationToMohDate} period.
	 * 
	 * @param inDistrictId
	 * ID of the {@link District} to consider
	 * @param inDiseaseId
	 * ID of the {@link Disease} to consider
	 * @param inLowerDate
	 * From date of the {@link Form544.notificationToMohDate} to consider
	 * @param inUpperDate
	 * To date of the {@link Form544.notificationToMohDate} to consider
	 * @return
	 * List of {@link Form544.notificationToMohDate},
	 *         {@link Form544.patientName}, {@link Form544.age},
	 *         {@link Form544.sex}, {@link Form544.mohArea},
	 *         {@link Form544.patientsHomePhoneNo},
	 *         {@link Form544.patientHomeAddress}, {@link Form544.remarks}
	 */
	public List getForm544DetailsByDistrictDiseaseDatePeriod(final Long inDistrictId, final Long inDiseaseId,
			final String inLowerDate, final String inUpperDate);
}
