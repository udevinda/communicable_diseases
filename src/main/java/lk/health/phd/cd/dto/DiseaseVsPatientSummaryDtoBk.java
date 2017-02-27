package lk.health.phd.cd.dto;

import lk.health.phd.cd.models.Disease;

public class DiseaseVsPatientSummaryDtoBk {

	private String disease;
	private Long count;

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
