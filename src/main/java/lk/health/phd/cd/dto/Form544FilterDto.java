package lk.health.phd.cd.dto;

import java.sql.Date;

import lk.health.phd.cd.models.Disease;
import lk.health.phd.cd.models.Form544.Sex;
import lk.health.phd.cd.models.Institute;
import lk.health.phd.cd.models.MohArea;
import lk.health.phd.cd.models.Ward;
import lk.health.phd.cd.models.Workflow.WorkflowStatus;

/**
 * DTO class which is used to store Form544filtering values.
 * 
 * @author admin
 *
 */
public class Form544FilterDto {
	private String serialNo;
	private Institute institute;
	private Disease disease;
	private String patientName;
	private Date dateOfOnsetFrom;
	private Date dateOfOnsetTo;
	private Date dateOfAdmissionFrom;
	private Date dateOfAdmissionTo;
	private Date fromDateOfNotifyFromUnit;
	private Date toDateOfNotifyFromUnit;
	private Date fromDateOfNotifyToMoh;
	private Date toDateOfNotifyToMoh;
	private Long bhtNo;
	private Ward ward;
	private Integer ageFrom;
	private Integer ageTo;
	private Sex sex;
	private String notifierName;
	private WorkflowStatus workflowStatus;
	private MohArea mohArea;

	/**
	 * Getter for serial number of the entry.
	 * 
	 * @return serial number
	 */
	public String getSerialNo() {
		return serialNo;
	}

	/**
	 * Setter for serial number of the entry.
	 * 
	 * @param inSerialNo
	 *            Serial number of the entry
	 */
	public void setSerialNo(String inSerialNo) {
		this.serialNo = inSerialNo;
	}

	/**
	 * Getter for institute as a filtering field.
	 * 
	 * @return institute
	 */
	public Institute getInstitute() {
		return institute;
	}

	/**
	 * Setter for {@link Institute} as a filtering field.
	 * 
	 * @param institute
	 *            Institute name
	 */
	public void setInstitute(final Institute inInstitute) {
		this.institute = inInstitute;
	}

	/**
	 * Getter for disease as a filtering field.
	 * 
	 * @return {@link Disease}
	 */
	public Disease getDisease() {
		return disease;
	}

	/**
	 * Setter for Disease as a filtering field.
	 * 
	 * @param disease
	 *            {@link Disease}
	 */
	public void setDisease(final Disease inDisease) {
		this.disease = inDisease;
	}

	/**
	 * Getter for patient name as a filtering field.
	 * 
	 * @return patientName
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * Setter for patient name as a filtering field.
	 * 
	 * @param patientName
	 *            Name of the patient.
	 */
	public void setPatientName(final String inPatientName) {
		this.patientName = inPatientName;
	}

	/**
	 * Getter for Onset from date as a filtering field.
	 * 
	 * @return date of onset (from value for a duration)
	 */
	public Date getDateOfOnsetFrom() {
		return dateOfOnsetFrom;
	}

	/**
	 * Setter for Onset to date as a filtering field.
	 * 
	 * @param dateOfOnsetFrom
	 *            date of onset (to value for a duration)
	 */
	public void setDateOfOnsetFrom(final Date inDateOfOnsetFrom) {
		this.dateOfOnsetFrom = inDateOfOnsetFrom;
	}

	/**
	 * Getter for date of onset to as a filtering field.
	 * 
	 * @return date of onset (to value for a duration)
	 */
	public Date getDateOfOnsetTo() {
		return dateOfOnsetTo;
	}

	/**
	 * Setter for date of onset to as a filtering field.
	 * 
	 * @param dateOfOnsetTo
	 *            date of onset (to value for a duration)
	 */
	public void setDateOfOnsetTo(final Date inDateOfOnsetTo) {
		this.dateOfOnsetTo = inDateOfOnsetTo;
	}

	/**
	 * Getter for date of admission from as a filtering field.
	 * 
	 * @return date of admission (from value for a duration)
	 */
	public Date getDateOfAdmissionFrom() {
		return dateOfAdmissionFrom;
	}

	/**
	 * Setter for date of admission from as a filtering field.
	 * 
	 * @param dateOfAdmissionFrom
	 *            date of admission (from value for a duration)
	 */
	public void setDateOfAdmissionFrom(final Date inDateOfAdmissionFrom) {
		this.dateOfAdmissionFrom = inDateOfAdmissionFrom;
	}

	/**
	 * Getter for date of admission to as a filtering field.
	 * 
	 * @return dateOfAdmissionTo date of admission (to value for a duration)
	 */
	public Date getDateOfAdmissionTo() {
		return dateOfAdmissionTo;
	}

	/**
	 * Setter for date of admission to as a filtering field.
	 * 
	 * @param dateOfAdmissionTo
	 *            date of admission (to value for a duration)
	 */
	public void setDateOfAdmissionTo(final Date inDateOfAdmissionTo) {
		this.dateOfAdmissionTo = inDateOfAdmissionTo;
	}

	/**
	 * Getter for bed head ticket number as a filtering field.
	 * 
	 * @return bed head ticket number
	 */
	public Long getBhtNo() {
		return bhtNo;
	}

	/**
	 * Setter for bed head ticket number as a filtring field.
	 * 
	 * @param bhtNo
	 *            bed head ticket number
	 */
	public void setBhtNo(final Long inBhtNo) {
		this.bhtNo = inBhtNo;
	}

