package lk.health.phd.cd.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.health.phd.cd.dao.Form544Dao;
import lk.health.phd.cd.services.DashboardService;
import lk.health.phd.cd.services.Form544Service;

/**
 * 
 * @author admin
 *
 */

@Service("dashboardService")
@Transactional
public class DashboardServiceImpl implements DashboardService {

	Logger logger = LoggerFactory.getLogger(DashboardServiceImpl.class);

	@Autowired
	Form544Dao form544Dao;

	/**
	 * {@inheritDoc}
	 */
	public List getDataForDiseaseComparisonGraph() {
		List diseaseListWithCount = form544Dao.getDiseaseCountsForCurrentYear();

		return diseaseListWithCount;
	}

}
