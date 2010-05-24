package org.jerrymouse.weaving.extracter;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jerrymouse.weaving.extracter.Extracter;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.test.TestCaseBase;
import org.junit.Test;

public class ExtracterTest extends TestCaseBase {

	private String url = "http://www.douban.com/people/yankay/";
	@Resource
	private Extracter extracter;

	private static Log log = LogFactory.getLog(ExtracterTest.class);

	@Test
	public void testAnalysis() {
		Website website = extracter.extract(url);
		log.trace(website.toString());
	}

}
