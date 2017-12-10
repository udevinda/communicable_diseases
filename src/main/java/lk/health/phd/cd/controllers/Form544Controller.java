package lk.health.phd.cd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import lk.health.phd.cd.dao.DiseaseConfirmationTestDao;
import lk.health.phd.cd.dao.DiseaseDao;
import lk.health.phd.cd.dao.DistrictDao;
import lk.health.phd.cd.dao.Form544Dao;
import lk.health.phd.cd.dao.InstituteDao;
import lk.health.phd.cd.dao.MohAreaDao;
import lk.health.phd.cd.dao.WardDao;
import lk.health.phd.cd.dao.WorkflowDao;
import lk.health.phd.cd.dto.Form544FilterDto;
import lk.health.phd.cd.dto.MohAreaVsDiseaseSummaryDto;
import lk.health.phd.cd.dto.WardVsDiseaseSummaryDto;
import lk.health.phd.cd.models.Disease;
import lk.health.phd.cd.models.DiseaseConfirmationTest;
import lk.health.phd.cd.models.District;
import lk.health.phd.cd.models.Form544;
import lk.health.phd.cd.models.Institute;
import lk.health.phd.cd.models.MohArea;
import lk.health.phd.cd.models.Ward;
import lk.health.phd.cd.services.Form544Service;
import lk.health.phd.cd.services.WorkflowService;
import lk.health.phd.util.Util;

/**
 * 
 * @author admin
 * 
 *         Controller for Form544.
 *
 */

@Controller
@RequestMapping("/Form544")
public class Form544Controller {

	@Autowired
	private DiseaseDao diseaeDao;

	@Autowired
	private Form544Dao form544Dao;

	@Autowired
	private DiseaseConfirmationTestDao diseaseConfirmationTestDao;

	@Autowired
	private DistrictDao districtDao;

	@Autowired
	private InstituteDao instituteDao;

	@Autowired
	private WardDao wardDao;

	@Autowired
	private MohAreaDao mohAreaDao;

	@Autowired
	private Form544Service form544Service;

	Logger logger = LoggerFactory.getLogger(Form544Controller.class);

