package org.jerrymouse.weaving.extracter.analysis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jerrymouse.weaving.extracter.analysis.filer.FilterManager;
import org.jerrymouse.weaving.model.Website;
import org.junit.Before;
import org.junit.Test;

public class AnalysiserTest {

	private String url = "http://www.douban.com/people/yankay/";
	Analysiser analysiser;

	private Log log = LogFactory.getLog(AnalysiserTest.class);

	@Before
	public void setUp() throws Exception {
		analysiser = new AnalysiserCreater().create(url);
	}

	@Test
	public void testAnalysis() {
		Website website = analysiser.analysis(url);
		log.trace(website.toString());
	}

}
