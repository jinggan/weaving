package org.jerrymouse.weaving.api;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.jerrymouse.weaving.digger.Digger;
import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.test.TestCaseBase;
import org.junit.Before;
import org.junit.Test;

public class WeavingTest extends TestCaseBase {

	@Resource
	private Weaving weaving;
	@Resource
	private Digger digger;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDigPerson() {
		Person person = digger.dig("https://www.google.com/profiles/KaiYanNju");
		log.trace(person);
	}

	@Test
	public void testExtractWebsite() {
		Website website = weaving
				.extractWebsite("http://www.douban.com/people/yankay/");
		log.trace(website.toString());
	}

}