	/**
	 * 
	 * Controller for submit Form544.
	 * 
	 * @param inSerialNo
	 *            Serial number for the entry
	 * @param inInstituteId
	 *            where patient is admitted
	 * @param inDiseaseId
	 *            ID value of the specific disease
	 * @param inPatientName
	 *            patient name
	 * @param inDateOfOnset
	 *            Patient's onset date
	 * @param inPeaditiricPatientsGurdianName
	 *            Pediatric patients guardian name
	 * @param inDateOfAdmission
	 *            date of admission
	 * @param inBhtNo
	 *            Bead head ticket number
	 * @param inWardId
	 *            Ward ID
	 * @param inAge
	 *            Age of patient
	 * @param inSex
	 *            Sex of patient
	 * @param inPatientHomeAddress
	 *            Address of the patient
	 * @param inPatientsHomePhoneNo
	 *            patient phone number
	 * @param inNotifierName
	 *            notifier name
	 * @param inNotifierStatus
	 *            notifier status
	 * @param inMohArea
	 *            MOH area of the institute
	 * @param inNotifyByUnitDate
	 *            Date of notification from Ward/Unit
	 * @param inNotifyToMohDate
	 *            Date of notified to MOH
	 * @param inRemarks
	 *            Any remarks
	 * @param inLattitude
	 *            Latitude of the location
	 * @param inLongitude
	 *            Longitude of the location
	 * @return form544_view.html
	 */
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String saveForm544(@RequestParam("serialNo") final String inSerialNo,
			@RequestParam("institute") final Long inIntituteId, @RequestParam("disease") final Long inDiseaseId,
			@RequestParam("patientName") final String inPatientName,
			@RequestParam("dateOfOnset") final String inDateOfOnset,
			@RequestParam("peaditiricPatientsGurdianName") final String inPeaditiricPatientsGurdianName,
			@RequestParam("dateOfAdmission") final String inDateOfAdmission, @RequestParam("bhtNo") final Long inBhtNo,
			@RequestParam("ward") final Long inWardId, @RequestParam("age") final Integer inAge,
			@RequestParam("sex") final Form544.Sex inSex,
			@RequestParam("patientHomeAddress") final String inPatientHomeAddress,
			@RequestParam("patientsHomePhoneNo") final String inPatientsHomePhoneNo,
			@RequestParam("notifierName") final String inNotifierName,
			@RequestParam("notifierStatus") final String inNotifierStatus,
			@RequestParam("mohArea") final Long inMohArea,
			@RequestParam("notifyByUnitDate") final String inNotifyByUnitDate,
			@RequestParam("notifyToMohDate") final String inNotifyToMohDate,
			@RequestParam("remarks") final String inRemarks, @RequestParam("testName") final String inTestName,
			@RequestParam("smpleCollectionDate") final String inSampleCollectiondate,
			@RequestParam("labName") final String inLabName, @RequestParam("testResult") final String inTestResult,
			@RequestParam("lattitude") final String inLattitude, @RequestParam("longitude") final String inLongitude,
			Model model) {

		logger.info("Hit the /Form544/submit ");
		logger.info("Submitted user with NIC " + inSerialNo);

		JSONObject alertObj = new JSONObject();

		try {
			Form544 form544 = new Form544();
			form544.setAge(inAge);
			form544.setBhtNo(inBhtNo);
			form544.setDateOfAdmission(Util.parseDate(inDateOfAdmission, "yyyy-MM-dd"));
			form544.setDateOfOnset(Util.parseDate(inDateOfOnset, "yyyy-MM-dd"));
			form544.setDisease(getDisease(inDiseaseId));
			form544.setInstitute(instituteDao.getInstituteById(inIntituteId));
			form544.setSerialNo(inSerialNo);
			form544.setNotifierName(inNotifierName);
			form544.setNotifierStatus(inNotifierStatus);
			form544.setPatientHomeAddress(inPatientHomeAddress);
			form544.setPatientName(inPatientName);
			form544.setPatientsHomePhoneNo(inPatientsHomePhoneNo);
			form544.setPeaditiricPatientsGurdianName(inPeaditiricPatientsGurdianName);
			form544.setSex(inSex);
			form544.setSystemNotifiedDate(Util.parseDate(inNotifyToMohDate, "yyyy-MM-dd"));
			form544.setWard(wardDao.getWardById(inWardId));
			form544.setMohArea(getMohArea(inMohArea));
			form544.setNotificationByUnitDate(Util.parseDate(inNotifyByUnitDate, "yyyy-MM-dd"));
			form544.setNotificationToMohDate(Util.parseDate(inNotifyToMohDate, "yyyy-MM-dd"));
			form544.setRemarks(inRemarks);
			form544.setStatus(Form544.Status.ACTIVE);
			if (isMapLocationAvailable(inLattitude, inLongitude)) {
				form544.setLattitude(Double.parseDouble(inLattitude));
				form544.setLongitude(Double.parseDouble(inLongitude));
			}
			DiseaseConfirmationTest diseaseConfirmationTest = new DiseaseConfirmationTest();
			diseaseConfirmationTest.setNameOfLab(inLabName);
			diseaseConfirmationTest.setResult(inTestResult);
			diseaseConfirmationTest.setSampleCollectionDate(Util.parseDate(inSampleCollectiondate, "yyyy-MM-dd"));
			diseaseConfirmationTest.setTestName(inTestName);

			// TODO Need to do backend validation

			Form544 submittedForm544 = form544Service.createForm544(form544, diseaseConfirmationTest);
			DiseaseConfirmationTest submittedDiseaseConfirmationTest = diseaseConfirmationTestDao
					.getDiseaseConfirmationTestByForm544Id(submittedForm544.getId());

			model.addAttribute("form544Object", submittedForm544);
			model.addAttribute("diseaseConfirmationTestObject", submittedDiseaseConfirmationTest);

			alertObj.put("type", "success");
			alertObj.put("msg", "Successfully created Form 544 with Serial Number " + submittedForm544.getSerialNo());

		} catch (Exception e) {
			logger.error("Error occured " + e);

			alertObj.put("type", "fail");
			alertObj.put("msg", "Form 544 generation failed. Due to " + e.getMessage());
		}

		model.addAttribute("alert", alertObj);

		return "form544_view";
	}

