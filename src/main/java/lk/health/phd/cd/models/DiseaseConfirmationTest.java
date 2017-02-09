package lk.health.phd.cd.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Model class to hold Form 544 disease confirmation test details.
 * 
 * @author admin
 *
 */

@Entity
@Table(name = "disease_confirmation_test")
public class DiseaseConfirmationTest implements Serializable {

	private static final long serialVersionUID = 4865923471727397711L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "test_name")
	private String testName;

	@Column(name = "sample_collection_date")
	private Date sampleCollectionDate;

	@Column(name = "name_of_lab")
	private String nameOfLab;

	@Column(name = "result")
	private String result;

	@OneToOne
	@JoinColumn(name = "form544_id")
	private Form544 form544;

	/**
	 * Getter for record ID
	 * 
	 * @return ID of the record
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter for record ID.
	 * 
	 * @param inId
	 *            ID of the record
	 */
	public void setId(final Long inId) {
		this.id = inId;
	}

	/**
	 * Getter for the name of the test.
	 * 
	 * @return Name of the test
	 */
	public String getTestName() {
		return testName;
	}

	/**
	 * Setter for name of the test
	 * 
	 * @param inTestName
	 *            Test Name
	 */
	public void setTestName(final String inTestName) {
		this.testName = inTestName;
	}

	/**
	 * Getter for sample collection {@link Date}
	 * 
	 * @return {@link Date} when sample collected
	 */
	public Date getSampleCollectionDate() {
		return sampleCollectionDate;
	}

	/**
	 * Setter for sample collection {@link Date}
	 * 
	 * @param sampleCollectionDate
	 *            {@link Date} of the sample collection date
	 */
	public void setSampleCollectionDate(final Date inSampleCollectionDate) {
		this.sampleCollectionDate = inSampleCollectionDate;
	}

	/**
	 * Getter for name of the lab.
	 * 
	 * @return name of the lab
	 */
	public String getNameOfLab() {
		return nameOfLab;
	}

	/**
	 * Setter for name of the lab.
	 * 
	 * @param inNameOfLab
	 *            Name of the lab
	 */
	public void setNameOfLab(final String inNameOfLab) {
		this.nameOfLab = inNameOfLab;
	}

	/**
	 * Getter for disease test result
	 * 
	 * @return Result of the disease test
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Setter for the disease test result
	 * 
	 * @param inResult
	 *            Result of the disease test.
	 */
	public void setResult(final String inResult) {
		this.result = inResult;
	}

	/**
	 * Getter for {@link Form544}
	 * 
	 * @return {@link Form544}
	 */
	public Form544 getForm544() {
		return form544;
	}

	/**
	 * Setter for {@link Form544}
	 * 
	 * @param form544
	 *            {@link Form544}
	 */
	public void setForm544(final Form544 inForm544) {
		this.form544 = inForm544;
	}

}
