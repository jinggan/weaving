package org.jerrymouse.weaving.extracter.analysis.filer.douban;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jerrymouse.weaving.extracter.analysis.model.AnalysiseProfile;
import org.jerrymouse.weaving.extracter.analysis.model.AnalysiseWebsite;
import org.jerrymouse.weaving.eye.Eye;
import org.jerrymouse.weaving.eye.EyeFactory;
import org.jerrymouse.weaving.model.Profile;
import org.jerrymouse.weaving.model.Website;
import org.junit.Before;
import org.junit.Test;

public class DoubanProfileFilterTest {
	DoubanProfileFilter doubanProfileFilter;
	private static Log log = LogFactory.getLog(DoubanProfileFilterTest.class);

	@Before
	public void setUp() throws Exception {
		Eye eye = new EyeFactory().getEye();
		doubanProfileFilter = new DoubanProfileFilter();
		doubanProfileFilter.setEye(eye);
	}

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
