package lk.health.phd.cd.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;

/**
 * Model class for Form 411
 * 
 * @author admin
 *
 */
@Entity
@Table(name = "form_411")
public class Form411 implements Serializable {

	private static final long serialVersionUID = -1130963589527032479L;

	public enum Sex {
		MALE, FEMALE, OTHER;
	}

	public enum EthnicGroup {
		SINHALESE, TAMIL, MUSLIMS, BURGHER, OTHERS
	}

	public enum Outcome {
		RECOVERED, DIED
	}

	public enum WhereIsolated {
		HOME, HOSPITAL
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "patient_name", nullable = false)
	private String patientName;

	@Column(name = "age", nullable = false)
	private Integer age;

	@Column(name = "sex", nullable = false)
	private Sex sex;

	@Column(name = "patient_address", nullable = false)
	private String patientAddress;

	@Column(name = "ethnic_group", nullable = false)
	private EthnicGroup ethnicGroup;

	@OneToOne
	@JoinColumn(name = "disease_as_nitified_id")
	private Disease diseaseAsNotified;

	@Column(name = "disease_notified_date", nullable = false)
	private Date diseaseNotifiedDate;

	@OneToOne
	@JoinColumn(name = "confirmed_disease_id")
	private Disease diseaseConfirmed;

	@Column(name = "disease_confirmed_date", nullable = false)
	private Date diseaseConfirmedDate;

	@Column(name = "date_on_set", nullable = false)
	private Date dateOfOnset;

	@Column(name = "date_of_hospitalization", nullable = false)
	private Date dateOfHospitalization;

	@Column(name = "date_of_discharged", nullable = false)
	private Date dateOfDischarged;

	@Column(name = "name_of_hospital", nullable = false)
	private String nameOfHospital;

	@Column(name = "outcome", nullable = false)
	private Outcome outcome;

	@Column(name = "where_isolated", nullable = false)
	private WhereIsolated whereIsolated;

	@Column(name = "patient_movement")
	private String patientsMovements;

	@Column(name = "laboratory_findings")
	private String laboratoryFindings;

	@OneToMany
	@JoinColumn(name = "form_411_id")
	private List<PatientContacts> patientContacts;

	@Column(name = "phi_range", nullable = false)
	private String phiRange;

	@Column(name = "moh_area", nullable = false)
	private String mohArea;

	@Column(name = "longitude", nullable = false)
	private Double longitude;

	@Column(name = "lattitude", nullable = false)
	private Double lattitude;

	/**
	 * Getter for Form 411 ID.
	 * 
	 * @return id of the Form 411
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter for Form 411 ID.
	 * 
	 * @param inId
	 *            ID of the form 411.
	 */
	public void setId(final Long inId) {
		this.id = inId;
	}

	/**
	 * Getter for patient name.
	 * 
	 * @return Name of the patient.
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * Setter for patient name.
	 * 
	 * @param inPatientName
	 *            Name of the patient.
	 */
	public void setPatientName(final String inPatientName) {
		this.patientName = inPatientName;
	}

	/**
	 * Getter for Age.
	 * 
	 * @return Age of the patient.
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Setter for age.
	 * 
	 * @param inAge
	 *            Age of the patient.
	 */
	public void setAge(final Integer inAge) {
		this.age = inAge;
	}

	/**
	 * Getter for sex.
	 * 
	 * @return {@link Sex}
	 */
	public Sex getSex() {
		return sex;
	}

	/**
	 * Setter for patient Sex
	 * 
	 * @param inSex
	 *            {@link Sex}
	 */
	public void setSex(final Sex inSex) {
		this.sex = inSex;
	}

	/**
	 * Getter for patient's address.
	 * 
	 * @return Patient's address
	 */
	public String getPatientAddress() {
		return patientAddress;
	}

	/**
	 * Setter for patients address.
	 * 
	 * @param inPatientAddress
	 *            patient address.
	 */
	public void setPatientAddress(final String inPatientAddress) {
		this.patientAddress = inPatientAddress;
	}

