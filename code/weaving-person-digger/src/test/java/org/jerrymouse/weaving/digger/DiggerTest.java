package org.jerrymouse.weaving.digger;

import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.model.analysis.AnalysisePerson;
import org.jerrymouse.weaving.test.TestCaseBase;
import org.junit.Test;

public class DiggerTest extends TestCaseBase {
	@Resource
	private Digger digger;

	@Test
	public void testDig() {
		List<AnalysisePerson> persons = digger
				.dig("https://www.google.com/profiles/KaiYanNju");
		log.trace(persons);
		log.trace(persons.get(0).getKey());
	}

	@Test
	public void testEmail() {
		List<AnalysisePerson> persons = digger.dig("kaiyannju@gmail.com");
		log.trace(persons);
	}

	@Test
	public void testUsername() {
		List<AnalysisePerson> persons = digger.dig("kaiyannju");
		log.trace(persons);
	}

}
