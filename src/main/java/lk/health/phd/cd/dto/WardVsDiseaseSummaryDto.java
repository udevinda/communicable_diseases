package lk.health.phd.cd.dto;

import java.util.List;

import lk.health.phd.cd.models.Ward;

public class WardVsDiseaseSummaryDto {

	private Ward ward;
	private List<DiseaseVsPatientSummaryDto> diseaseVsPatientSummaryDtos;

	/**
	 * Getter for {@link Ward}
	 * 
	 * @return {@link Ward.name}
	 */
	public Ward getWard() {
		return ward;
	}

	/**
	 * Setter for {@link Ward}
	 * 
	 * @param inWard
	 *            {@link Ward}
	 */
	public void setWard(final Ward inWard) {
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
