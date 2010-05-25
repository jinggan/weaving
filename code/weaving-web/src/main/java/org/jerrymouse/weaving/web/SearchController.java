package org.jerrymouse.weaving.web;

import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.search.CommonSearcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
	@Resource
	private CommonSearcher commonSearcher;

	@RequestMapping("/search")
	public String search(@RequestParam(required = false) String q, Model model) {
		if (q == null || q.isEmpty())
			return "redirect /";
		List<Person> persons = commonSearcher.search(q);
		model.addAttribute("persons", persons);
		return "persons";
	}
}
