package lk.health.phd.cd.controllers;

import java.util.Calendar;
import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lk.health.phd.cd.dto.MohAreaVsDiseaseSummaryDto;
import lk.health.phd.cd.services.DashboardService;
import lk.health.phd.cd.services.Form544Service;
import lk.health.phd.util.Util;

/**
 * Controller class for dashboard.
 * 
 * @author admin
 *
 */

@Controller
public class DashboardController {

	Logger logger = LoggerFactory.getLogger(DashboardController.class);

	@Autowired
	DashboardService dashboardService;

	@Autowired
	Form544Service form544Service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getDiseaseComparisonGraph(Model model) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(Util.getSystemTime());

		List diseaseCountList = dashboardService.getDataForDiseaseComparisonGraph();
		List<MohAreaVsDiseaseSummaryDto> areaVsDiseaseSummaryDtos = form544Service.generateMohAreaVaDiseaseSummary(16l,
				cal.get(Calendar.YEAR), 1, cal.get(Calendar.YEAR), 12);

		model.addAttribute("mohAreaVsDiseaseSummaryList", areaVsDiseaseSummaryDtos);
		model.addAttribute("diseaseCounts", diseaseCountList);

		return "dashboard";
	}

}
