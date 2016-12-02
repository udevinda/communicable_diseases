package lk.health.phd.cd.dao;

import lk.health.phd.cd.models.Workflow;

/**
 * DAO class for Workflow entity.
 * 
 * @author admin
 *
 */
public interface WorkflowDao extends UniversalDao<Workflow> {

	/**
	 * Retrieves the persisted workflow by its ID.
	 * 
	 * @param workflowId
	 *            ID of the record.
	 * @return {@link Workflow}
	 */
	public Workflow findWorkflowById(final Long workflowId);

	/**
	 * Retrieves the persisted workflow by its form 544 ID.
	 * 
	 * @param form544Id
	 *            ID of the form544
	 * @return {@link Workflow}
	 */
	public Workflow findWorkflowByForm544Id(final Long inForm544Id);
}
