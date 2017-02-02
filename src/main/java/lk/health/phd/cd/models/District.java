package lk.health.phd.cd.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model class to hold Districts in Sri Lanka.
 * 
 * @author admin
 *
 */
@Entity
@Table(name = "district")
public class District implements Serializable {

	private static final long serialVersionUID = 4865663981727397711L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "distrct_name", nullable = false)
	private String districtName;

	/**
	 * Getter for District IDs
	 * 
	 * @return ID of the District
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter for District ID.
	 * 
	 * @param id
	 *            ID of the district
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter for Name of the District
	 * 
	 * @return name of the District
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * Setter for name of the district.
	 * 
	 * @param districtName
	 *            Name of the district
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

}
