package org.jerrymouse.weaving.digger.plan;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.jerrymouse.weaving.test.TestCaseBase;
import org.junit.Before;
import org.junit.Test;

public class QueryAnalysiserTest extends TestCaseBase{
	@Resource
	private QueryAnalysiser analysiser;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsEmail() {
		boolean isEmail = analysiser.isEmail("kaiyannju@gmail.com");
		assertEquals(true, isEmail);
	}

	@Test
	public void testIsUrl() {
		boolean isUrl = analysiser
				.isUrl("https://www.google.com/profiles/KaiYanNju");
		assertEquals(true, isUrl);
	}

}
