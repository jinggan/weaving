package org.jerrymouse.weaving.extracter.analysis.filer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.extracter.analysis.filer.groovy.GroovyFilterManager;
import org.springframework.stereotype.Component;

@Component
public class FilterManager {
	private List<Filter> filters;
	@Resource
	private GroovyFilterManager groovyFilterManager;

	public List<Filter> getFilters() {
		if (filters == null) {
			filters = new ArrayList<Filter>();
			filters.addAll(groovyFilterManager.getGroovyFilters());
		}
		return filters;
	}

}
