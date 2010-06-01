package org.jerrymouse.weaving.web;

import javax.annotation.Resource;

import org.jerrymouse.weaving.digger.Digger;
import org.jerrymouse.weaving.digger.plan.GatherPerson;
import org.jerrymouse.weaving.model.analysis.AnalysisePerson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {
	@Resource
	private Digger digger;

	@RequestMapping("/person/{id}")
	public String dig(@PathVariable String id, Model model) {
		if (id == null || id.isEmpty())
			return "redirect /";
		AnalysisePerson person = digger.get(id);
		model.addAttribute("person", GatherPerson.getInstance(person));
		return "person";

	}
}
