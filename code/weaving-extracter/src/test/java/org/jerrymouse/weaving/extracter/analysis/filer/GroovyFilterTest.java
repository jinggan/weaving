package org.jerrymouse.weaving.extracter.analysis.filer;

import org.jerrymouse.weaving.extracter.analysis.model.AnalysiseWebsite;
import org.jerrymouse.weaving.eye.Eye;
import org.jerrymouse.weaving.eye.EyeFactory;
import org.jerrymouse.weaving.model.Website;
import org.junit.Before;
import org.junit.Test;

public class GroovyFilterTest {
	GroovyFilter groovyFilter;

	@Before
	public void setUp() throws Exception {
		Eye eye = new EyeFactory().getEye();
		groovyFilter = new GroovyFilter();
		groovyFilter.setEye(eye);
	}

	@Test
	public void testAnalysis() {
		Website webSite = new AnalysiseWebsite();
		groovyFilter.analysis(webSite);
	}
}