	/**
	 * View the saved Form544 details by given ID.
	 * 
	 * @param inform544Id
	 *            Form544 ID
	 * @return
	 */
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewForm544(@RequestParam("form544Id") final Long inform544Id, Model model) {

		logger.info("Hit the /Form544/view ");
		logger.info("Request view for Form544 ID " + inform544Id);

		Form544 form544 = form544Dao.findForm544ById(inform544Id);
		DiseaseConfirmationTest diseaseConfirmationTest = diseaseConfirmationTestDao
				.getDiseaseConfirmationTestByForm544Id(inform544Id);
		logger.info("Retrieved details for patient " + form544.getPatientName());

		model.addAttribute("form544Object", form544);
		model.addAttribute("diseaseConfirmationTestObject", diseaseConfirmationTest);

		return "form544_view";
	}

	/**
	 * Update Form544 details.
	 * 
	 * @param inForm544Id
	 *            Existing form 544 ID
	 * @param inSerialNo
	 *            Serial number for the entry.
	 * @param inInstituteId
	 *            Institute Id where patient is admitted.
	 * @param inDiseaseId
	 *            {@link Disease} ID related to the particular patient.
	 * @param inPatientName
	 *            Patient's name
	 * @param inDateOfOnset
	 *            Patient date of onset
	 * @param inPeaditiricPatientsGurdianName
	 *            Pediatric patients guardian name
	 * @param inDateOfAdmission
	 *            Date of admission
	 * @param inBhtNo
	 *            Bead head ticket number
	 * @param inWardId
	 *            Ward ID where patient is admitted.
	 * @param inAge
	 *            Age of the patient
	 * @param inSex
	 *            {@link Sex} of the patient
	 * @param inPatientHomeAddress
	 *            Patient's home address
	 * @param inPatientsHomePhoneNo
	 *            Patient's home phone number
	 * @param inNotifierName
	 *            Notifier name
	 * @param inNotifierStatus
	 *            Notifier status
	 * @param inMohArea
	 *            MOH area of the institute
	 * @param inLattitude
	 *            Latitude of the location
	 * @param inLongitude
	 *            Longitude of the location
	 * @return form544_create.html
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateForm544(@RequestParam("form544Id") final Long inForm544Id,
			@RequestParam("serialNo") final String inSerialNo, @RequestParam("institute") final Long inIntituteId,
			@RequestParam("disease") final Long inDiseaseId, @RequestParam("patientName") final String inPatientName,
			@RequestParam("dateOfOnset") final String inDateOfOnset,
			@RequestParam("peaditiricPatientsGurdianName") final String inPeaditiricPatientsGurdianName,
			@RequestParam("dateOfAdmission") final String inDateOfAdmission, @RequestParam("bhtNo") final Long inBhtNo,
			@RequestParam("ward") final Long inWardId, @RequestParam("age") final Integer inAge,
			@RequestParam("sex") final Form544.Sex inSex,
			@RequestParam("patientHomeAddress") final String inPatientHomeAddress,
			@RequestParam("patientsHomePhoneNo") final String inPatientsHomePhoneNo,
			@RequestParam("notifierName") final String inNotifierName,
			@RequestParam("notifierStatus") final String inNotifierStatus, @RequestParam("mohArea") Long inMohArea,
			@RequestParam("notifyByUnitDate") final String inNotifyByUnitDate,
			@RequestParam("notifyToMohDate") final String inNotifyToMohDate,
			@RequestParam("remarks") final String inRemarks, @RequestParam("testName") final String inTestName,
			@RequestParam("smpleCollectionDate") final String inSampleCollectiondate,
			@RequestParam("labName") final String inLabName, @RequestParam("testResult") final String inTestResult,
			@RequestParam("lattitude") final String inLattitude, @RequestParam("longitude") final String inLongitude,
			Model model) {

		logger.info("Hit the /Form544/update ");
		logger.info("Request update for Form544 ID " + inForm544Id);

		JSONObject alertObj = new JSONObject();

		try {
			Form544 form544 = new Form544();
			form544.setAge(inAge);
			form544.setBhtNo(inBhtNo);
			form544.setDateOfAdmission(Util.parseDate(inDateOfAdmission, "yyyy-MM-dd"));
			form544.setDateOfOnset(Util.parseDate(inDateOfOnset, "yyyy-MM-dd"));
			form544.setDisease(getDisease(inDiseaseId));
			form544.setInstitute(instituteDao.getInstituteById(inIntituteId));
			form544.setSerialNo(inSerialNo);
			form544.setNotifierName(inNotifierName);
			form544.setNotifierStatus(inNotifierStatus);
			form544.setPatientHomeAddress(inPatientHomeAddress);
			form544.setPatientName(inPatientName);
			form544.setPatientsHomePhoneNo(inPatientsHomePhoneNo);
			form544.setPeaditiricPatientsGurdianName(inPeaditiricPatientsGurdianName);
			form544.setSex(inSex);
			form544.setSystemNotifiedDate(Util.parseDate(inNotifyToMohDate, "yyyy-MM-dd"));
			form544.setWard(wardDao.getWardById(inWardId));
			form544.setMohArea(getMohArea(inMohArea));
			form544.setNotificationByUnitDate(Util.parseDate(inNotifyByUnitDate, "yyyy-MM-dd"));
			form544.setNotificationToMohDate(Util.parseDate(inNotifyToMohDate, "yyyy-MM-dd"));
			form544.setRemarks(inRemarks);
			if (isMapLocationAvailable(inLattitude, inLongitude)) {
				form544.setLattitude(Double.parseDouble(inLattitude));
				form544.setLongitude(Double.parseDouble(inLongitude));
			}

			DiseaseConfirmationTest diseaseConfirmationTest = new DiseaseConfirmationTest();
			diseaseConfirmationTest.setNameOfLab(inLabName);
			diseaseConfirmationTest.setResult(inTestResult);
			diseaseConfirmationTest.setSampleCollectionDate(Util.parseDate(inSampleCollectiondate, "yyyy-MM-dd"));
			diseaseConfirmationTest.setTestName(inTestName);

			Form544 updatedForm544 = form544Service.updateForm544ById(inForm544Id, form544, diseaseConfirmationTest);
			DiseaseConfirmationTest updatedDiseaseConfirmationTest = diseaseConfirmationTestDao
					.getDiseaseConfirmationTestByForm544Id(updatedForm544.getId());

			model.addAttribute("form544Object", updatedForm544);
			model.addAttribute("diseaseConfirmationTestObj", updatedDiseaseConfirmationTest);

			alertObj.put("type", "success");
			alertObj.put("msg", "Successfully updated Form 544 with Serial Number " + updatedForm544.getSerialNo());

			logger.info("Form544 updated system time " + updatedForm544.getSystemNotifiedDate());
		} catch (Exception e) {

			alertObj.put("type", "fail");
			alertObj.put("msg", "Form 544 generation failed. Due to " + e.getMessage());

			logger.info("An error occured when updating Form544");
			logger.error("Error occured ", e);
		}

		model.addAttribute("alert", alertObj);

		return "form544_view";
	}

	/**
	 * Filter Form544 instances and returned based on the given values for the
	 * criteria fields.
	 * 
	 * @param inPatientNic
	 *            National ID of the patients.
	 * @param inInstituteId
	 *            Institute ID where the patient admitted.
	 * @param inDiseaseId
	 *            Disease of the patient.
	 * @param inPatientName
	 *            Patient's name.
	 * @param inBhtNo
	 *            Patient's bead head ticket number.
	 * @param inWardId
	 *            Ward ID where patient admitted.
	 * @param inSex
	 *            Sex of the patient.
	 * @param inNotifierName
	 *            Who notified the case.
	 * @param inDateOfOnsetFrom
	 *            From onset date for a range.
	 * @param inDateOfOnsetTo
	 *            To onset date for a range.
	 * @param inDateOfAdmissionFrom
	 *            From admission date for a range.
	 * @param inDateOfAdmissionTo
	 *            To admission date for a range.
	 * @param inAgeFrom
	 *            From age for a range.
	 * @param inAgeTo
	 *            To age for a range.
	 * @param inMohArea
	 *            MOH area of the institute
	 * @param inOffset
	 *            Offset for pagination.
	 * @param inLimit
	 *            Limit for pagination.
	 * @return Json object included total row count, for 544 list
	 */
	@RequestMapping(value = "/filterBy", method = RequestMethod.POST)
	public @ResponseBody JSONObject searchForm544ByCriteria(@RequestParam("serialNo") final String inSerialNo,
			@RequestParam("institute") final Long inIntituteId, @RequestParam("disease") final Long inDiseaseId,
			@RequestParam("patientName") final String inPatientName, @RequestParam("bhtNo") final Long inBhtNo,
			@RequestParam("ward") final Long inWardId, @RequestParam("sex") final Form544.Sex inSex,
			@RequestParam("notifierName") final String inNotifierName,
			@RequestParam("dateOfOnsetFrom") final String inDateOfOnsetFrom,
			@RequestParam("dateOfOnsetTo") final String inDateOfOnsetTo,
			@RequestParam("dateOfAdmissionFrom") final String inDateOfAdmissionFrom,
			@RequestParam("dateOfAdmissionTo") final String inDateOfAdmissionTo,
			@RequestParam("ageFrom") final Integer inAgeFrom, @RequestParam("ageTo") final Integer inAgeTo,
			@RequestParam("mohArea") final Long inMohArea,
			@RequestParam("notifyByUnitFromDate") final String inNotifyByUnitFromDate,
			@RequestParam("notifyByUnitToDate") final String inNotifyByUnitToDate,
			@RequestParam("notifyToMohFromDate") final String inNotifyToMohFromDate,
			@RequestParam("notifyToMohToDate") final String inNotifyToMohToDate,
			@RequestParam("offset") final Integer inOffset, @RequestParam("limit") final Integer inLimit) {

		logger.info("Hit the /Form544/filterBy ");

		try {
			Form544FilterDto form544FilterDto = new Form544FilterDto();
			form544FilterDto.setBhtNo(inBhtNo);
			form544FilterDto.setDisease(getDisease(inDiseaseId));
			form544FilterDto.setInstitute(instituteDao.getInstituteById(inIntituteId));
			form544FilterDto.setPatientName(inPatientName);
			form544FilterDto.setSerialNo(inSerialNo);
			form544FilterDto.setSex(inSex);
			form544FilterDto.setWard(wardDao.getWardById(inWardId));
			form544FilterDto.setNotifierName(inNotifierName);
			form544FilterDto.setAgeFrom(inAgeFrom);
			form544FilterDto.setAgeTo(inAgeTo);
			form544FilterDto.setDateOfAdmissionFrom(Util.parseDate(inDateOfAdmissionFrom, "yyyy-MM-dd"));
			form544FilterDto.setDateOfAdmissionTo(Util.parseDate(inDateOfAdmissionTo, "yyyy-MM-dd"));
			form544FilterDto.setDateOfOnsetFrom(Util.parseDate(inDateOfOnsetFrom, "yyyy-MM-dd"));
			form544FilterDto.setDateOfOnsetTo(Util.parseDate(inDateOfOnsetTo, "yyyy-MM-dd"));
			form544FilterDto.setFromDateOfNotifyFromUnit(Util.parseDate(inNotifyByUnitFromDate, "yyyy-MM-dd"));
			form544FilterDto.setToDateOfNotifyFromUnit(Util.parseDate(inNotifyByUnitToDate, "yyyy-MM-dd"));
			form544FilterDto.setFromDateOfNotifyToMoh(Util.parseDate(inNotifyToMohFromDate, "yyyy-MM-dd"));
			form544FilterDto.setToDateOfNotifyToMoh(Util.parseDate(inNotifyToMohToDate, "yyyy-MM-dd"));
			form544FilterDto.setMohArea(getMohArea(inMohArea));

			List<Form544> form544List = form544Dao.searchForm544BySearchFields(form544FilterDto, inOffset, inLimit);
			Long totalRowCount = form544Dao.searchCountForm544BySearchFields(form544FilterDto);

			JSONObject obj = new JSONObject();
			obj.put("form544List", form544List);
			obj.put("totalRowCount", totalRowCount);

			logger.info("Returned result set size : " + form544List.size());

			return obj;
		} catch (Exception e) {
			// logger.error("Error occured ", e);
			e.printStackTrace();

			return null;
		}

	}

