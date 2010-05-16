package org.jerrymouse.weaving.developTool.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = { "/script-debug.do" })
public class DebugController {

	@RequestMapping(method = { RequestMethod.GET })
	public String index() {
		return "script-debug";
	}

	@RequestMapping(method = { RequestMethod.POST })
	public String debug(String url, String script, ModelMap map) {
		
		return "script-debug";
	}

}
