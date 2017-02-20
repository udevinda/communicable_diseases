package lk.health.phd.cd.dto;

import java.util.List;

import lk.health.phd.cd.models.Disease;
import lk.health.phd.cd.models.MohArea;

public class MohAreaVsDiseaseSummaryDto {

	private String mohAreaName;
	private List<DiseaseVsPatientSummaryDto> diseaseVsPatientSummaryDtos;

	/**
	 * Getter for moh area name
	 * 
	 * @return moh area name
	 */
	public String getMohArea() {
		return mohAreaName;
	}

	/**
	 * Setter for moh area name
	 * 
	 * @param inMohArea
	 *            moh area name
	 */
	public void setMohArea(final String inMohAreaName) {
		this.mohAreaName = inMohAreaName;
	}

	/**
	 * Getter for list of {@link DiseaseVsPatientSummaryDto}
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
	 */
	public void setDiseaseVsPatientSummaryDtos(final List<DiseaseVsPatientSummaryDto> inDiseaseVsPatientSummaryDtos) {
		this.diseaseVsPatientSummaryDtos = inDiseaseVsPatientSummaryDtos;
	}

}
