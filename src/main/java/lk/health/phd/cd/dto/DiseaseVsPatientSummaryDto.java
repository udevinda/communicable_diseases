package lk.health.phd.cd.dto;

import lk.health.phd.cd.models.Disease;

/**
 * DTO class to hold disease and its patient counts.
 * 
 * @author admin
 *
 */
public class DiseaseVsPatientSummaryDto {

	private String diseaseName;
	private Long count;

	/**
	 * Getter to get disease name
	 * 
	 * @return name of disease
	 */
	public String getDiseaseName() {
		return diseaseName;
	}

	/**
	 * Setter for disease name
	 * 
	 * @param inDiseaseName
	 *            disease name
	 */
	public void setDiseaseName(final String inDiseaseName) {
		this.diseaseName = inDiseaseName;
	}

	/**
	 * Getter for patient count relevant to the particular {@link Disease}
	 * 
	 * @return Count of the patients
	 */
	public Long getCount() {
		return count;
	}

	/**
	 * Setter for patient count relevant to the particular {@link Disease}
	 * 
	 * @param inCount
	 *            Count of the patients
	 */
	public void setCount(final Long inCount) {
		this.count = inCount;
	}

}
