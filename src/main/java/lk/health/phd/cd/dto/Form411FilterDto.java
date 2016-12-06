package lk.health.phd.cd.dto;

import java.sql.Date;

import lk.health.phd.cd.models.Disease;
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
	private Disease notifiedDisease;
	private Date notifiedDateFrom;
	private Date notifiedDateTo;
	private Disease confirmedDisease;
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
	 * @param inPatientName
	 *            Name of the patient
	 */
	public void setPatientName(final String inPatientName) {
		this.patientName = inPatientName;
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
	 * @param inAgeFrom
	 *            Age from value
	 */
	public void setAgeFrom(final Integer inAgeFrom) {
		this.ageFrom = inAgeFrom;
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
	 * @param inAgeTo
	 *            Age to value
	 */
	public void setAgeTo(final Integer inAgeTo) {
		this.ageTo = inAgeTo;
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
	 * @param inSex
	 *            {@link Form411.Sex}
	 */
	public void setSex(final Form411.Sex inSex) {
		this.sex = inSex;
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
	 * @param inEthnicGroup
	 *            {@link Form411.EthnicGroup}
	 */
	public void setEthnicGroup(final Form411.EthnicGroup inEthnicGroup) {
		this.ethnicGroup = inEthnicGroup;
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
	 * @param inNotifiedDateFrom
	 *            Date when disease is notified (From date for date period)
	 */
	public void setNotifiedDateFrom(final Date inNotifiedDateFrom) {
		this.notifiedDateFrom = inNotifiedDateFrom;
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
	 * @param inNotifiedDateTo
	 *            Date when disease is notified (To date for date period)
	 */
	public void setNotifiedDateTo(final Date inNotifiedDateTo) {
		this.notifiedDateTo = inNotifiedDateTo;
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
	 * @param inConfirmedDateFrom
	 *            From date of disease is confirmed
	 */
	public void setConfirmedDateFrom(final Date inConfirmedDateFrom) {
		this.confirmedDateFrom = inConfirmedDateFrom;
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
	 * @param inConfirmedDateTo
	 *            To date of disease is confirmed
	 */
	public void setConfirmedDateTo(final Date inConfirmedDateTo) {
		this.confirmedDateTo = inConfirmedDateTo;
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
	 * @param inDateOnsetFrom
	 *            From date of onset
	 */
	public void setDateOnsetFrom(final Date inDateOnsetFrom) {
		this.dateOnsetFrom = inDateOnsetFrom;
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
	 * @param inDateOnsetTo
	 *            To date of onset
	 */
	public void setDateOnsetTo(final Date inDateOnsetTo) {
		this.dateOnsetTo = inDateOnsetTo;
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
	 * @param inHospitalizedFrom
	 *            Hospitalized from date
	 */
	public void setHospitalizedFrom(final Date inHospitalizedFrom) {
		this.hospitalizedFrom = inHospitalizedFrom;
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
	 * @param inHospitalizedTo
	 *            Hospitalized To date
	 */
	public void setHospitalizedTo(final Date inHospitalizedTo) {
		this.hospitalizedTo = inHospitalizedTo;
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
	 * @param inDischargedFrom
	 *            From Date of Discharged
	 */
	public void setDischargedFrom(final Date inDischargedFrom) {
		this.dischargedFrom = inDischargedFrom;
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
	 * @param inDischargedTo
	 *            To date of discharged
	 */
	public void setDischargedTo(final Date inDischargedTo) {
		this.dischargedTo = inDischargedTo;
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
	 * @param inHospital
	 *            Hospital where Hospitalized
	 */
	public void setHospital(final String inHospital) {
		this.hospital = inHospital;
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
	 * @param inOutcome
	 *            {@link Form411.Outcome}
	 */
	public void setOutcome(final Form411.Outcome inOutcome) {
		this.outcome = inOutcome;
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
	 * @param inIsolated
	 *            {@link Form411.WhereIsolated}
	 */
	public void setIsolated(final Form411.WhereIsolated inIsolated) {
		this.isolated = inIsolated;
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
	 * @param inPhiRange
	 *            PHI range
	 */
	public void setPhiRange(final String inPhiRange) {
		this.phiRange = inPhiRange;
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
	 * @param inMohRange
	 *            MOH range
	 */
	public void setMohRange(final String inMohRange) {
		this.mohRange = inMohRange;
	}

	/**
	 * Getter for notified Disease
	 * 
	 * @return {@link Disease}
	 */
	public Disease getNotifiedDisease() {
		return notifiedDisease;
	}

	/**
	 * Setter for notified disease.
	 * 
	 * @param notifiedDisease
	 *            {@link Disease}
	 */
	public void setNotifiedDisease(Disease notifiedDisease) {
		this.notifiedDisease = notifiedDisease;
	}

	/**
	 * Getter for confirmed Disease
	 * 
	 * @return {@link Disease}
	 */
	public Disease getConfirmedDisease() {
		return confirmedDisease;
	}

	/**
	 * Setter for confirmed disease
	 * 
	 * @param confirmedDisease
	 *            {@link Disease}
	 */
	public void setConfirmedDisease(Disease confirmedDisease) {
		this.confirmedDisease = confirmedDisease;
	}

}
