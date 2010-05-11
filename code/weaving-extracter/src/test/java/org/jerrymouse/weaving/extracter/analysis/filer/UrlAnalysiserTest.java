package org.jerrymouse.weaving.extracter.analysis.filer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

public class UrlAnalysiserTest {
	Log log = LogFactory.getLog(UrlAnalysiserTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindMode() {
		String url = new AnalysiserUtils().stringMode(
				"http://www.douban.com/people/yankay/",
				"douban.com/people/[^/]*");
		log.trace(url);
	}

}
