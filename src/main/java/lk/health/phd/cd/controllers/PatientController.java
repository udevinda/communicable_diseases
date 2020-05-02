package lk.health.phd.cd.controllers;

import lk.health.phd.cd.models.DiseaseConfirmationTest;
import lk.health.phd.cd.models.Enums;
import lk.health.phd.cd.models.Form544;
import lk.health.phd.cd.models.Patient;
import lk.health.phd.cd.services.PatientService;
import lk.health.phd.util.Util;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/Patient")
public class PatientController {

    Logger logger = LoggerFactory.getLogger(Patient.class);

    @Autowired
    PatientService patientService;

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String savePatient(@RequestParam("nic") final String nic,
                              @RequestParam("name") final String name,
                              @RequestParam("address") final String address,
                              @RequestParam("contactNo") final String contactNo,
                              @RequestParam("gender") final Enums.Sex sex,
                              @RequestParam("status") final Enums.Status status,
                              Model model) {

        logger.info("Hit the /Patient/submit ");
        logger.info("Submitted patient with NIC " + nic);

        JSONObject alertObj = new JSONObject();

        try {
            Patient patient = new Patient();
            patient.setNic(nic);
            patient.setName(name);
            patient.setAddress(address);
            patient.setContactNo(contactNo);
            patient.setSex(sex);
            patient.setStatus(status);
            final Patient persistedPatient = patientService.addPatient(patient);

            model.addAttribute("patientObj", persistedPatient);

            alertObj.put("type", "success");
            alertObj.put("msg", "Successfully patient with NIC Number " + patient.getNic());

        } catch (Exception e) {
            logger.error("Error occured " + e);

            alertObj.put("type", "fail");
            alertObj.put("msg", "Patient creation failed. Due to " + e.getMessage());
        }

        model.addAttribute("alert", alertObj);

        return "form544_view";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String patientCreate(Model model) {

        logger.info("Hit the /Patient/create ");

        model.addAttribute("sexList", Enums.Sex.values());
        model.addAttribute("statusList", Enums.Status.values());

        return "patient_create";
    }

}
