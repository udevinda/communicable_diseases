package lk.health.phd.cd.services;

import lk.health.phd.cd.models.Form411;
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

	/**
	 * Include Form 411 to related workflow.
	 * 
	 * @param form544
	 *            Related {@link Form544}
	 * @param form411
	 *            {@link Form411}
	 * @return ID of the workflow.
	 */
	public Long includeForm411(final Long inForm544Id, final Form411 form411);

}
