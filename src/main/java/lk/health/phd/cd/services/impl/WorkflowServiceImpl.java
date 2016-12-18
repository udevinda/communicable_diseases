package lk.health.phd.cd.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.health.phd.cd.controllers.Form544Controller;
import lk.health.phd.cd.dao.Form411Dao;
import lk.health.phd.cd.dao.Form544Dao;
import lk.health.phd.cd.dao.WorkflowDao;
import lk.health.phd.cd.models.Form411;
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
	private WorkflowDao workflowDao;

	@Autowired
	private Form544Dao form544Dao;

	@Autowired
	private Form411Dao form411Dao;

	Logger logger = LoggerFactory.getLogger(WorkflowServiceImpl.class);

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
			logger.debug("Workflow ID is null");

			Workflow workflow = new Workflow();
			workflow.setStatus(WorkflowStatus.PROCESSING);
			workflowId = workflowDao.save(workflow);
			logger.debug("Workflow ID " + workflowId + " has been persisted");

			Workflow persistedWorkflow = workflowDao.findWorkflowById(workflowId);
			persistedWorkflow.setForm544(inForm544);
			workflowDao.update(persistedWorkflow);

			inForm544.setWorkflow(persistedWorkflow);
			form544Dao.save(inForm544);
			logger.debug("Form544 object is persisted.");

		} else {
			logger.debug("Workflow ID is not null");

			Workflow workflow = workflowDao.findWorkflowById(inWorkflowId);
			if (workflow != null) {
				inForm544.setWorkflow(workflow);
				form544Dao.save(inForm544);
				logger.debug("Form544 object is persisted.");

				logger.debug("Workflow ID " + workflow.getId() + " has been retrived.");
				workflow.setForm544(inForm544);
				workflowDao.update(workflow);
				workflowId = workflow.getId();
				logger.debug("Workflow ID " + workflowId + " has been included Form544 and updated.");
			}
		}

		return workflowId;
	}

	/**
	 * {@inheritDoc}
	 */
	public Long includeForm411(final Long inForm544Id, final Form411 inForm411) {

		form411Dao.save(inForm411);
		logger.debug("Form411 object is persisted.");

		Form544 form544 = form544Dao.findForm544ById(inForm544Id);

		Workflow workflow = workflowDao.findWorkflowByForm544Id(form544.getId());
		workflow.setForm411(inForm411);
		workflowDao.update(workflow);
		logger.debug("Form411 is attached to workflow.");

		return workflow.getId();
	}

}
