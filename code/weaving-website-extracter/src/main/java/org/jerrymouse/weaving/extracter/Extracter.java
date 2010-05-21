package org.jerrymouse.weaving.extracter;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.extracter.filer.ExtractFilter;
import org.jerrymouse.weaving.extracter.filer.ExtractFilterManager;
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
	@Resource
	private UrlGeter urlGeter;

	/**
	 * 根据一个URL，挖出其相应的WebSite信息。 会更新存储信息
	 * 
	 * @param url
	 * @return
	 */
	public Website extract(String url) {
		url = urlGeter.getProfileUrl(url);
		AnalysiseWebsite site = new AnalysiseWebsite();
		site.setProfile(new AnalysiseProfile());
		site.getProfile().setUrl(url);
		return extract(site);
	}

	public Website extract(Website website) {
		for (ExtractFilter f : createFilterList(website.getProfile().getUrl())) {
			f.analysis(website);
		}
		return website;
	}

	private List<ExtractFilter> createFilterList(String url) {
		List<ExtractFilter> filters = new ArrayList<ExtractFilter>();
		for (ExtractFilter f : filterManager.getFilters()) {
			if (f.match(url))
				filters.add(f);
		}
		return filters;
	}

}
