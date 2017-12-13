package lk.health.phd.cd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UiController {

	@RequestMapping(value = "/page/footer", method = RequestMethod.GET)
	public String getFooter() {
		return "/common/footer";
	}

	@RequestMapping(value = "/page/banner", method = RequestMethod.GET)
	public String getBanner() {
		return "/common/banner";
	}

	@RequestMapping(value = "/page/navigation", method = RequestMethod.GET)
	public String getNavigation() {
		return "/common/navigation";
	}
}
