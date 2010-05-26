package org.jerrymouse.weaving.api;

import javax.annotation.Resource;

import org.jerrymouse.weaving.digger.Digger;
import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.test.LocalTestCaseBase;
import org.junit.Test;

public class WeavingTest extends LocalTestCaseBase {

	@Resource
	private Weaving weaving;
	@Resource
	private Digger digger;


	@Test
	public void testlLog() throws Exception {

	}

	public void testExtractWebsite() {
		Website website = weaving
				.extractWebsite("http://www.douban.com/people/yankay/");
		log.trace(website.toString());
	}

}
