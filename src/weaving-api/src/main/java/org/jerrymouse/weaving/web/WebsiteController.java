package org.jerrymouse.weaving.web;

import javax.annotation.Resource;

import org.jerrymouse.weaving.extracter.Extracter;
import org.jerrymouse.weaving.model.Website;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebsiteController {

	@Resource
	private Extracter extracter;

	@RequestMapping("/website/{q}")
	public String extracte(@PathVariable String q, Model model) {
		if (q == null || q.isEmpty())
			return "redirect /";
		Website website = extracter.extract(q);
		model.addAttribute("website", website);
		return "website";

	}
}