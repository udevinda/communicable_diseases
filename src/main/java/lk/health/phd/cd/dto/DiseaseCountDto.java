package lk.health.phd.cd.dto;

import java.text.Normalizer.Form;

import lk.health.phd.cd.models.Disease;
import lk.health.phd.cd.models.District;
import lk.health.phd.cd.models.Form544;

/**
 * DTO which contains total count of reported {@link Form544} by specific
 * {@link Disease}, {@link District} and {@link Form544.notificationToMohDate}
 * 
 * @author admin
 *
 */
public class DiseaseCountDto {

	private Long yearlyCount;
	private Long monthlyCount;

	/**
	 * Getter for yearly count of {@link Form544}
	 * 
	 * @return {@link Form544} count
	 */
	public Long getYearlyCount() {
		return yearlyCount;
	}

	/**
	 * Setter for yearly count of {@link Form544}
	 * 
	 * @param inYearlyCount
	 *            yearly count of {@link Form544}
	 */
	public void setYearlyCount(final Long inYearlyCount) {
		this.yearlyCount = inYearlyCount;
	}

	/**
	 * Getter for monthly count of {@link Form544}
	 * 
	 * @return Monthly count of {@link Form544}
	 */
	public Long getMonthlyCount() {
		return monthlyCount;
	}

	/**
	 * Setter for monthly count of {@link Form544}
	 * 
	 * @param inMonthlyCount
	 *            Monthly count of {@link Form544}
	 */
	public void setMonthlyCount(final Long inMonthlyCount) {
		this.monthlyCount = inMonthlyCount;
	}

}
