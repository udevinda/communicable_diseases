package lk.health.phd.cd.dto;

import java.sql.Date;

import lk.health.phd.cd.models.Form411;

/**
 * DTO class which contains the filtering criterias with filtering values.
 * 
 * @author admin
 *
 */
public class Form411FilterDto {

	private String patientName;
	private Integer ageFrom;
	private Integer ageTo;
	private Form411.Sex sex;
	private Form411.EthnicGroup ethnicGroup;
	private Long notifiedDiseaseId;
	private Date notifiedDateFrom;
	private Date notifiedDateTo;
	private Long confirmedDiseaseId;
	private Date confirmedDateFrom;
	private Date confirmedDateTo;
	private Date dateOnsetFrom;
	private Date dateOnsetTo;
	private Date hospitalizedFrom;
	private Date hospitalizedTo;
	private Date dischargedFrom;
	private Date dischargedTo;
	private String hospital;
	private Form411.Outcome outcome;
	private Form411.WhereIsolated isolated;
	private String phiRange;
	private String mohRange;

	/**
	 * Getter for patient's name.
	 * 
	 * @return Patient name
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * Setter for patient's name
	 * 
	 * @param patientName
	 *            Name of the patient
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 * Getter for age from amount.
	 * 
	 * @return age from amount
	 */
	public Integer getAgeFrom() {
		return ageFrom;
	}

	/**
	 * Setter for age from amount.
	 * 
	 * @param ageFrom
	 *            Age from value
	 */
	public void setAgeFrom(Integer ageFrom) {
		this.ageFrom = ageFrom;
	}

	/**
	 * Getter for age to amount.
	 * 
	 * @return Age to value
	 */
	public Integer getAgeTo() {
		return ageTo;
	}

	/**
	 * Setter for age to value.
	 * 
	 * @param ageTo
	 *            Age to value
	 */
	public void setAgeTo(Integer ageTo) {
		this.ageTo = ageTo;
	}

	/**
	 * Getter for patient's sex.
	 * 
	 * @return {@link Form411.Sex}
	 */
	public Form411.Sex getSex() {
		return sex;
	}

	/**
	 * Setter for patient sex.
	 * 
	 * @param sex
	 *            {@link Form411.Sex}
	 */
	public void setSex(Form411.Sex sex) {
		this.sex = sex;
	}

	/**
	 * Getter for ethnic group.
	 * 
	 * @return {@link Form411.EthnicGroup}
	 */
	public Form411.EthnicGroup getEthnicGroup() {
		return ethnicGroup;
	}

	/**
	 * Setter for ethnic group.
	 * 
	 * @param ethnicGroup
	 *            {@link Form411.EthnicGroup}
	 */
	public void setEthnicGroup(Form411.EthnicGroup ethnicGroup) {
		this.ethnicGroup = ethnicGroup;
	}

	/**
	 * Getter for Disease ID which is notified.
	 * 
	 * @return Notified disease ID
	 */
	public Long getNotifiedDiseaseId() {
		return notifiedDiseaseId;
	}

	/**
	 * Setter for Notified disease Id
	 * 
	 * @param notifiedDiseaseId
	 *            Notified disease Id
	 */
	public void setNotifiedDiseaseId(Long notifiedDiseaseId) {
		this.notifiedDiseaseId = notifiedDiseaseId;
	}

	/**
	 * Getter for When Disease is notified (From date for date period)
	 * 
	 * @return Date when Disease is notified (From date for date period)
	 */
	public Date getNotifiedDateFrom() {
		return notifiedDateFrom;
	}

	/**
	 * Setter for when disease is notified (From date for date period)
	 * 
	 * @param notifiedDateFrom
	 *            Date when disease is notified (From date for date period)
	 */
	public void setNotifiedDateFrom(Date notifiedDateFrom) {
		this.notifiedDateFrom = notifiedDateFrom;
	}

	/**
	 * Getter for when disease is notified (To date for date period)
	 * 
	 * @return Date when disease is notified (To date for date period)
	 */
	public Date getNotifiedDateTo() {
		return notifiedDateTo;
	}

	/**
	 * Setter for when disease is notified (To date for period)
	 * 
	 * @param notifiedDateTo
	 *            Date when disease is notified (To date for date period)
	 */
	public void setNotifiedDateTo(Date notifiedDateTo) {
		this.notifiedDateTo = notifiedDateTo;
	}

	/**
	 * Getter for confirmed disease ID
	 * 
	 * @return ID of the confirmed disease.
	 */
	public Long getConfirmedDiseaseId() {
		return confirmedDiseaseId;
	}

	/**
	 * Setter for confirmed disease ID.
	 * 
	 * @param confirmedDiseaseId
	 *            ID of the confirmed disease.
	 */
	public void setConfirmedDiseaseId(Long confirmedDiseaseId) {
		this.confirmedDiseaseId = confirmedDiseaseId;
	}

	/**
	 * Getter for when disease is confirmed (From date for period).
	 * 
	 * @return From date of disease is confirmed.
	 */
	public Date getConfirmedDateFrom() {
		return confirmedDateFrom;
	}

	/**
	 * Setter for when disease is confirmed (From date for period)
	 * 
	 * @param confirmedDateFrom
	 *            From date of disease is confirmed
	 */
	public void setConfirmedDateFrom(Date confirmedDateFrom) {
		this.confirmedDateFrom = confirmedDateFrom;
	}

