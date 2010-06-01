package org.jerrymouse.weaving.website.repo;

import java.util.Map;
import java.util.WeakHashMap;

import org.jerrymouse.weaving.model.Website;
import org.springframework.stereotype.Component;

@Component
public class WebsiteCache {
	private Map<String, Website> map = new WeakHashMap<String, Website>();

	public void put(String key, Website website) {
		map.put(key, website);
	}

	public Website get(String key) {
		return map.get(key);
	}
}