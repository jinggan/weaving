package org.jerrymouse.weaving.extracter.analysis.filer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jerrymouse.weaving.extracter.analysis.filer.analysis.StringUtils;
import org.junit.Before;
import org.junit.Test;

public class UrlAnalysiserTest {
	Log log = LogFactory.getLog(UrlAnalysiserTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindMode() {
		String url = new StringUtils().urlParser(
				"http://www.douban.com/people/yankay/",
				"douban.com/people/{username}/");
		log.trace(url);
	}

	@Test
	public void testFindMode2() {
		String url = new StringUtils().urlParser(
				"http://fdsafdas/people/yankay/",
				"douban.com/people/{username}/");
		log.trace(url);
	}

	@Test
	public void testFindMode3() {
		String url = new StringUtils().urlParser(
				"http://fdsafdas/people/yankay/", "people/{username}");
		log.trace(url);
	}

}
