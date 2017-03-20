package lk.health.phd.cd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lk.health.phd.cd.dao.DiseaseDao;
import lk.health.phd.cd.dao.Form544Dao;
import lk.health.phd.cd.dao.MohAreaDao;

/**
 * Controller class for graphs
 * 
 * @author admin
 *
 */

@Controller
@RequestMapping("/graphs")
public class GraphController {

	@Autowired
	private Form544Dao form544Dao;

	@Autowired
	private DiseaseDao diseaeDao;

	@Autowired
	private MohAreaDao mohAreaDao;

	@RequestMapping(value = "/monthlyDiseaseTrend", method = RequestMethod.GET)
	public @ResponseBody List generateMonthlyDiseaseTrend(@RequestParam("diseaseId") final Long inDiseaseId,
			@RequestParam("mohAreaId") final Long inMohAreaId, @RequestParam("year") final String inYear) {
		return form544Dao.getDiseaseCountForEachMonth(diseaeDao.findDiseaseById(inDiseaseId),
				mohAreaDao.findMohAreaById(inMohAreaId), inYear);
	}
}
