package org.jerrymouse.weaving.web;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.jerrymouse.weaving.test.TestCaseBase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public class DigControllerTest extends TestCaseBase {
	@Resource
	private DigController controller;

	@Test
	public void testDig() throws Exception {
		ModelAndView modelAndView = controller.dig("kaiyannju", "1");
		MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
		MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();
		modelAndView.getView().render(modelAndView.getModel(),
				httpServletRequest, httpServletResponse);
		log.trace(httpServletResponse.getContentAsString());
	}
}
