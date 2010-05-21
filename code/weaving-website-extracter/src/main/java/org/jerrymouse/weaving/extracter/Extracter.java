package org.jerrymouse.weaving.extracter;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.extracter.filer.ExtractFilter;
import org.jerrymouse.weaving.extracter.filer.ExtractFilterManager;
import org.jerrymouse.weaving.extracter.filer.ExtractPlan;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.model.analysis.AnalysiseProfile;
import org.jerrymouse.weaving.model.analysis.AnalysiseWebsite;
import org.springframework.stereotype.Component;

/**
 * 实例为一个方案
 * 
 * @author yankai
 * 
 */
@Component
public class Extracter {
	@Resource
	private ExtractFilterManager filterManager;

	/**
	 * 根据一个URL，挖出其相应的WebSite信息。 会更新存储信息
	 * 
	 * @param url
	 * @return
	 */
	public Website extract(String url) {
		AnalysiseWebsite site = new AnalysiseWebsite();
		site.setProfile(new AnalysiseProfile());
		site.getProfile().setUrl(url);
		return extract(site);
	}

	public Website extract(Website website) {
		ExtractPlan extractPlan = filterManager.createPlan(website);
		extractPlan.execute(website);
		return website;
	}


}
