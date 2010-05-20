package org.jerrymouse.weaving.extracter.analysis;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.test.TestCaseBase;
import org.junit.Test;

public class AnalysiserTest extends TestCaseBase {

	private String url = "http://www.douban.com/people/yankay/";
	@Resource
	private Analysiser analysiser;

	private static Log log = LogFactory.getLog(AnalysiserTest.class);

	@Test
	public void testAnalysis() {
		Website website = analysiser.analysis(url);
		log.trace(website.toString());
	}

}
