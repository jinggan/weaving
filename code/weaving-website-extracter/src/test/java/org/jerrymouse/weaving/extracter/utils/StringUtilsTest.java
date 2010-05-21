package org.jerrymouse.weaving.extracter.utils;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.jerrymouse.weaving.extracter.utils.StringUtils;
import org.jerrymouse.weaving.test.TestCaseBase;
import org.junit.Test;

public class StringUtilsTest extends TestCaseBase {
	@Resource
	private StringUtils stringUtils;

	@Test
	public void testGetHost() {
		String host = stringUtils
				.getHost("http://www.douban.com/people/yankay/");
		log.trace(host);
		assertEquals("douban.com", host);
	}

}
