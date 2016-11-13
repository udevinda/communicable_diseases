package lk.health.phd.cd.services;

import lk.health.phd.cd.models.Form544;

public interface WorkflowService {

	/**
	 * Initiate a workflow.
	 * 
	 * @return Return the ID of the created workflow.
	 */
	public Long initiateWorkflow();

	/**
	 * Add Form544 instance to the specified workflow.
	 * 
	 * @param form544
	 *            {@link Form544}
	 * @param workflowId
	 *            ID for the workflow.
	 * @return ID of the created workflow.
	 */
	public Long includeForm544(final Long workflowId, final Form544 form544);

}