	/**
	 * Controller for Form 544 create page load.
	 * 
	 * @param model
	 *            Model to transfer data.
	 * @return form544_create.html
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String form544Create(Model model) {

		logger.info("Hit the /Form544/create ");

		List<Form544.Sex> sexList = new ArrayList<Form544.Sex>();
		sexList.add(Form544.Sex.MALE);
		sexList.add(Form544.Sex.FEMALE);
		sexList.add(Form544.Sex.OTHER);

		model.addAttribute("sexList", sexList);
		model.addAttribute("diseaseList", diseaeDao.getAllDiseases());
		model.addAttribute("districtList", districtDao.getAllDistrict());
		model.addAttribute("serialNo", form544Service.generateForm544SerialNo());

		return "form544_create";
	}

	/**
	 * Controller for Form 544 search page load.
	 * 
	 * @param model
	 *            Model to transfer data.
	 * @return form544_search.html
	 */
	@RequestMapping(value = "/filter_view", method = RequestMethod.GET)
	public String form544Search(Model model) {
		logger.info("Hit the /Form544/filter_view ");

		List<Form544.Sex> sexList = new ArrayList<Form544.Sex>();
		sexList.add(Form544.Sex.MALE);
		sexList.add(Form544.Sex.FEMALE);
		sexList.add(Form544.Sex.OTHER);

		model.addAttribute("sexList", sexList);
		model.addAttribute("diseaseList", diseaeDao.getAllDiseases());
		model.addAttribute("districtList", districtDao.getAllDistrict());

		return "form544_search";
	}

