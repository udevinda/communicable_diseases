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
import lk.health.phd.cd.dao.DistrictDao;
import lk.health.phd.cd.dao.Form544Dao;
import lk.health.phd.cd.dao.MohAreaDao;
import lk.health.phd.cd.models.Disease;
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

	@Autowired
	private DistrictDao districtDao;

	@RequestMapping(value = "/monthlyDiseaseTrendPanel", method = RequestMethod.GET)
	public String getMonthlyDiseaseGraphPanel(Model model) {

		model.addAttribute("districtList", districtDao.getAllDistrict());
		model.addAttribute("diseaseList", diseaeDao.getAllDiseases());

		return "trend_of_diseases";
	}

	@RequestMapping(value = "/monthlyDiseaseTrend", method = RequestMethod.GET)
	public String generateMonthlyDiseaseTrend(@RequestParam("disease") final Long inDiseaseId,
			@RequestParam("district") final Long inDistrictId, @RequestParam("year") final String inYear, Model model) {

		Disease disease = diseaeDao.findDiseaseById(inDiseaseId);
		List diseaseMonthDataList = form544Service.generateMonthlyDiseaseTrendDataSet(disease, inDistrictId, inYear);

		model.addAttribute("diseaseMonthTrendDataSet", diseaseMonthDataList);
		model.addAttribute("diseaseName", disease.getDiseaseName());
		model.addAttribute("year", inYear);
		model.addAttribute("district", districtDao.getDistrictById(inDistrictId).getDistrictName());

		return "trend_of_diseases_graph";
	}

	@RequestMapping(value = "/diseaseAgeWisePanel", method = RequestMethod.GET)
	public String getDiseaseAgeWiseGraphPanel(Model model) {

		model.addAttribute("districtList", districtDao.getAllDistrict());
		model.addAttribute("diseaseList", diseaeDao.getAllDiseases());

		return "disease_age_wise";
	}

	@RequestMapping(value = "/diseaseAgeWise", method = RequestMethod.GET)
	public String generateDiseaseAgeWiseDataGroups(@RequestParam("disease") final Long inDiseaseId,
			@RequestParam("district") final Long inDistrictId, @RequestParam("year") final String inYear,
			@RequestParam("month") final String inMonth, Model model) {

		Disease disease = diseaeDao.findDiseaseById(inDiseaseId);
		List ageList = form544Service.generateAgeListForAgeWiseGraph(disease, inDistrictId, inYear, inMonth);

		model.addAttribute("ageList", ageList);
		model.addAttribute("diseaseName", disease.getDiseaseName());
		model.addAttribute("year", inYear);
		model.addAttribute("month", inMonth);
		model.addAttribute("district", districtDao.getDistrictById(inDistrictId).getDistrictName());

		return "age_wise_graph";
	}
}
