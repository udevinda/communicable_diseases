package lk.health.phd.cd.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "workflow")
public class Workflow implements Serializable {

	private static final long serialVersionUID = 1927557244278436381L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	// TODO convert type to enum
	@Column(name = "status", nullable = false)
	private String status;

	@OneToOne
	@JoinColumn(name = "form544_id")
	private Form544 form544;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Form544 getForm544() {
		return form544;
	}

	public void setForm544(Form544 form544) {
		this.form544 = form544;
	}

}