	/**
	 * Controller to load update_view page.
	 * 
	 * @param inForm544Id
	 *            Id of the Form 544
	 * @param model
	 *            Model to transfer data to the page.
	 * @return form544_update.html
	 */
	@RequestMapping(value = "/update_view", method = RequestMethod.GET)
	public String form544UpdateView(@RequestParam("id") final Long inForm544Id, Model model) {

		logger.info("Hit the /Form544/update_view ");
		logger.info("Rendering view for Form 544 ID : " + inForm544Id);

		List<Form544.Sex> sexList = new ArrayList<Form544.Sex>();
		sexList.add(Form544.Sex.MALE);
		sexList.add(Form544.Sex.FEMALE);
		sexList.add(Form544.Sex.OTHER);

		DiseaseConfirmationTest updatedDiseaseConfirmationTest = diseaseConfirmationTestDao
				.getDiseaseConfirmationTestByForm544Id(inForm544Id);

		model.addAttribute("sexList", sexList);
		model.addAttribute("diseaseList", diseaeDao.getAllDiseases());
		model.addAttribute("districtList", districtDao.getAllDistrict());
		model.addAttribute("form544Object", form544Dao.findForm544ById(inForm544Id));
		model.addAttribute("diseaseConfirmationTestObj", updatedDiseaseConfirmationTest);

		return "form544_update";
	}

