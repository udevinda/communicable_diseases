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
 * Model class for a ward of an {@link Institute}
 * 
 * @author admin
 *
 */

@Entity
@Table(name = "ward")
public class Ward implements Serializable {

	private static final long serialVersionUID = 4865173936727310375L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "institute_id")
	private Institute institute;

	/**
	 * Get the ID of the {@link Ward}
	 * 
	 * @return
	 * 
	 * 		ID of the {@link Ward}
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set the ID for the {@link Ward}
	 * 
	 * @param inId
	 *            ID of the {@link Ward}
	 */
	public void setId(final Long inId) {
		this.id = inId;
	}

	/**
	 * Get the name of the {@link Ward}
	 * 
	 * @return Name of the {@link Ward}
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the {@link Ward}
	 * 
	 * @param inName
	 *            Name of the {@link Ward}
	 */
	public void setName(final String inName) {
		this.name = inName;
	}

	/**
	 * Get the {@link Institute} of the {@link Ward}
	 * 
	 * @return {@link Institute} of the {@link Ward}
	 */
	public Institute getInstitute() {
		return institute;
	}

	/**
	 * Set the the {@link Institute} of the {@link Ward}
	 * 
	 * @param inInstitute
	 *            {@link Institute} of the {@link Ward}
	 */
	public void setInstiute(final Institute inInstitute) {
		this.institute = inInstitute;
	}

}
