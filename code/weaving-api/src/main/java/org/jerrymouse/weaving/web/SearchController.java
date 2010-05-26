package org.jerrymouse.weaving.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.digger.Digger;
import org.jerrymouse.weaving.digger.plan.GatherPerson;
import org.jerrymouse.weaving.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
	@Resource
	private Digger digger;

	@RequestMapping("/search")
	public String search(@RequestParam(required = false) String q, Model model) {
		if (q == null || q.isEmpty())
			return "redirect /";
		List<Person> persons = digger.dig(q);
		List<GatherPerson> gatherPersons = new ArrayList<GatherPerson>();
		for (Person person : persons) {
			gatherPersons.add(GatherPerson.getInstance(person));
		}
		model.addAttribute("persons", gatherPersons);
		model.addAttribute("q", q);
		return "persons";
	}
}