	/**
	 * Getter for patient ethnic group.
	 * 
	 * @return {@link EthnicGroup}
	 */
	public EthnicGroup getEthnicGroup() {
		return ethnicGroup;
	}

	/**
	 * Getter for patient ethnic group.
	 * 
	 * @param inEthnicGroup
	 *            {@link EthnicGroup}
	 */
	public void setEthnicGroup(final EthnicGroup inEthnicGroup) {
		this.ethnicGroup = inEthnicGroup;
	}

	/**
	 * Getter for patient disease.
	 * 
	 * @return {@link Disease}
	 */
	public Disease getDiseaseAsNotified() {
		return diseaseAsNotified;
	}

	/**
	 * Setter for {@link Disease} as notified.
	 * 
	 * @param inDiseaseAsNotified
	 *            {@link Disease}
	 */
	public void setDiseaseAsNotified(final Disease inDiseaseAsNotified) {
		this.diseaseAsNotified = inDiseaseAsNotified;
	}

	/**
	 * Getter for disease notified date.
	 * 
	 * @return Disease notified Date.
	 */
	public Date getDiseaseNotifiedDate() {
		return diseaseNotifiedDate;
	}

	/**
	 * Setter for disease notified date.
	 * 
	 * @param inDiseaseNotifiedDate
	 *            Disease notified date
	 */
	public void setDiseaseNotifiedDate(final Date inDiseaseNotifiedDate) {
		this.diseaseNotifiedDate = inDiseaseNotifiedDate;
	}

	/**
	 * Getter for confirmed {@link Disease}
	 * 
	 * @return {@link Disease}
	 */
	public Disease getDiseaseConfirmed() {
		return diseaseConfirmed;
	}

	/**
	 * Setter for confirmed {@link Disease}
	 * 
	 * @param inDiseaseConfirmed
	 *            {@link Disease}
	 */
	public void setDiseaseConfirmed(final Disease inDiseaseConfirmed) {
		this.diseaseConfirmed = inDiseaseConfirmed;
	}

	/**
	 * Getter for disease confirmed date.
	 * 
	 * @return Date of disease confirmed.
	 */
	public Date getDiseaseConfirmedDate() {
		return diseaseConfirmedDate;
	}

	/**
	 * Setter for disease confirmed date.
	 * 
	 * @param inDiseaseConfirmedDate
	 *            Date of disease confirmed.
	 */
	public void setDiseaseConfirmedDate(final Date inDiseaseConfirmedDate) {
		this.diseaseConfirmedDate = inDiseaseConfirmedDate;
	}

	/**
	 * Getter for date of onset.
	 * 
	 * @return date of onset.
	 */
	public Date getDateOfOnset() {
		return dateOfOnset;
	}

	/**
	 * Setter for dateOfOnset
	 * 
	 * @param inDateOfOnset
	 *            date of on set.
	 */
	public void setDateOfOnset(final Date inDateOfOnset) {
		this.dateOfOnset = inDateOfOnset;
	}

	/**
	 * Getter for date of hospitalized.
	 * 
	 * @return date of hospitalized
	 */
	public Date getDateOfHospitalization() {
		return dateOfHospitalization;
	}

	/**
	 * Setter for date of hospitalized.
	 * 
	 * @param inDateOfHospitalization
	 *            date of hospitalized.
	 */
	public void setDateOfHospitalization(final Date inDateOfHospitalization) {
		this.dateOfHospitalization = inDateOfHospitalization;
	}

	/**
	 * Getter for date of discharged.
	 * 
	 * @return date of discharged.
	 */
	public Date getDateOfDischarged() {
		return dateOfDischarged;
	}

	/**
	 * Setter for date of discharged.
	 * 
	 * @param inDateOfDischarged
	 *            Date of discharged.
	 */
	public void setDateOfDischarged(final Date inDateOfDischarged) {
		this.dateOfDischarged = inDateOfDischarged;
	}

	/**
	 * Getter for name of hospital.
	 * 
	 * @return name of the hospital where hospitalized.
	 */
	public String getNameOfHospital() {
		return nameOfHospital;
	}