	/**
	 * Controller to set {@link Form544.status} as
	 * {@link Form544.Status.DELETED}
	 * 
	 * @param inForm544Id
	 *            ID of the {@link Form544}
	 * @return Redirect to the Form544 filter_view
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public RedirectView deleteForm544(@RequestParam("id") final Long inForm544Id,
			RedirectAttributes redirectAttributes) {

		logger.info("Hit the /Form544/delete ");
		logger.info("Change Status Deleted of Form 544 ID : " + inForm544Id);

		JSONObject alertObj = new JSONObject();

		try {
			form544Service.setStatusAsDeleted(inForm544Id);

			alertObj.put("type", "success");
			alertObj.put("msg", "Successfully deleted Form 544 with ID Number " + inForm544Id);

		} catch (Exception e) {
			logger.error("Error occured " + e);

			alertObj.put("type", "fail");
			alertObj.put("msg", "Form 544 deletion failed. Due to " + e.getMessage());
		}

		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl("filter_view");
		redirectAttributes.addFlashAttribute("alert", alertObj);

		return redirectView;
	}

	/**
	 * Controller method to retrieve moh area list by district ID.
	 * 
	 * @param districtId
	 *            ID of the {@link District}
	 * @return List of {@link MohArea}
	 */
	@RequestMapping(value = "moh_area", method = RequestMethod.GET)
	@ResponseBody
	public List<MohArea> getMohAreaByDistrictId(@RequestParam("district_id") final Long districtId) {
		return mohAreaDao.getMohAreaByDistrictId(districtId);
	}

