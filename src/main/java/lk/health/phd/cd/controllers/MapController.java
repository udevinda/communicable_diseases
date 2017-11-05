package lk.health.phd.cd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lk.health.phd.cd.dao.DiseaseDao;
import lk.health.phd.cd.dao.DistrictDao;
import lk.health.phd.cd.dao.Form411Dao;
import lk.health.phd.cd.dao.WorkflowDao;
import lk.health.phd.cd.dto.Form411FilterDto;
import lk.health.phd.cd.models.Disease;
import lk.health.phd.cd.models.Form411;
import lk.health.phd.cd.models.Workflow;
import lk.health.phd.util.Util;

/**
 * Conroller for Google Maps
 * 
 * @author admin
 *
 */

@Controller
@RequestMapping("/Maps")
public class MapController {

	Logger logger = LoggerFactory.getLogger(MapController.class);

	@Autowired
	private DiseaseDao diseaseDao;
	
	@Autowired
	private DistrictDao districtDao;

	@Autowired
	private Form411Dao form411Dao;

	/**
	 * Controller to receive data for communicable disease detail map.
	 * 
	 * @param inAgeFrom
	 *            Patient Age (From parameter)
	 * @param inAgeTo
	 *            Patient Age (To parameter)
	 * @param inSex
	 *            {@link Form411.Sex}}
	 * @param inEthnicGroup
	 *            {@link Form411.EthnicGroup}
	 * @param inConfirmrdDiseaseId
	 *            Confirmed disease Id.
	 * @param inHospital
	 *            Hospitalized hospital name.
	 * @param inOutcome
	 *            {@link Form411.Outcome}
	 * @param inPhiRange
	 *            Related PHI range
	 * @param inMohRange
	 *            Related MOH range
	 * @return JSON array including form 411 ID, form 544 ID,disease, patient's
	 *         address, longitude & latitude of patient's location
	 */
	@RequestMapping(value = "/distributionMap", method = RequestMethod.POST)
	public String getDistributionMap(@RequestParam("ageFrom") final Integer inAgeFrom,
			@RequestParam("ageTo") final Integer inAgeTo, @RequestParam("sex") final Form411.Sex inSex,
			@RequestParam("ethnicGroup") final Form411.EthnicGroup inEthnicGroup,
			@RequestParam("confirmedDiseaseId") final Long inConfirmrdDiseaseId,
			@RequestParam("hospital") final String inHospital, @RequestParam("outcome") final Form411.Outcome inOutcome,
			@RequestParam("phiRange") final String inPhiRange, @RequestParam("mohRange") final String inMohRange,
			@RequestParam("confirmedDateFrom") final String inConfirmedDateFrom,
			@RequestParam("confirmedDateTo") final String inConfirmedDateTo, Model model) {

		try {
			Form411FilterDto form411FilterDto = new Form411FilterDto();

			form411FilterDto.setAgeFrom(inAgeFrom);
			form411FilterDto.setAgeTo(inAgeTo);
			form411FilterDto.setConfirmedDisease(getDisease(inConfirmrdDiseaseId));
			form411FilterDto.setEthnicGroup(inEthnicGroup);
			form411FilterDto.setHospital(inHospital);
			form411FilterDto.setMohRange(inMohRange);
			form411FilterDto.setOutcome(inOutcome);
			form411FilterDto.setPhiRange(inPhiRange);
			form411FilterDto.setSex(inSex);
			form411FilterDto.setConfirmedDateFrom(Util.parseDate(inConfirmedDateFrom, "yyyy-MM-dd"));
			form411FilterDto.setConfirmedDateTo(Util.parseDate(inConfirmedDateTo, "yyyy-MM-dd"));

			List<Form411> form411List = form411Dao.receiveDetailsForDistribtionMap(form411FilterDto);

			model.addAttribute("distMapDet", form411List);

			return "disease_spread_map";
		} catch (Exception e) {
			logger.error("Error occured ", e);

			return null;
		}
	}

	@RequestMapping(value = "/map_filter", method = RequestMethod.GET)
	public String viewMapFilter(Model model) {
		logger.info("Hit the /Maps/map_filter ");

		List<Form411.Sex> sexList = new ArrayList<Form411.Sex>();
		sexList.add(Form411.Sex.MALE);
		sexList.add(Form411.Sex.FEMALE);
		sexList.add(Form411.Sex.OTHER);

		List<Form411.EthnicGroup> ethnicGroupList = new ArrayList<Form411.EthnicGroup>();
		ethnicGroupList.add(Form411.EthnicGroup.SINHALESE);
		ethnicGroupList.add(Form411.EthnicGroup.TAMIL);
		ethnicGroupList.add(Form411.EthnicGroup.MUSLIMS);
		ethnicGroupList.add(Form411.EthnicGroup.BURGHER);
		ethnicGroupList.add(Form411.EthnicGroup.OTHERS);

		List<Form411.Outcome> outcomeList = new ArrayList<Form411.Outcome>();
		outcomeList.add(Form411.Outcome.RECOVERED);
		outcomeList.add(Form411.Outcome.DIED);

		model.addAttribute("sexList", sexList);
		model.addAttribute("ethnicGroupList", ethnicGroupList);
		model.addAttribute("outcomeList", outcomeList);
		model.addAttribute("diseaseList", diseaseDao.getAllDiseases());

		return "map_filter";
	}
	
	@RequestMapping(value="dis_wise_dist_map_filter", method = RequestMethod.GET)
	public String viewDiseaseWiseMapFilter(Model model){
		logger.info("Hit the /Maps/dis_wise_dist_map_filter");
		
		model.addAttribute("diseaseList", diseaseDao.getAllDiseases());
		model.addAttribute("districtList", districtDao.getAllDistrict());
		
		return "disease_wise_distribution_map";
	}

	/**
	 * Return the disease object by ID.
	 * 
	 * @param inDiseaseId
	 *            ID of the considering disease.
	 * @return {@link Disease}
	 */
	private Disease getDisease(final Long inDiseaseId) {
		Disease disease = diseaseDao.findDiseaseById(inDiseaseId);

		return disease;
	}
}