	/**
	 * Getter for {@link Ward} as a filtering field.
	 * 
	 * @return {@link Ward}
	 */
	public Ward getWard() {
		return ward;
	}

	/**
	 * Setter for {@link Ward} as a filtering field.
	 * 
	 * @param ward
	 *            {@link Ward}
	 */
	public void setWard(final Ward inWard) {
		this.ward = inWard;
	}

	/**
	 * Setter for age (from) as a filtering field.
	 * 
	 * @return age (from) for a duration
	 */
	public Integer getAgeFrom() {
		return ageFrom;
	}

	/**
	 * Setter for age (from) as a filtering field.
	 * 
	 * @param ageFrom
	 *            age (from) for a duration
	 */
	public void setAgeFrom(final Integer inAgeFrom) {
		this.ageFrom = inAgeFrom;
	}

	/**
	 * Getter for age (to) as a filtering field.
	 * 
	 * @return age to value for a duration
	 */
	public Integer getAgeTo() {
		return ageTo;
	}

	/**
	 * Setter for age (to) as a filtering field.
	 * 
	 * @param ageTo
	 *            age to value for a duration
	 */
	public void setAgeTo(final Integer inAgeTo) {
		this.ageTo = inAgeTo;
	}

	/**
	 * Getter for sex as a filtering value.
	 * 
	 * @return {@link Sex}
	 */
	public Sex getSex() {
		return sex;
	}

	/**
	 * Setter for sex as a filtering field.
	 * 
	 * @param sex
	 *            {@link Sex}
	 */
	public void setSex(final Sex inSex) {
		this.sex = inSex;
	}

	/**
	 * Getter for notifier name as a filtering field.
	 * 
	 * @return notifier name
	 */
	public String getNotifierName() {
		return notifierName;
	}

	/**
	 * Setter for notifier name as a filtering field.
	 * 
	 * @param notifierName
	 *            notifier name
	 */
	public void setNotifierName(final String inNotifierName) {
		this.notifierName = inNotifierName;
	}

	/**
	 * Getter for workflow status as a filtering field.
	 * 
	 * @return {@link WorkflowStatus}
	 */
	public WorkflowStatus getWorkflowStatus() {
		return workflowStatus;
	}

	/**
	 * Setter for wrkflow status as a filtering field.
	 * 
	 * @param workflowStatus
	 *            {@link WorkflowStatus}
	 */
	public void setWorkflowStatus(WorkflowStatus workflowStatus) {
		this.workflowStatus = workflowStatus;
	}

	/**
	 * Getter for {@link MohArea} as a filter field.
	 * 
	 * @return {@link MohArea}
	 */
	public MohArea getMohArea() {
		return mohArea;
	}

	/**
	 * Setter for {@link MohArea} as a filter field.
	 * 
	 * @param inMohArea
	 *            {@link MohArea}
	 */
	public void setMohArea(final MohArea inMohArea) {
		this.mohArea = inMohArea;
	}

	/**
	 * Getter for from date of notification form Unit/Ward
	 * 
	 * @return {@link Date} of notification from Unit/Ward
	 */
	public Date getFromDateOfNotifyFromUnit() {
		return fromDateOfNotifyFromUnit;
	}

	/**
	 * Setter for from date of notification from Unit/Ward.
	 * 
	 * @param inFromDateOfNotifyFromUnit
	 *            {@link Date} of notification from Unit/Ward
	 */
	public void setFromDateOfNotifyFromUnit(final Date inFromDateOfNotifyFromUnit) {
		this.fromDateOfNotifyFromUnit = inFromDateOfNotifyFromUnit;
	}

	/**
	 * Getter for to date of notification from Unit/Ward.
	 * 
	 * @return To {@link Date} of notification from Unit Ward.
	 */
	public Date getToDateOfNotifyFromUnit() {
		return toDateOfNotifyFromUnit;
	}

	/**
	 * Setter for to date of notification from Unit/Ward.
	 * 
	 * @param inToDateOfNotifyFromUnit
	 *            To {@link Date} of notification from Unit/Ward.
	 * 
	 * 
	 */
	public void setToDateOfNotifyFromUnit(final Date inToDateOfNotifyFromUnit) {
		this.toDateOfNotifyFromUnit = inToDateOfNotifyFromUnit;
	}

	/**
	 * Getter for from {@link Date} of notification to MOH.
	 * 
	 * @return From {@link Date} of notification to MOH.
	 */
	public Date getFromDateOfNotifyToMoh() {
		return fromDateOfNotifyToMoh;
	}

	/**
	 * Setter for from date of notification to MOH.
	 * 
	 * @param inFromDateOfNotifyToMoh
	 *            From {@link Date} of notification to MOH.
	 */
	public void setFromDateOfNotifyToMoh(final Date inFromDateOfNotifyToMoh) {
		this.fromDateOfNotifyToMoh = inFromDateOfNotifyToMoh;
	}

	/**
	 * Getter for to date of notification to MOH.
	 * 
	 * @return To {@link Date} of notification to MOH.
	 */
	public Date getToDateOfNotifyToMoh() {
		return toDateOfNotifyToMoh;
	}

	/**
	 * Setter for to {@link Date} of notification to MOH.
	 * 
	 * @param inToDateOfNotifyToMoh
	 *            To {@link Date} of notification to MOH
	 */
	public void setToDateOfNotifyToMoh(final Date inToDateOfNotifyToMoh) {
		this.toDateOfNotifyToMoh = inToDateOfNotifyToMoh;
	}

}
