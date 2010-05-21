package org.jerrymouse.weaving.extracter.analysis.filer.groovy;

import javax.annotation.Resource;

import org.jerrymouse.weaving.extracter.filer.groovy.GroovyFilter;
import org.jerrymouse.weaving.extracter.filer.groovy.GroovyFilterManager;
import org.jerrymouse.weaving.extracter.filer.groovy.GroovyFilterRepository;
import org.jerrymouse.weaving.model.Profile;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.model.analysis.AnalysiseProfile;
import org.jerrymouse.weaving.model.analysis.AnalysiseWebsite;
import org.jerrymouse.weaving.test.TestCaseBase;
import org.junit.Before;
import org.junit.Test;

public class GoogleGroovyFilterTest extends TestCaseBase {
	private GroovyFilter groovyFilter;
	@Resource
	private GroovyFilterManager groovyFilterManager;
	@Resource
	private GroovyFilterRepository filterRepository;

	@Before
	public void setUp() throws Exception {
		filterRepository.clean();
		groovyFilter = groovyFilterManager.getGroovyFilter("googleProfile");
	}

	@Test
	public void testAnalysis() {
		Website website = new AnalysiseWebsite();
		website.setProfile(new AnalysiseProfile());
		website.getProfile().setUrl("http://www.google.com/profiles/KaiYanNju");
		log.trace(website);
		groovyFilter.analysis(website);
		log.trace(website);
	}
	

}
