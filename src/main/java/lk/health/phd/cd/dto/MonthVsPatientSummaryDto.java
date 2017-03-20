package lk.health.phd.cd.dto;

/**
 * DTO class to hold month and reported patient count related to a specific
 * disease
 * 
 * @author admin
 *
 */
public class MonthVsPatientSummaryDto {

	private int month;
	private Long count;

	/**
	 * Getter for Month
	 * 
	 * @return index of the month 1- January 2- February 3- March 4- April 5-
	 *         May 6- June 7- July 8- August 9- September 10- October 11-
	 *         November 12- December
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Setter for the month
	 * 
	 * @param inMonth
	 *            index of the month 1- January 2- February 3- March 4- April 5-
	 *            May 6- June 7- July 8- August 9- September 10- October 11-
	 *            November 12- December
	 */
	public void setMonth(final int inMonth) {
		this.month = inMonth;
	}

	/**
	 * Getter for patient count.
	 * 
	 * @return Count of the patient for the related month
	 */
	public Long getCount() {
		return count;
	}

	/**
	 * Setter for the patient count.
	 * 
	 * @param inPatientCount
	 *            Count of the patients
	 */
	public void setCount(final Long inCount) {
		this.count = inCount;
	}

}