	/**
	 * Getter for when disease is confirmed (To date for period)
	 * 
	 * @return To date of disease is confirmed
	 */
	public Date getConfirmedDateTo() {
		return confirmedDateTo;
	}

	/**
	 * Setter for when disease is confirmed (To date for period)
	 * 
	 * @param confirmedDateTo
	 *            To date of disease is confirmed
	 */
	public void setConfirmedDateTo(Date confirmedDateTo) {
		this.confirmedDateTo = confirmedDateTo;
	}

	/**
	 * Getter for when on set (from date for period)
	 * 
	 * @return From date of OnSet
	 */
	public Date getDateOnsetFrom() {
		return dateOnsetFrom;
	}

	/**
	 * Setter for when on set (from date for period)
	 * 
	 * @param dateOnsetFrom
	 *            From date of onset
	 */
	public void setDateOnsetFrom(Date dateOnsetFrom) {
		this.dateOnsetFrom = dateOnsetFrom;
	}

	/**
	 * Getter for when on set (To date for period)
	 * 
	 * @return To date of on set
	 */
	public Date getDateOnsetTo() {
		return dateOnsetTo;
	}

	/**
	 * Setter for when on set (To date for period)
	 * 
	 * @param dateOnsetTo
	 *            To date of onset
	 */
	public void setDateOnsetTo(Date dateOnsetTo) {
		this.dateOnsetTo = dateOnsetTo;
	}

	/**
	 * Getter for when hospitalized (To date for period)
	 * 
	 * @return Hospitalized from date
	 */
	public Date getHospitalizedFrom() {
		return hospitalizedFrom;
	}

	/**
	 * Setter for when hospitalized (From date for period)
	 * 
	 * @param hospitalizedFrom
	 *            Hospitalized from date
	 */
	public void setHospitalizedFrom(Date hospitalizedFrom) {
		this.hospitalizedFrom = hospitalizedFrom;
	}

	/**
	 * Getter for when hospitalized (To date for period)
	 * 
	 * @return Hospitalized To date
	 */
	public Date getHospitalizedTo() {
		return hospitalizedTo;
	}

	/**
	 * Setter for when hospitalized (To date for period)
	 * 
	 * @param hospitalizedTo
	 *            Hospitalized To date
	 */
	public void setHospitalizedTo(Date hospitalizedTo) {
		this.hospitalizedTo = hospitalizedTo;
	}

	/**
	 * Getter for when discharged (From date for period)
	 * 
	 * @return From Date of discharged
	 */
	public Date getDischargedFrom() {
		return dischargedFrom;
	}

	/**
	 * Setter for when discharged (From date for period)
	 * 
	 * @param dischargedFrom
	 *            From Date of Discharged
	 */
	public void setDischargedFrom(Date dischargedFrom) {
		this.dischargedFrom = dischargedFrom;
	}

	/**
	 * Getter for when discharged (To date for period)
	 * 
	 * @return To date of discharged
	 */
	public Date getDischargedTo() {
		return dischargedTo;
	}

	/**
	 * Setter for when discharged (To date for period)
	 * 
	 * @param dischargedTo
	 *            To date of discharged
	 */
	public void setDischargedTo(Date dischargedTo) {
		this.dischargedTo = dischargedTo;
	}

	/**
	 * Getter for hospital.
	 * 
	 * @return Hospital where hospitalized
	 */
	public String getHospital() {
		return hospital;
	}

	/**
	 * Setter for hospital.
	 * 
	 * @param hospital
	 *            Hospital where Hospitalized
	 */
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	/**
	 * Getter for {@link Form411.Outcome}
	 * 
	 * @return {@link Form411.Outcome}
	 */
	public Form411.Outcome getOutcome() {
		return outcome;
	}

	/**
	 * Setter for {@link Form411.Outcome}
	 * 
	 * @param outcome
	 *            {@link Form411.Outcome}
	 */
	public void setOutcome(Form411.Outcome outcome) {
		this.outcome = outcome;
	}

	/**
	 * Getter for {@link Form411.WhereIsolated}
	 * 
	 * @return {@link Form411.WhereIsolated}
	 */
	public Form411.WhereIsolated getIsolated() {
		return isolated;
	}

	/**
	 * Setter for {@link Form411.WhereIsolated}
	 * 
	 * @param isolated
	 *            {@link Form411.WhereIsolated}
	 */
	public void setIsolated(Form411.WhereIsolated isolated) {
		this.isolated = isolated;
	}

	/**
	 * Getter for related PHI range.
	 * 
	 * @return PHI range
	 */
	public String getPhiRange() {
		return phiRange;
	}

	/**
	 * Setter for PHI range
	 * 
	 * @param phiRange
	 *            PHI range
	 */
	public void setPhiRange(String phiRange) {
		this.phiRange = phiRange;
	}

	/**
	 * Getter for MOH range.
	 * 
	 * @return MOH range
	 */
	public String getMohRange() {
		return mohRange;
	}

	/**
	 * Setter for MOH range
	 * 
	 * @param mohRange
	 *            MOH range
	 */
	public void setMohRange(String mohRange) {
		this.mohRange = mohRange;
	}

}
