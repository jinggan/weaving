package org.jerrymouse.weaving.extracter.filer.java;

import javax.annotation.Resource;

import org.jerrymouse.weaving.extracter.filer.ExtractFilter;
import org.jerrymouse.weaving.extracter.utils.StringUtils;
import org.jerrymouse.weaving.model.Website;
import org.springframework.stereotype.Component;

@Component
public class CommonProfileFilter implements ExtractFilter {
	@Resource
	private StringUtils stringUtils;

	@Override
	public void analysis(Website webSite) {
		if (webSite.getProfile().getUrl() != null)
			webSite.getProfile().setHost(
					stringUtils.getHost(webSite.getProfile().getUrl()));
	}

	@Override
	public boolean isEnsure() {
		return false;
	}

	@Override
	public boolean match(Website url) {
		return true;
	}

}
