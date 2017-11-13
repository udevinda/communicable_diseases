package lk.health.phd.cd.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Model class for an institute of an {@link District}
 * 
 * @author admin
 *
 */

@Entity
@Table(name = "institute")
public class Institute implements Serializable {

	private static final long serialVersionUID = 4865173936727397711L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "district_id")
	private District district;

	/**
	 * Get the ID of the {@link Institute}
	 * 
	 * @return ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set the ID of the {@link Institute}
	 * 
	 * @param inId
	 *            ID of the Institute
	 */
	public void setId(final Long inId) {
		this.id = inId;
	}

	/**
	 * Get the name of the {@link Institute}
	 * 
	 * @return name of the {@link Institute}
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the {@link Institute}
	 * 
	 * @param inName
	 *            Name of the {@link Institute}
	 */
	public void setName(final String inName) {
		this.name = inName;
	}

	/**
	 * Get the {@link District} of the {@link Institute}
	 * 
	 * @return {@link District}
	 */
	public District getDistrict() {
		return district;
	}

	/**
	 * Set the {@link District} for the {@link Institute}
	 * 
	 * @param inDistrict
	 *            {@link District}
	 */
	public void setDistrict(final District inDistrict) {
		this.district = inDistrict;
	}

}
