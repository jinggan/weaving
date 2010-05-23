package org.jerrymouse.weaving.web;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.jerrymouse.weaving.digger.Digger;
import org.jerrymouse.weaving.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

@Controller
public class DigController {
	@Resource
	private Digger digger;

	@RequestMapping("/api/dig")
	public ModelAndView dig(@RequestParam String q,
			@RequestParam(required = false) String pretty) {
		Person person = digger.dig(q);
		boolean p = pretty == null ? false : true;
		JsonView view = new JsonView();
		view.setPretty(p);
		ModelAndView modelAndView = new ModelAndView(view);
		if (person != null)
			modelAndView.addObject(person);
		else {
			modelAndView.addObject(new ArrayList<String>());
		}
		return modelAndView;

	}
}