	/**
	 * Controller method to get list of available {@link Institute} by
	 * {@link District}
	 * 
	 * @param inDistrictId
	 *            ID of a {@link District}
	 * @return List of {@link Institute}
	 */
	@RequestMapping(value = "institute", method = RequestMethod.GET)
	@ResponseBody
	public List<Institute> getInstituteByDistrictId(@RequestParam("district_id") final Long inDistrictId) {
		return instituteDao.getInstitutesByDistrictId(inDistrictId);
	}

	/**
	 * Controller method to get list of available {@link Ward} by
	 * {@link Institute}
	 * 
	 * @param inInstituteId
	 *            ID of a {@link Institute}
	 * @return List of {@link Ward}
	 */
	@RequestMapping(value = "ward", method = RequestMethod.GET)
	@ResponseBody
	public List<Ward> getWardByInstituteId(@RequestParam("institute_id") final Long inInstituteId) {
		return wardDao.getWardsByInstituteId(inInstituteId);
	}

	/**
	 * Return the disease object by ID.
	 * 
	 * @param inDiseaseId
	 *            ID of the considering disease.
	 * @return {@link Disease}
	 */
	private Disease getDisease(final Long inDiseaseId) {
		Disease disease = diseaeDao.findDiseaseById(inDiseaseId);

		return disease;
	}

	/**
	 * Returns the {@link MohArea}
	 * 
	 * @param mohAreaId
	 *            ID of the MOH Area
	 * @return {@link MohArea}
	 */
	private MohArea getMohArea(final Long mohAreaId) {
		MohArea mohArea = mohAreaDao.findMohAreaById(mohAreaId);

		return mohArea;
	}

	/**
	 * Decides weather the map location is given by the user.
	 * 
	 * @param inLattitude
	 *            Latitude of the location
	 * @param inLongitude
	 *            Longitude of the location
	 * @return true - location is available | false - location is not available
	 */
	private boolean isMapLocationAvailable(final String inLattitude, final String inLongitude) {
		if (!inLattitude.isEmpty() || inLattitude != "" || !inLongitude.isEmpty() || inLongitude != "") {
			return true;
		} else {
			return false;
		}

	}

}
