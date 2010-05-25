package org.jerrymouse.weaving.digger.plan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.jerrymouse.weaving.extracter.filer.WebsiteCleaner;
import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Website;
import org.springframework.stereotype.Component;

@Component
public class PersonCleaner {

	@Resource
	private WebsiteCleaner websiteCleaner;

	public void clean(Person person) {
		Map<String, Website> map = new HashMap<String, Website>();
		for (Website website : person) {
			if (website.getProfile() != null
					&& website.getProfile().getUrl() != null) {
				if (map.containsKey(website.getProfile().getUrl())) {
					combin(map.get(website.getProfile().getUrl()), website);
				} else {
					map.put(website.getProfile().getUrl(), website);
				}
			}
		}
		List<Website> websites = new ArrayList<Website>();
		for (Website website : map.values()) {
			websiteCleaner.clean(website);
			websites.add(website);
		}
	}

	private void combin(Website main, Website append) {

	}

}
