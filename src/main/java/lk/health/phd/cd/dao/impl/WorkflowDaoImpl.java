package lk.health.phd.cd.dao.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import lk.health.phd.cd.dao.WorkflowDao;
import lk.health.phd.cd.models.Workflow;

/**
 * 
 * @author admin
 *
 */
@Repository("workflowDao")
public class WorkflowDaoImpl extends UniversalDaoImpl<Workflow> implements WorkflowDao {

	/**
	 * ({@inheritDoc}
	 */
	public Workflow findWorkflowById(Long workflowId) {
		Session session = getCurrentSession();

		return (Workflow) session.createCriteria(Workflow.class).add(Restrictions.eq("id", workflowId));
	}

}
