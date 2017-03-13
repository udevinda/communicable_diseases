package lk.health.phd.cd.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lk.health.phd.cd.dao.DistrictDao;
import lk.health.phd.cd.dao.Form544Dao;
import lk.health.phd.cd.dto.MohAreaVsDiseaseSummaryDto;
import lk.health.phd.cd.dto.WardVsDiseaseSummaryDto;
import lk.health.phd.cd.services.Form544Service;

/**
 * 
 * @author admin
 *
 *         Controller for reports
 *
 */

@Controller
@RequestMapping("/reports")
public class ReportController {

	@Autowired
	private Form544Service form544Service;

	@Autowired
	private DistrictDao districtDao;

	@Autowired
	private Form544Dao form544Dao;

	Logger logger = LoggerFactory.getLogger(ReportController.class);

	/**
	 * Controller method to retrieve Disease Vs MOH area report for given
	 * period.
	 * 
	 * @param inDistrictId
	 *            ID of the district to consider.
	 * @param inFromYear
	 *            From year of the considering period
	 * @param inFromMonth
	 *            From month of the considering period
	 * @param inToYear
	 *            To year of the considering period
	 * @param inToMonth
	 *            To month of the considering period
	 * @param inMyRef
	 *            Reference number of the PHI
	 * @param inYourRef
	 *            Reference number of the receiver
	 * @param inReportDate
	 *            Date which the report is related to
	 * @param inResAddr
	 *            Receiver's address
	 * @param model
	 *            {@link Model}
	 * @return moh_area_vs_disease_count_report.html file
	 */
	@RequestMapping(value = "diseaseVsMohArea", method = RequestMethod.POST)
	public String getDiseaseVsMohAreaSummary(@RequestParam("district") final Long inDistrictId,
			@RequestParam("from_year") final int inFromYear, @RequestParam("from_month") final int inFromMonth,
			@RequestParam("to_year") final int inToYear, @RequestParam("to_month") final int inToMonth,
			@RequestParam("my_ref") final String inMyRef, @RequestParam("your_ref") final String inYourRef,
			@RequestParam("report_date") final String inReportDate, @RequestParam("res_addr") final String inResAddr,
			Model model) {

		List<MohAreaVsDiseaseSummaryDto> areaVsDiseaseSummaryDtos = form544Service
				.generateMohAreaVaDiseaseSummary(inDistrictId, inFromYear, inFromMonth, inToYear, inToMonth);

		model.addAttribute("mohAreaVsDiseaseSummaryList", areaVsDiseaseSummaryDtos);
		model.addAttribute("from_year", inFromYear);
		model.addAttribute("from_month", inFromMonth);
		model.addAttribute("to_year", inToYear);
		model.addAttribute("to_month", inToMonth);
		model.addAttribute("my_ref", inMyRef);
		model.addAttribute("your_ref", inYourRef);
		model.addAttribute("report_date", inReportDate);
		model.addAttribute("res_addr", inResAddr);
		model.addAttribute("district", districtDao.getDistrictById(inDistrictId).getDistrictName());

		return "moh_area_vs_disease_count_report";
	}

	/**
	 * Controller to process information for report based on count of reported
	 * communicable disease cases and ward of the mentioned institute.
	 * 
	 * @param inInstitute
	 *            Name of the institute
	 * @param inFromYear
	 *            From year to generate the report
	 * @param inFromMonth
	 *            From month to generate the report
	 * @param inToYear
	 *            To year to generate the report
	 * @param inToMonth
	 *            To month to generate the report
	 * @param inMyRef
	 *            Reference number of the PHI
	 * @param inYourRef
	 *            Reference number of the receiver
	 * @param inReportDate
	 *            Date which the report is related to
	 * @param inResAddr
	 *            Receiver's address
	 * @param model
	 * 
	 * @return ward_vs_disease_count_report.html file
	 */
	@RequestMapping(value = "diseaseVsWard", method = RequestMethod.POST)
	public String getDiseaseVsWardSummary(@RequestParam("institute") final String inInstitute,
			@RequestParam("from_year") final int inFromYear, @RequestParam("from_month") final int inFromMonth,
			@RequestParam("to_year") final int inToYear, @RequestParam("to_month") final int inToMonth,
			@RequestParam("my_ref") final String inMyRef, @RequestParam("your_ref") final String inYourRef,
			@RequestParam("report_date") final String inReportDate, @RequestParam("res_addr") final String inResAddr,
			Model model) {

		List<WardVsDiseaseSummaryDto> wardVsDiseaseSummaryDtos = form544Service
				.generateWardVsDiseaseSummary(inInstitute, inFromYear, inFromMonth, inToYear, inToMonth);

		model.addAttribute("wardVsDiseaseList", wardVsDiseaseSummaryDtos);
		model.addAttribute("from_year", inFromYear);
		model.addAttribute("from_month", inFromMonth);
		model.addAttribute("to_year", inToYear);
		model.addAttribute("to_month", inToMonth);
		model.addAttribute("my_ref", inMyRef);
		model.addAttribute("your_ref", inYourRef);
		model.addAttribute("report_date", inReportDate);
		model.addAttribute("res_addr", inResAddr);
		model.addAttribute("institute", inInstitute);

		return "ward_vs_disease_count_report";
	}

	/**
	 * Controller to load page disease-moh-area.html
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "communicable-disease-moh-area", method = RequestMethod.GET)
	public String getCommunicablDiseaseMohAreaReportGenPage(Model model) {

		model.addAttribute("districtList", districtDao.getAllDistrict());

		return "disease-moh-area";
	}

	/**
	 * Controller to load page disease-ward.html
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "communicable-disease-ward", method = RequestMethod.GET)
	public String getCommunicableDiseaseWardReportGenPage(Model model) {
		model.addAttribute("instituteList", form544Dao.getDistinctInstituteList());

		return "disease-ward";
	}

}
