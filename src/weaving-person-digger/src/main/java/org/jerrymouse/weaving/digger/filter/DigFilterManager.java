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

	public List<DigFilter> getFilters() {
		List<DigFilter> filters = new ArrayList<DigFilter>();
		filters.add(googleSocialGraphFilter);
		return filters;
	}
	
	public GoogleSocialGraphFilter getGoogleSocialGraphFilter() {
		return googleSocialGraphFilter;
	}
}
