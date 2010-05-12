package org.jerrymouse.weaving.extracter.analysis.filer;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jerrymouse.weaving.extracter.analysis.filer.analysis.DomUtils;
import org.jerrymouse.weaving.extracter.analysis.filer.analysis.StringUtils;
import org.jerrymouse.weaving.extracter.analysis.model.AnalysiseProfile;
import org.jerrymouse.weaving.extracter.analysis.model.AnalysiseWebsite;
import org.jerrymouse.weaving.eye.Eye;
import org.jerrymouse.weaving.eye.EyeFactory;
import org.jerrymouse.weaving.model.Profile;
import org.jerrymouse.weaving.model.Website;
import org.junit.Before;
import org.junit.Test;

public class GroovyFilterTest {
	GroovyFilter groovyFilter;
	private Log log = LogFactory.getLog(GroovyFilterTest.class);

	@Before
	public void setUp() throws Exception {
		Eye eye = new EyeFactory().getEye();
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("groovy");
		log.trace(engine);
		groovyFilter = new GroovyFilter();
		groovyFilter.setEngine(engine);
		groovyFilter.setEye(eye);
		groovyFilter.setDomUtils(new DomUtils());
		groovyFilter.setStringUtils(new StringUtils());
	}

	@Test
	public void testDoubanAnalysis() {
		
		Website website = new AnalysiseWebsite();
		Profile profile = new AnalysiseProfile();
		profile.setUrl("http://www.douban.com/people/yankay/");
		website.setProfile(profile);
		log.trace(groovyFilter.isEnsure());
		groovyFilter.analysis(website);
		log.trace(website);
	}
}
