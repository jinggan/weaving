package org.jerrymouse.weaving.developTool.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = { "/index.do" })
public class IndexController {

	@RequestMapping(method = { RequestMethod.GET })
	public String index() {
		return "index";
	}
	

}