	/**
	 * Setter for name of the hospital.
	 * 
	 * @param inNameOfHospital
	 *            Name of the hospital where hospitalized.
	 */
	public void setNameOfHospital(final String inNameOfHospital) {
		this.nameOfHospital = inNameOfHospital;
	}

	/**
	 * Getter for {@link Outcome}
	 * 
	 * @return Whether patient is died or survived.
	 */
	public Outcome getOutcome() {
		return outcome;
	}

	/**
	 * Setter for patien's {@link Outcome}
	 * 
	 * @param inOutcome
	 *            Whether patient is died or survived.
	 */
	public void setOutcome(final Outcome inOutcome) {
		this.outcome = inOutcome;
	}

	/**
	 * Getter for whereIsolated.
	 * 
	 * @return Where the patient is isolated
	 */
	public WhereIsolated getWhereIsolated() {
		return whereIsolated;
	}

	/**
	 * Setter for whereIsolated.
	 * 
	 * @param inWhereIsolated
	 *            Where the patient is isolated.
	 */
	public void setWhereIsolated(final WhereIsolated inWhereIsolated) {
		this.whereIsolated = inWhereIsolated;
	}

	/**
	 * Getter for patientsMovements.
	 * 
	 * @return patients movements while sick.
	 */
	public String getPatientsMovements() {
		return patientsMovements;
	}

	/**
	 * Setter for patientMovement.
	 * 
	 * @param inPatientsMovements
	 *            Patient movement while sick.
	 */
	public void setPatientsMovements(final String inPatientsMovements) {
		this.patientsMovements = inPatientsMovements;
	}

	/**
	 * Setter for laborataryFindings.
	 * 
	 * @return Any statement on laboratory findings
	 */
	public String getLaboratoryFindings() {
		return laboratoryFindings;
	}

	/**
	 * Setter for laboratoryFindings.
	 * 
	 * @param inLaboratoryFindings
	 *            Any statement on laboratory findings
	 */
	public void setLaboratoryFindings(final String inLaboratoryFindings) {
		this.laboratoryFindings = inLaboratoryFindings;
	}

	/**
	 * Getter for {@link PatientContacts}
	 * 
	 * @return {@link PatientContacts}
	 */
	public List<PatientContacts> getPatientContacts() {
		return patientContacts;
	}

	/**
	 * Setter for {@link PatientContacts}
	 * 
	 * @param inPatientContacts
	 *            {@link PatientContacts}
	 */
	public void setPatientContacts(final List<PatientContacts> inPatientContacts) {
		this.patientContacts = inPatientContacts;
	}

	/**
	 * Getter for PHI range.
	 * 
	 * @return PHI range
	 */
	public String getPhiRange() {
		return phiRange;
	}

	/**
	 * Setter for PHI range.
	 * 
	 * @param inPhiRange
	 *            PHI range
	 */
	public void setPhiRange(final String inPhiRange) {
		this.phiRange = inPhiRange;
	}

	/**
	 * Getter for MOH area.
	 * 
	 * @return MOH Area.
	 */
	public String getMohArea() {
		return mohArea;
	}

	/**
	 * Setter for MOH area.
	 * 
	 * @param inMohArea
	 *            MOH area
	 */
	public void setMohArea(final String inMohArea) {
		this.mohArea = inMohArea;
	}

	/**
	 * Getter for longitude.
	 * 
	 * @return longitude of the location.
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * Setter for longitude.
	 * 
	 * @param inLongitude
	 *            longitude of the location.
	 */
	public void setLongitude(final Double inLongitude) {
		this.longitude = inLongitude;
	}

	/**
	 * Getter for latitude.
	 * 
	 * @return latitude of the location.
	 */
	public Double getLattitude() {
		return lattitude;
	}

	/**
	 * Setter for latitude.
	 * 
	 * @param inLattitude
	 *            latitude of the location.
	 */
	public void setLattitude(final Double inLattitude) {
		this.lattitude = inLattitude;
	}

}
