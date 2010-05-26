package org.jerrymouse.weaving.extracter;

import javax.annotation.Resource;

import org.jerrymouse.weaving.extracter.filer.ExtractFilterManager;
import org.jerrymouse.weaving.extracter.filer.ExtractPlan;
import org.jerrymouse.weaving.extracter.utils.AnalysiseModelUtils;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.model.analysis.AnalysiseWebsite;
import org.jerrymouse.weaving.website.repo.WebsiteRepository;
import org.springframework.stereotype.Component;
@Component
public class ExtracterCache {
	@Resource
	private AnalysiseModelUtils analysiseModelUtils;

	@Resource
	private ExtractFilterManager filterManager;

	@Resource
	private WebsiteRepository repository;

	public void analyse(Website website) {
		ExtractPlan extractPlan = filterManager.createPlan(website);
		extractPlan.execute(website);
		repository.put(website);
	}

	/**
	 * 根据一个URL，挖出其相应的WebSite信息。 会更新存储信息
	 * 
	 * @param url
	 * @return
	 */
	public Website extract(String url) {
		Website site = getWebsiteFromDB(url);
		if (site == null) {
			site = AnalysiseWebsite.getInstance();
			site.getProfile().setUrl(url);
			analyse(site);
		}
		return site;
	}

	private Website getWebsiteFromDB(String url) {
		Website website = repository.get(url);
		AnalysiseWebsite analysiseWebsite = AnalysiseWebsite.getInstance();
		if (website == null) {
			return null;
		} else {
			analysiseModelUtils.copy(website, analysiseWebsite);
		}
		return analysiseWebsite;
	}

	public Website extract(Website w) {
		Website site = getWebsiteFromDB(w.getProfile().getUrl());
		if (site == null) {
			site = analysiseModelUtils.copy(w, site);
			analyse(site);
		}
		return site;
	}

	public Website get(String url) {
		// TODO Auto-generated method stub
		return null;
	}

}
