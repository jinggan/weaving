package org.jerrymouse.weaving.api;

import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.digger.Digger;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.model.analysis.AnalysisePerson;
import org.jerrymouse.weaving.test.TestCaseBase;
import org.junit.Test;

public class WeavingTest extends TestCaseBase {

	@Resource
	private Weaving weaving;
	@Resource
	private Digger digger;

	@Test
	public void testDigPerson() {
		List<AnalysisePerson> persons = digger
				.dig("https://www.google.com/profiles/KaiYanNju");
		log.trace(persons);
	}

	@Test
	public void testExtractWebsite() {
		Website website = weaving
				.extractWebsite("http://www.douban.com/people/yankay/");
		log.trace(website.toString());
	}

}
