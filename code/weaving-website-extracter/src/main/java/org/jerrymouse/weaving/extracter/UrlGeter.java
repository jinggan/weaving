package org.jerrymouse.weaving.extracter;

import java.util.List;

import org.jerrymouse.weaving.model.Website;
import org.springframework.stereotype.Component;

@Component
public class UrlGeter {
	public String getProfileUrl(String url) {
		return url;
	}

	public List<Website> getWebsites(String id, String email, String domain) {
		return null;
	}
}
