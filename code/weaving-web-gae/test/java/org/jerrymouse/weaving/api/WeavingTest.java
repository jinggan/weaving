package org.jerrymouse.weaving.api;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.test.TestCaseBase;
import org.junit.Before;
import org.junit.Test;

public class WeavingTest extends TestCaseBase {

	@Resource
	private Weaving weaving;

	@Before
	public void setUp() throws Exception {
	}

	//
	// @Test
	// public void testDigPerson() {
	// }

	@Test
	public void testExtractWebsite() {
		Website website = weaving.extractWebsite("http://www.yankay.com");
		log.trace(website.toString());
	}

}
