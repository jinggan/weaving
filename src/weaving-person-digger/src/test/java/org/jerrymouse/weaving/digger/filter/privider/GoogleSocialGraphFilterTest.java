package org.jerrymouse.weaving.digger.filter.privider;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.model.analysis.AnalysisePerson;
import org.jerrymouse.weaving.model.analysis.AnalysiseWebsite;
import org.jerrymouse.weaving.test.TestCaseBase;
import org.junit.Before;
import org.junit.Test;

public class GoogleSocialGraphFilterTest extends TestCaseBase {
	@Resource
	private GoogleSocialGraphFilter googleSocialGraphFilter;
	private Person person;

	@Before
	public void setUp() throws Exception {
		person = AnalysisePerson.getInstance();
		AnalysiseWebsite website = AnalysiseWebsite.getInstance();
		website.getProfile()
				.setUrl("https://www.google.com/profiles/KaiYanNju");
		List<Website> websites = new ArrayList<Website>();
		websites.add(website);
		person.setWebsites(websites);
	}

	@Test
	public void testDig() {
		log.trace(person.getWebsites().size());
		googleSocialGraphFilter.dig(person);
		log.trace(person.getWebsites().size());

	}

}
