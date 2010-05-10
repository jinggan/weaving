package org.jerrymouse.weaving.extracter.analysis;

import java.util.ArrayList;
import java.util.List;

import org.jerrymouse.weaving.extracter.analysis.filer.Filter;
import org.jerrymouse.weaving.extracter.analysis.filer.FilterManager;

public class AnalysiserCreater {
	private FilterManager filterManager;

	public FilterManager getFilterManager() {
		if (filterManager == null)
			filterManager = new FilterManager();
		return filterManager;
	}

	public void setFilterManager(FilterManager filterManager) {
		this.filterManager = filterManager;
	}

	public Analysiser create(String url) {
		List<Filter> filters = new ArrayList<Filter>();
		for (Filter f : getFilterManager().getFilters()) {
			filters.add(f);
		}
		Analysiser analysiser = new Analysiser();
		analysiser.setFilters(filters);
		return analysiser;
	}
}
