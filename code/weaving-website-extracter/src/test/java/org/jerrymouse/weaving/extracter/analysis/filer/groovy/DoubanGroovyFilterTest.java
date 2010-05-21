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

public class DoubanGroovyFilterTest extends TestCaseBase {
	private GroovyFilter groovyFilter;
	@Resource
	private GroovyFilterManager groovyFilterManager;
	@Resource
	private GroovyFilterRepository filterRepository;

	@Before
	public void setUp() throws Exception {
		filterRepository.clean();
		groovyFilter = groovyFilterManager.getGroovyFilter("doubanProfile");
	}

	@Test
	public void testAnalysis() {
		Website website = new AnalysiseWebsite();
		Profile profile = new AnalysiseProfile();
		profile.setUrl("http://www.douban.com/people/yankay/");
		website.setProfile(profile);
		log.trace(profile);
		groovyFilter.analysis(website);
		log.trace(profile);
	}
	
	@Test
	public void testAnalysis2() {
		Website website = new AnalysiseWebsite();
		Profile profile = new AnalysiseProfile();
		profile.setUrl("http://www.douban.com/people/2239880/");
		website.setProfile(profile);
		log.trace(profile);
		groovyFilter.analysis(website);
		log.trace(profile);
	}
	
	@Test
	public void testAnalysis3() {
		Website website = new AnalysiseWebsite();
		Profile profile = new AnalysiseProfile();
		profile.setUrl("http://www.douban.com/people/EagerYuan/");
		website.setProfile(profile);
		groovyFilter.analysis(website);
		log.trace(profile);
	}

	@Test
	public void testIsEnsure() {
		log.trace(groovyFilter.isEnsure());
	}

	@Test
	public void testMatch() {
//		log.trace(groovyFilter.match("http://www.douban.com/people/yankay/"));
//		log.trace(groovyFilter.match("http://www.douban.com/peopdsle/yankay/"));

	}

}
