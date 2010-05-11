package org.jerrymouse.weaving.extracter.analysis;

import java.util.List;

import org.jerrymouse.weaving.extracter.analysis.filer.Filter;
import org.jerrymouse.weaving.extracter.analysis.model.AnalysiseWebsite;
import org.jerrymouse.weaving.model.Website;

/**
 * 实例为一个方案
 * 
 * @author yankai
 * 
 */
public class Analysiser {
	private List<Filter> filters;

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	/**
	 * 根据一个URL，挖出其相应的WebSite信息
	 * 
	 * @param url
	 * @return
	 */
	Website analysis(String url) {
		Website site = new AnalysiseWebsite();
		for (Filter f : filters) {
			f.analysis(site);
		}
		return site;
	}

}
