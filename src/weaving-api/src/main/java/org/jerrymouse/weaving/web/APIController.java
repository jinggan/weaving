package org.jerrymouse.weaving.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class APIController {
	@RequestMapping("/api")
	public String api() {
		return "api";
	}
}
