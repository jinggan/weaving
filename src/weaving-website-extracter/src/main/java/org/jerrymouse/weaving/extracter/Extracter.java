package org.jerrymouse.weaving.extracter;

import javax.annotation.Resource;

import org.jerrymouse.weaving.extracter.filer.ExtractFilterManager;
import org.jerrymouse.weaving.extracter.filer.ExtractPlan;
import org.jerrymouse.weaving.extracter.filer.WebsiteCleaner;
import org.jerrymouse.weaving.extracter.utils.AnalysiseModelUtils;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.model.analysis.AnalysiseProfile;
import org.jerrymouse.weaving.model.analysis.AnalysiseWebsite;
import org.jerrymouse.weaving.website.repo.WebsiteCache;
import org.jerrymouse.weaving.website.repo.WebsiteRepository;
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
	private AnalysiseModelUtils analysiseModelUtils;

	@Resource
	private ExtractFilterManager filterManager;
	@Resource
	private WebsiteCache websiteCache;
	@Resource
	private WebsiteRepository repository;

	public Website analyse(Website website) {
		ExtractPlan extractPlan = filterManager.createPlan(website);
		extractPlan.execute(website);
		repository.put(website);
		websiteCache.put(website.getProfile().getUrl(), website);
		return website;
	}

	/**
	 * 根据一个URL，挖出其相应的WebSite信息。 会更新存储信息
	 * 
	 * @param url
	 * @return
	 */
	public Website extract(String url) {
		Website cache = websiteCache.get(url);
		if (cache != null) {
			return cache;
		}
		Website site = getWebsite(url);
		return analyse(site);
	}

	public Website extract(Website website) {
		Website cache = websiteCache.get(website.getProfile().getUrl());
		if (cache != null) {
			return cache;
		}
		getWebsite(website.getProfile().getUrl(), website);
		return analyse(website);
	}

	private Website getWebsite(String url) {
		AnalysiseWebsite analysiseWebsite = AnalysiseWebsite.getInstance();
		getWebsite(url, analysiseWebsite);
		return analysiseWebsite;
	}

	private void getWebsite(String url, final Website analysiseWebsite) {
		Website website = repository.get(url);
		if (website == null) {
			analysiseWebsite.setProfile(AnalysiseProfile.getInstance());
			analysiseWebsite.getProfile().setUrl(url);
		} else {
			analysiseModelUtils.copy(website, analysiseWebsite);
		}
	}

}
