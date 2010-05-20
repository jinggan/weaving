package org.jerrymouse.weaving.extracter.analysis;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.analysis.model.AnalysiseProfile;
import org.jerrymouse.weaving.analysis.model.AnalysiseWebsite;
import org.jerrymouse.weaving.extracter.analysis.filer.Filter;
import org.jerrymouse.weaving.extracter.analysis.filer.FilterManager;
import org.jerrymouse.weaving.model.Profile;
import org.jerrymouse.weaving.model.Website;
import org.springframework.stereotype.Component;

/**
 * 实例为一个方案
 * 
 * @author yankai
 * 
 */
@Component
public class Analysiser {
	@Resource
	private FilterManager filterManager;

	/**
	 * 根据一个URL，挖出其相应的WebSite信息。
	 * 会更新存储信息
	 * 
	 * @param url
	 * @return
	 */
	public Website analysis(String url) {
		AnalysiseWebsite site;
		site = new AnalysiseWebsite();
		Profile profile = new AnalysiseProfile();
		profile.setUrl(url);
		site.setProfile(profile);
		for (Filter f : createFilterList(url)) {
			f.analysis(site);
		}
		return site;
	}

	private List<Filter> createFilterList(String url) {
		List<Filter> filters = new ArrayList<Filter>();
		for (Filter f : filterManager.getFilters()) {
			if (f.match(url))
				filters.add(f);
		}
		return filters;
	}

}
