package lk.health.phd.cd.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;

/**
 * Model class for PatientContacts
 * 
 * @author admin
 *
 */

@Entity
@Table(name = "patient_contacts")
public class PatientContacts implements Serializable {

	private static final long serialVersionUID = -2164282212498428405L;

	public enum CategoryOfContactedPerson {
		HOSEHOLE, OTHER
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "age", nullable = false)
	private Integer age;

	@Column(name = "date_seen", nullable = false)
	private Date dateSeen;

	@Column(name = "observation", nullable = false)
	private String observation;

	/**
	 * Getter for id.
	 * 
	 * @return ID for the table record of contacted person.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter for id.
	 * 
	 * @param inId
	 *            ID for the table record of contacted person.
	 */
	public void setId(final Long inId) {
		this.id = inId;
	}

	/**
	 * Getter for name.
	 * 
	 * @return Name of the contacted person.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for name.
	 * 
	 * @param inName
	 *            Name of the contacted person.
	 */
	public void setName(final String inName) {
		this.name = inName;
	}

	/**
	 * Getter for age.
	 * 
	 * @return Age of the contacted person.
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Setter for age.
	 * 
	 * @param inAge
	 *            Age of the contacted person.
	 * 
	 */
	public void setAge(final Integer inAge) {
		age = inAge;
	}

	/**
	 * Getter for dateSeen.
	 * 
	 * @return Date of the contacted person seen.
	 */
	public Date getDateSeen() {
		return dateSeen;
	}

	/**
	 * Setter for dateSeen
	 * 
	 * @param inDateSeen
	 *            Date of the contacted person seen.
	 */
	public void setDateSeen(final Date inDateSeen) {
		this.dateSeen = inDateSeen;
	}

	/**
	 * Getter for observation.
	 * 
	 * @return observation.
	 */
	public String getObservation() {
		return observation;
	}

	/**
	 * Setter for observation.
	 * 
	 * @param inObservation
	 *            observation
	 */
	public void setObservation(final String inObservation) {
		this.observation = inObservation;
	}

}
