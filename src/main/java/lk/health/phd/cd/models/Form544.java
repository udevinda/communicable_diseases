package lk.health.phd.cd.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Model class for Form544.
 * 
 * @author admin
 *
 */
@Entity
@Table(name = "form_544")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@form544Id")
public class Form544 implements Serializable {

	private static final long serialVersionUID = 5714134454387505650L;

	public enum Sex {
		MALE, FEMALE, OTHER;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "serial_no", nullable = false)
	private String serialNo;

	@ManyToOne
	@JoinColumn(name = "institute_id", nullable = false)
	private Institute institute;

	@OneToOne
	@JoinColumn(name = "disease_id")
	private Disease disease;

	@Column(name = "patient_name", nullable = false)
	private String patientName;

	@Column(name = "date_of_onset")
	private Date dateOfOnset;

	@Column(name = "peaditiric_patients_gurdian_name")
	private String peaditiricPatientsGurdianName;

	@Column(name = "date_of_admission", nullable = false)
	private Date dateOfAdmission;

	@Column(name = "bht_no", nullable = false)
	private Long bhtNo;

	@ManyToOne
	@JoinColumn(name = "ward_id", nullable = false)
	private Ward ward;

	@Column(name = "age", nullable = false)
	private Integer age;

	@Column(name = "sex", nullable = false)
	private Sex sex;

	@Column(name = "patient_home_address")
	private String patientHomeAddress;

	@Column(name = "patient_home_phone_no")
	private String patientsHomePhoneNo;

	@Column(name = "notifier_name", nullable = false)
	private String notifierName;

	@Column(name = "notifier_status", nullable = false)
	private String notifierStatus;

	@Column(name = "system_notified_date", nullable = false)
	private Date systemNotifiedDate;

	@OneToOne
	@JoinColumn(name = "workflow_id")
	private Workflow workflow;

	@OneToOne
	@JoinColumn(name = "moh_area_id")
	private MohArea mohArea;

	@Column(name = "noti_by_unit_date", nullable = false)
	private Date notificationByUnitDate;

