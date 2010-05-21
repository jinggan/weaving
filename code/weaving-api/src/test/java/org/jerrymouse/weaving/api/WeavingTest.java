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
		Website website = weaving
				.extractWebsite("http://www.yankay.com/nosql%E6%95%B0%E6%8D%AE%E5%BA%93%E7%AC%94%E8%B0%88v0-2/");
		log.trace(website.toString());
	}

}
