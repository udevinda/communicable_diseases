package lk.health.phd.cd.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Model class to hold MOH areas of Districts.
 * 
 * @author admin
 *
 */

@Entity
@Table(name = "moh_area")
public class MohArea implements Serializable {

	private static final long serialVersionUID = 4865669438657397711L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@OneToOne
	@JoinColumn(name = "district_id")
	private District district;

	@Column(name = "moh_area", nullable = false)
	private String mohAreaName;

	/**
	 * Getter for MOH area ID.
	 * 
	 * @return ID of the MOH Area
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter for ID
	 * 
	 * @param id
	 *            Id of the MOH Area.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter for District.
	 * 
	 * @return {@link District}}
	 */
	public District getDistrict() {
		return district;
	}

	/**
	 * Setter for District
	 * 
	 * @param district
	 *            {@link District}}
	 */
	public void setDistrict(District district) {
		this.district = district;
	}

	/**
	 * Getter for MOH Area Name
	 * 
	 * @return Name of the MOH Area
	 */
	public String getMohAreaName() {
		return mohAreaName;
	}

	/**
	 * Setter for MOH area name.
	 * 
	 * @param mohAreaName
	 *            Name Of the MOH area.
	 */
	public void setMohAreaName(String mohAreaName) {
		this.mohAreaName = mohAreaName;
	}

}
