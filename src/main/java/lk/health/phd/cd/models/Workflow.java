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

/**
 * Model for workflow.
 * 
 * @author admin
 *
 */
@Entity
@Table(name = "workflow")
public class Workflow implements Serializable {

	private static final long serialVersionUID = 1927557244278436381L;

	public enum WorkflowStatus {
		PROCESSING, HOLDING, COMPLETED;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "status", nullable = false)
	private WorkflowStatus status;

	@OneToOne
	@JoinColumn(name = "form544_id")
	private Form544 form544;

	/**
	 * Getter for workflow id.
	 * 
	 * @return Workflow Id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter for workflow ID.
	 * 
	 * @param inId
	 *            Workflow Id.
	 */
	public void setId(final Long inId) {
		this.id = inId;
	}

	/**
	 * Getter for workflow status.
	 * 
	 * @return WorkflowStatus.
	 */
	public WorkflowStatus getStatus() {
		return status;
	}

	/**
	 * Setter for workflow status.
	 * 
	 * @param inStatus
	 *            WorkflowStatus
	 */
	public void setStatus(final WorkflowStatus inStatus) {
		this.status = inStatus;
	}

	/**
	 * Getter for Form544 instace.
	 * 
	 * @return Form544
	 */
	public Form544 getForm544() {
		return form544;
	}

	/**
	 * Setter for Form544 instance.
	 * 
	 * @param inForm544
	 *            Form544 instance.
	 */
	public void setForm544(final Form544 inForm544) {
		this.form544 = inForm544;
	}

}
