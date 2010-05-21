package org.jerrymouse.weaving.extracter.filer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.extracter.filer.groovy.GroovyFilterManager;
import org.springframework.stereotype.Component;

@Component
public class ExtractFilterManager {
	private List<ExtractFilter> filters;
	@Resource
	private GroovyFilterManager groovyFilterManager;

	public List<ExtractFilter> getFilters() {
		if (filters == null) {
			filters = new ArrayList<ExtractFilter>();
			filters.addAll(groovyFilterManager.getGroovyFilters());
		}
		return filters;
	}

}
