package org.jerrymouse.weaving.web;

import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.digger.plan.GatherPerson;
import org.jerrymouse.weaving.test.TestCaseBase;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.web.servlet.ModelAndView;

public class PersonControllerTest extends TestCaseBase {
	@Resource
	private PersonController controller;

	@Test
	public void testDig() throws Exception {
		ExtendedModelMap map = new ExtendedModelMap();
		controller.dig("kaiyannju", map);
		List<GatherPerson> persons=(List<GatherPerson>) map.get("persons");
		log.trace(persons.get(0).getUrls());
	}

}
