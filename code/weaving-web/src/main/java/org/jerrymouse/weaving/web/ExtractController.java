package org.jerrymouse.weaving.web;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.jerrymouse.weaving.extracter.Extracter;
import org.jerrymouse.weaving.model.Website;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExtractController {
	@Resource
	private Extracter extracter;

	@RequestMapping("/api/extract")
	public ModelAndView extract(@RequestParam String q,
			@RequestParam(required = false) String pretty) {
		Website website = extracter.extract(q);
		boolean p = pretty == null ? false : true;
		JsonView view = new JsonView();
		view.setPretty(p);
		ModelAndView modelAndView = new ModelAndView(view);
		if (website != null)
			modelAndView.addObject(website);
		else {
			modelAndView.addObject(new ArrayList<String>());
		}
		return modelAndView;
	}
}
