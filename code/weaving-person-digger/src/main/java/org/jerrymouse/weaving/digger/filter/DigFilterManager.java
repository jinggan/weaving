package org.jerrymouse.weaving.digger.filter;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.digger.filter.privider.GoogleSocialGraphFilter;
import org.springframework.stereotype.Component;

@Component
public class DigFilterManager {
	@Resource
	private GoogleSocialGraphFilter googleSocialGraphFilter;

	public List<Filter> getFilters() {
		List<Filter> filters = new ArrayList<Filter>();
		filters.add(googleSocialGraphFilter);
		return filters;
	}
}
