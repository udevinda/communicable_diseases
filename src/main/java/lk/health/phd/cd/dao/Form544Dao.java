package lk.health.phd.cd.dao;

import java.text.Normalizer.Form;
import java.util.List;

import lk.health.phd.cd.dto.Form544FilterDto;
import lk.health.phd.cd.dto.MonthVsPatientSummaryDto;
import lk.health.phd.cd.models.Disease;
import lk.health.phd.cd.models.District;
import lk.health.phd.cd.models.Form544;
import lk.health.phd.cd.models.MohArea;

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

	/**
	 * Get the total reported {@link Form544} count for current month.
	 * 
	 * @return Returns the total count of {@link Form544} for current month.
	 */
	// TODO Logic Wrong. This should be consider district wise
	public Long getForm544CountForCurrentMonth();

	/**
	 * Get the total reported {@link Form544} count for current year.
	 * 
	 * @return Returns the total count of {@link Form544} for current year.
	 */
	// TODO Logic wrong. This should be consisder district wise
	public Long getForm544CountForCurrentYear();

	/**
	 * Get {@link Disease} group count for a given {@link MohArea}
	 * 
	 * @param inMohArea
	 *            {@link MohArea}
	 * @param inLowerDateLimit
	 *            Lower date range to consider
	 * @param inUpperDateLimit
	 *            Upper date range to consider
	 * @return List of Disease and its count pairs
	 */
	public List getEachDiseaseCountForGivenMohArea(final MohArea inMohArea, final String inLowerDateLimit,
			final String inUpperDateLimit);

	/**
	 * Get each disease count for the given ward
	 * 
	 * @param inWard
	 *            ward name
	 * @param inLowerDateLimit
	 *            Lower date range to consider
	 * @param inUpperDateLimit
	 *            Upper date range to consider
	 * @return List of Disease and its count pairs
	 */
	public List getEachDiseaseCountForGivenWard(final String inWard, final String inLowerDateLimit,
			final String inUpperDateLimit);

	/**
	 * Get ward list for a given institute
	 * 
	 * @param inInstituteId
	 *            ID of the institute
	 * @return List of the wards owned by the given institute
	 */
	public List getWardsForAInstitute(final Long inInstituteId);

	/**
	 * Get distinct list of available institutes
	 * 
	 * @return
	 * 
	 * 		List of institutes
	 */
	public List getDistinctInstituteList();

	/**
	 * Get disease count for each month related to a specific {@link MohArea}
	 * 
	 * @param inDisease
	 *            {@link Disease}
	 * @param mohAreaId
	 *            {@link MohArea}
	 * @param inYear
	 *            Year to consider
	 * @return list of {@link MonthVsPatientSummaryDto}
	 */
	public List<MonthVsPatientSummaryDto> getDiseaseCountForEachMonth(final Disease inDisease, final MohArea mohArea,
			final String inYear);

	/**
	 * Get ages list from reported form 544 related to given parameters.
	 * 
	 * @param inDisease
	 *            {@link Disease}
	 * @param inMohArea
	 *            {@link MohArea}
	 * @param inYear
	 *            Year to consider
	 * @param inMonth
	 *            Month to consider
	 * @return List of age values
	 */
	public List getReportedAgesForDisease(final Disease inDisease, final MohArea inMohArea, final String inYear,
			final String inMonth);

	/**
	 * Get list of {@link Form544} details considering a
	 * {@link Form544.notificationToMohDate} period, {@link Disease} and
	 * {@link MohArea}
	 * 
	 * @param inDiseaseId
	 *            ID of the {@link Disease}
	 * @param inFromDate
	 *            From date of {@link Form544.notificationToMohDate}
	 * @param inDistrictId
	 *            ID of the {@link District} to consider
	 * @param inToDate
	 *            To date of {@link Form544.notificationToMohDate}
	 * @return List of {@link Form544.notificationToMohDate},
	 *         {@link Form544.patientName}, {@link Form544.age},
	 *         {@link Form544.sex}, {@link Form544.mohArea},
	 *         {@link Form544.patientsHomePhoneNo},
	 *         {@link Form544.patientHomeAddress}, {@link Form544.remarks}
	 */
	public List getForm544DetailsForGivenPeriodByDisease(final Long inDiseaseId, final Long inDistrictId,
			final String inFromDate, final String inToDate);

	/**
	 * Get total count of {@link Form544} related to specific disease by the
	 * given {@link Form544.notificationToMohDate}.year and the {@link District}
	 * 
	 * @param inDiseaseId
	 *            Id of the {@link Disease}
	 * @param inDistrictId
	 *            Id of the {@link District}
	 * @param inYear
	 *            year of the {@link Form544.notificationToMohDate}
	 * @return Total count of the reported {@link Form544}
	 */
	public Long getTotalReportedDiseaseCountByDistrictPeriodForYear(final Long inDiseaseId, final Long inDistrictId,
			final String inYear);

	/**
	 * Get total count of {@link Form544} related to specific {@link Disease} by
	 * given {@link Form544.notificationToMohDate}.year,
	 * {@link Form544.notificationToMohDate}.month and the {@link District}
	 * 
	 * @param inDiseaseId
	 *            {@link Disease.id}
	 * @param inDistrictId
	 *            {@link District.id}
	 * @param inYear
	 *            {@link Form544.notificationToMohDate}.year
	 * @param inMonth
	 *            {@link Form544.notificationToMohDate}.month
	 * @return Total of the reported {@link Form544}
	 */
	public Long getTotalReportedDiseaseCountByDistrictPeriodForMonth(final Long inDiseaseId, final Long inDistrictId,
			final String inYear, final String inMonth);

	/**
	 * Get the list of {@link Form544} objects based on filtering fields for the
	 * disease wise distribution map.
	 * 
	 * @param inForm544FilterDto
	 *            {@link Form544FilterDto}
	 * @return List of {@link Form544} objects
	 */
	public List<Form544> getDetailsForDiseaseWiseDistributionMap(final Form544FilterDto inForm544FilterDto);
}
