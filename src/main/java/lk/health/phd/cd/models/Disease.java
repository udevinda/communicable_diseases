package lk.health.phd.cd.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model class for disease.
 * 
 * @author admin
 *
 */

@Entity
@Table(name = "disease")
public class Disease implements Serializable {

	private static final long serialVersionUID = 4865683373727397711L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "disease_name", nullable = false)
	private String diseaseName;

	/**
	 * Getter for disease Id.
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter for disease Id.
	 * 
	 * @param id
	 *            disease ID.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter for disease Name.
	 * 
	 * @return disease name
	 */
	public String getDiseaseName() {
		return diseaseName;
	}

	/**
	 * Setter for disease name.
	 * 
	 * @param diseaseName
	 *            disease name
	 */
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

}
