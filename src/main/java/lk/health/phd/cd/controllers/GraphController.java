package lk.health.phd.cd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lk.health.phd.cd.dao.DiseaseDao;
import lk.health.phd.cd.dao.Form544Dao;
import lk.health.phd.cd.dao.MohAreaDao;
import lk.health.phd.cd.services.Form544Service;

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
	private Form544Service form544Service;

	@Autowired
	private DiseaseDao diseaeDao;

	@RequestMapping(value = "/monthlyDiseaseTrend", method = RequestMethod.GET)
	public String generateMonthlyDiseaseTrend(@RequestParam("diseaseId") final Long inDiseaseId,
			@RequestParam("districtId") final Long inDistrictId, @RequestParam("year") final String inYear,
			Model model) {

		List diseaseMonthDataList = form544Service
				.generateMonthlyDiseaseTrendDataSet(diseaeDao.findDiseaseById(inDiseaseId), inDistrictId, inYear);

		model.addAttribute("diseaseMonthTrendDataSet", diseaseMonthDataList);

		return "trend_of_diseases";
	}
}
