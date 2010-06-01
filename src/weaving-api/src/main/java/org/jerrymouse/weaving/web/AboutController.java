package org.jerrymouse.weaving.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {
	@RequestMapping("/about")
	public String api() {
		return "about";
	}
}
