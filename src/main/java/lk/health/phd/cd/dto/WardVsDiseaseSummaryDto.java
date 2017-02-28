package lk.health.phd.cd.dto;

import java.util.List;

public class WardVsDiseaseSummaryDto {

	private String ward;
	private List<DiseaseVsPatientSummaryDto> diseaseVsPatientSummaryDtos;

	/**
	 * Getter for ward
	 * 
	 * @return ward name
	 */
	public String getWard() {
		return ward;
	}

	/**
	 * Setter for ward
	 * 
	 * @param inWard
	 *            Ward
	 */
	public void setWard(final String inWard) {
		this.ward = inWard;
	}

	/**
	 * Getter for {@link DiseaseVsPatientSummaryDto} list
	 * 
	 * @return List of {@link DiseaseVsPatientSummaryDto}
	 */
	public List<DiseaseVsPatientSummaryDto> getDiseaseVsPatientSummaryDtos() {
		return diseaseVsPatientSummaryDtos;
	}

	/**
	 * Setter for list of {@link DiseaseVsPatientSummaryDto}
	 * 
	 * @param inDiseaseVsPatientSummaryDtos
	 *            List of {@link DiseaseVsPatientSummaryDto}
	 */
	public void setDiseaseVsPatientSummaryDtos(final List<DiseaseVsPatientSummaryDto> inDiseaseVsPatientSummaryDtos) {
		this.diseaseVsPatientSummaryDtos = inDiseaseVsPatientSummaryDtos;
	}

}
