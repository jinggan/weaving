package org.jerrymouse.weaving.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.digger.Digger;
import org.jerrymouse.weaving.model.analysis.AnalysisePerson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DigController {
	@Resource
	private Digger digger;

	@RequestMapping("/api/dig")
	public ModelAndView dig(@RequestParam String q,
			@RequestParam(required = false) String pretty) {
		List<AnalysisePerson> persons = digger.dig(q);
		boolean p = pretty == null ? false : true;
		JsonView view = new JsonView();
		view.setPretty(p);
		ModelAndView modelAndView = new ModelAndView(view);
		if (persons != null)
			modelAndView.addObject("data", persons);
		else {
			modelAndView.addObject("data", new ArrayList<String>());
		}
		return modelAndView;

	}
}
