package lk.health.phd.cd.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.health.phd.cd.dao.WorkflowDao;
import lk.health.phd.cd.models.Form544;
import lk.health.phd.cd.models.Workflow;
import lk.health.phd.cd.models.Workflow.WorkflowStatus;
import lk.health.phd.cd.services.WorkflowService;

/**
 * Workflow service
 * 
 * @author admin
 *
 */
@Service("workflowService")
@Transactional
public class WorkflowServiceImpl implements WorkflowService {

	@Autowired
	WorkflowDao workflowDao;

	/**
	 * {@inheritDoc}
	 */
	public Long initiateWorkflow() {
		Workflow workflow = new Workflow();
		workflow.setStatus(WorkflowStatus.PROCESSING);
		return workflowDao.save(workflow);
	}

	/**
	 * {@inheritDoc}
	 */
	public Long includeForm544(final Long inWorkflowId, final Form544 inForm544) {
		Long workflowId = null;

		if (inWorkflowId == null) {
			Workflow workflow = new Workflow();
			workflow.setStatus(WorkflowStatus.PROCESSING);
			workflow.setForm544(inForm544);
			workflowId = workflowDao.save(workflow);
		} else {
			Workflow workflow = workflowDao.findWorkflowById(inWorkflowId);
			if (workflow != null) {
				workflow.setForm544(inForm544);
				workflowDao.update(workflow);
				workflowId = workflow.getId();
			}
		}

		return workflowId;
	}

}
