package org.jerrymouse.weaving.extracter.analysis.filer;

import java.util.ArrayList;
import java.util.List;

import org.jerrymouse.weaving.extracter.analysis.filer.douban.DoubanProfileFilter;

public class FilterManager {
	List<Filter> filters;

	public void init() {
		filters = new ArrayList<Filter>();
		Filter filter = new DoubanProfileFilter();
		filters.add(filter);
	}

	public List<Filter> getFilters() {
		if (filters == null)
			init();
		return filters;
	}

	public void load() {
	}

	public void save() {
	}
}
