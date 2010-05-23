package org.jerrymouse.weaving.extracter.filer;

import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.extracter.filer.groovy.GroovyFilterManager;
import org.jerrymouse.weaving.extracter.filer.java.CommonConnectionFilter;
import org.jerrymouse.weaving.extracter.filer.java.CommonFeedFilter;
import org.jerrymouse.weaving.extracter.filer.java.CommonProfileFilter;
import org.jerrymouse.weaving.model.Website;
import org.springframework.stereotype.Component;

@Component
public class ExtractFilterManager {
	private List<ExtractFilter> filters;
	@Resource
	private GroovyFilterManager groovyFilterManager;
	@Resource
	private CommonProfileFilter commonProfileFilter;
	@Resource
	private CommonConnectionFilter commonConnectionFilter;
	@Resource
	private CommonFeedFilter commonFeedFilter;

	//
	// public List<ExtractFilter> getFilters() {
	// if (filters == null) {
	// filters = new ArrayList<ExtractFilter>();
	// filters.addAll(groovyFilterManager.getGroovyFilters());
	// }
	// return filters;
	// }

	public ExtractPlan createPlan(Website website) {
		ExtractPlan extractPlan = new ExtractPlan();
		boolean hasEnsure = false;
		for (ExtractFilter extractFilter : groovyFilterManager
				.getGroovyFilters()) {
			if (extractFilter.match(website)) {
				extractPlan.add(extractFilter);
				if (extractFilter.isEnsure() == true)
					hasEnsure = true;
			}
		}
		if (!hasEnsure) {
			extractPlan.add(commonProfileFilter);
			extractPlan.add(commonConnectionFilter);
		}
		extractPlan.add(commonFeedFilter);
		return extractPlan;
	}

	// private List<ExtractFilter> createFilterList(Website website) {
	// List<ExtractFilter> filters = new ArrayList<ExtractFilter>();
	// for (ExtractFilter f : filterManager.getFilters()) {
	// if (f.match(website))
	// filters.add(f);
	// }
	// return filters;
	// }
}
