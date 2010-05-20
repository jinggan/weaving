package org.jerrymouse.weaving.extracter.analysis.tool;

import javax.annotation.Resource;

import org.jerrymouse.weaving.analysis.model.AnalysiseProfile;
import org.jerrymouse.weaving.analysis.model.AnalysiseWebsite;
import org.jerrymouse.weaving.extracter.analysis.filer.groovy.GroovyFilter;
import org.jerrymouse.weaving.extracter.analysis.filer.groovy.GroovyFilterManager;
import org.jerrymouse.weaving.model.Profile;
import org.jerrymouse.weaving.model.Website;

public class GroovyFilterDevelopTool {
	@Resource
	private GroovyFilterManager groovyFilterManager;

	public Website analysis(String url, String script) {
		Website site = new AnalysiseWebsite();
		Profile profile = new AnalysiseProfile();
		profile.setUrl(url);
		site.setProfile(profile);
		getTempGroovyFilter(script).analysis(site);
		return site;
	}

	public boolean match(String url, String script) {
		return getTempGroovyFilter(script).match(url);
	}

	public boolean isEnsure(String url, String script) {
		return getTempGroovyFilter(script).isEnsure();
	}

	private GroovyFilter getTempGroovyFilter(String script) {
		GroovyFilter groovyFilter = groovyFilterManager
				.getGroovyFilterByScript(script);
		return groovyFilter;
	}
}
