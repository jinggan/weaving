package org.jerrymouse.weaving.extracter.analysis.filer.douban;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jerrymouse.weaving.extracter.analysis.filer.java.DoubanProfileFilter;
import org.jerrymouse.weaving.extracter.analysis.model.AnalysiseProfile;
import org.jerrymouse.weaving.extracter.analysis.model.AnalysiseWebsite;
import org.jerrymouse.weaving.model.Profile;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.test.TestCaseBase;
import org.junit.Test;

public class DoubanProfileFilterTest extends TestCaseBase {
	@Resource
	private DoubanProfileFilter doubanProfileFilter;
	private static Log log = LogFactory.getLog(DoubanProfileFilterTest.class);

	@Test
	public void testAnalysis() {
		Website website = new AnalysiseWebsite();
		Profile profile = new AnalysiseProfile();
		profile.setUrl("http://www.douban.com/people/yankay/");
		website.setProfile(profile);
		doubanProfileFilter.analysis(website);
		log.trace(profile);
	}
}
