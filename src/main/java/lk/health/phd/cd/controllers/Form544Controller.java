package lk.health.phd.cd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lk.health.phd.cd.models.Form544;
import lk.health.phd.cd.services.WorkflowService;

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
	WorkflowService workflowService;

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String saveForm544(@ModelAttribute Form544 form544, RedirectAttributes redirectAttributes) {

		try {
			workflowService.includeForm544(null, form544);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