	@Column(name = "noti_to_moh_date", nullable = false)
	private Date notificationToMohDate;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "lattitude")
	private Double lattitude;

	@Column(name = "longitude")
	private Double longitude;

	/**
	 * Getter for Id.
	 * 
	 * @return Form544 Id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter for Id.
	 * 
	 * @param inId
	 *            Form544 Id
	 * 
	 */
	public void setId(final Long inId) {
		this.id = inId;
	}

	/**
	 * Getter for serial number of the entry
	 * 
	 * @return Serial Number
	 */
	public String getSerialNo() {
		return serialNo;
	}

	/**
	 * Setter for Serial number of the entry
	 * 
	 * @param inSerialNo
	 *            Serial Number
	 */
	public void setSerialNo(final String inSerialNo) {
		this.serialNo = inSerialNo;
	}

	/**
	 * Getter for admitted {@link Institute}.
	 * 
	 * @return {@link Institute}
	 */
	public Institute getInstitute() {
		return institute;
	}

	/**
	 * Setter for admitted {@link Institute}.
	 * 
	 * @param inInstitute
	 *            Admitted {@link Institute}
	 */
	public void setInstitute(final Institute inInstitute) {
		this.institute = inInstitute;
	}

	/**
	 * Getter for disease.
	 * 
	 * @return {@link Disease}
	 */
	public Disease getDisease() {
		return disease;
	}

	/**
	 * Setter for disease.
	 * 
	 * @param inDisease
	 *            {@link Disease}
	 */
	public void setDisease(final Disease inDisease) {
		this.disease = inDisease;
	}

	/**
	 * Getter for patient name.
	 * 
	 * @return patientName
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * Setter for patient name.
	 * 
	 * @param inPatientName
	 *            Patient name.
	 */
	public void setPatientName(final String inPatientName) {
		this.patientName = inPatientName;
	}

	/**
	 * Getter for patient date of onset.
	 * 
	 * @return date of onset
	 */
	public Date getDateOfOnset() {
		return dateOfOnset;
	}

	/**
	 * Setter for date of onset.
	 * 
	 * @param inDateOfOnset
	 *            date of onset
	 */
	public void setDateOfOnset(final Date inDateOfOnset) {
		this.dateOfOnset = inDateOfOnset;
	}

	/**
	 * Getter for peaditiric patient gurdian name.
	 * 
	 * @return peaditiricPatientsGurdianName
	 */
	public String getPeaditiricPatientsGurdianName() {
		return peaditiricPatientsGurdianName;
	}

	/**
	 * Setter for peaditiric patient gurdian name.
	 * 
	 * @param inPeaditiricPatientsGurdianName
	 *            peaditiricPatientsGurdianName
	 */
	public void setPeaditiricPatientsGurdianName(final String inPeaditiricPatientsGurdianName) {
		this.peaditiricPatientsGurdianName = inPeaditiricPatientsGurdianName;
	}

	/**
	 * Getter for date of admission
	 * 
	 * @return dateOfAdmission
	 */
	public Date getDateOfAdmission() {
		return dateOfAdmission;
	}

	/**
	 * Setter for date of admission.
	 * 
	 * @param inDateOfAdmission
	 *            dateOfAdmission
	 */
	public void setDateOfAdmission(final Date inDateOfAdmission) {
		this.dateOfAdmission = inDateOfAdmission;
	}

	/**
	 * Getter for bead head ticket number.
	 * 
	 * @return bhtNo
	 */
	public Long getBhtNo() {
		return bhtNo;
	}

	/**
	 * Setter for bead head ticket number.
	 * 
	 * @param inBhtNo
	 *            bhtNo
	 */
	public void setBhtNo(final Long inBhtNo) {
		this.bhtNo = inBhtNo;
	}

	/**
	 * Getter for admitted {@link Ward}.
	 * 
	 * @return {@link Ward}
	 */
	public Ward getWard() {
		return ward;
	}

	/**
	 * Setter for admitted {@link Ward}.
	 * 
	 * @param inWard
	 *            {@link Ward}
	 */
	public void setWard(final Ward inWard) {
		this.ward = inWard;
	}

	/**
	 * Getter for patient age (age is in days).
	 * 
	 * @return number of days
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Setter for patient age (age in days).
	 * 
	 * @param inAge
	 *            number of days
	 */
	public void setAge(final Integer inAge) {
		this.age = inAge;
	}

	/**
	 * Getter for patient sex.
	 * 
	 * @return sex
	 */
	public Sex getSex() {
		return sex;
	}

	/**
	 * Setter for patient sex.
	 * 
	 * @param inSex
	 *            sex
	 */
	public void setSex(final Sex inSex) {
		this.sex = inSex;
	}

	/**
	 * Getter for patient home address.
	 * 
	 * @return patient home address
	 */
	public String getPatientHomeAddress() {
		return patientHomeAddress;
	}

	/**
	 * Setter for patient home address.
	 * 
	 * @param inPatientHomeAddress
	 *            patient home address
	 */
	public void setPatientHomeAddress(final String inPatientHomeAddress) {
		this.patientHomeAddress = inPatientHomeAddress;
	}

	/**
	 * Getter for patient hme phone number.
	 * 
	 * @return patientsHomePhoneNo
	 */
	public String getPatientsHomePhoneNo() {
		return patientsHomePhoneNo;
	}

	/**
	 * Setter for patien hoe phone number.
	 * 
	 * @param inPatientsHomePhoneNo
	 *            patient home phone number
	 */
	public void setPatientsHomePhoneNo(final String inPatientsHomePhoneNo) {
		this.patientsHomePhoneNo = inPatientsHomePhoneNo;
	}

	/**
	 * Getter for notifier name.
	 * 
	 * @return notifierName.
	 */
	public String getNotifierName() {
		return notifierName;
	}

	/**
	 * Setter for notifier name.
	 * 
	 * @param inNotifierName
	 *            notifierName
	 */
	public void setNotifierName(final String inNotifierName) {
		this.notifierName = inNotifierName;
	}

	/**
	 * Getter for notifier status.
	 * 
	 * @return notifierStatus
	 */
	public String getNotifierStatus() {
		return notifierStatus;
	}

	/**
	 * Setter for notifier status.
	 * 
	 * @param inNotifierStatus
	 *            notfier status.
	 */
	public void setNotifierStatus(final String inNotifierStatus) {
		this.notifierStatus = inNotifierStatus;
	}

	/**
	 * Getter for system notified date.
	 * 
	 * @return systemNotifiedDate
	 */
	public Date getSystemNotifiedDate() {
		return systemNotifiedDate;
	}

	/**
	 * Setter for system notified date.
	 * 
	 * @param inSystemNotifiedDate
	 *            systemNotifiedDate
	 */
	public void setSystemNotifiedDate(final Date inSystemNotifiedDate) {
		this.systemNotifiedDate = inSystemNotifiedDate;
	}

	/**
	 * Getter for workflow.
	 * 
	 * @return {@link Workflow}
	 */
	public Workflow getWorkflow() {
		return workflow;
	}

	/**
	 * Setter for workflow.
	 * 
	 * @param inWorkflow
	 *            {@link Workflow}
	 */
	public void setWorkflow(final Workflow inWorkflow) {
		this.workflow = inWorkflow;
	}

	/**
	 * Getter for {@link MohArea}.
	 * 
	 * @return {@link MohArea}
	 */
	public MohArea getMohArea() {
		return mohArea;
	}

	/**
	 * Setter for {@link MohArea}
	 * 
	 * @param inMohArea
	 *            {@link MohArea}
	 */
	public void setMohArea(final MohArea inMohArea) {
		this.mohArea = inMohArea;
	}

	/**
	 * Getter for Date of notification by unit/ward
	 * 
	 * @return Date of notification by unit/ward
	 */
	public Date getNotificationByUnitDate() {
		return notificationByUnitDate;
	}

	/**
	 * Setter for Date of notification by unit/ward
	 * 
	 * @param inNotificationByUnitDate
	 *            Date of notification by unit/ward
	 */
	public void setNotificationByUnitDate(final Date inNotificationByUnitDate) {
		this.notificationByUnitDate = inNotificationByUnitDate;
	}

	/**
	 * Getter for date of notification to MOH
	 * 
	 * @return Date of notification to MOH
	 */
	public Date getNotificationToMohDate() {
		return notificationToMohDate;
	}

	/**
	 * Setter for notification to MOH
	 * 
	 * @param inNotificationToMohDate
	 *            Date of notification to MOH
	 */
	public void setNotificationToMohDate(final Date inNotificationToMohDate) {
		this.notificationToMohDate = inNotificationToMohDate;
	}

	/**
	 * Getter for remarks
	 * 
	 * @return remark statement
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * Setter for remarks
	 * 
	 * @param inRemarks
	 *            Remark statement
	 */
	public void setRemarks(final String inRemarks) {
		this.remarks = inRemarks;
	}

	/**
	 * Getter for lattitude of the location.
	 * 
	 * @return lattitude value of the location
	 */
	public Double getLattitude() {
		return lattitude;
	}

	/**
	 * Setter for lattitude of the location.
	 * 
	 * @param inLattitude
	 *            Lattitude of the location.
	 */
	public void setLattitude(final Double inLattitude) {
		this.lattitude = inLattitude;
	}

	/**
	 * Getter for longitude of the location.
	 * 
	 * @return Longitude of the location.
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * Setter for longitude of the location.
	 * 
	 * @param inLongitude
	 *            Longitude of the location
	 */
	public void setLongitude(final Double inLongitude) {
		this.longitude = inLongitude;
	}

}
