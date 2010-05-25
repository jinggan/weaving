package org.jerrymouse.weaving.digger.plan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jerrymouse.weaving.extracter.filer.WebsiteCleaner;
import org.jerrymouse.weaving.model.Connections;
import org.jerrymouse.weaving.model.Feeds;
import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Profile;
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
		combin(main.getProfile(), append.getProfile());
		combin(main.getConnections(), append.getConnections());
		combin(main.getFeeds(), append.getFeeds());

	}

	private void combin(Feeds main, Feeds append) {
		main.getFeedLinks().addAll(append.getFeedLinks());
	}

	private void combin(Connections main, Connections append) {
		main.getFollowedLinks().addAll(append.getFollowedLinks());
		main.getFollowLinks().addAll(append.getFollowLinks());
		main.getFriendLinks().addAll(append.getFriendLinks());
		main.getSelfLinks().addAll(append.getSelfLinks());
	}

	private void combin(Profile main, Profile append) {
		main.getAvatarLinks().addAll(append.getAvatarLinks());
		main.getEmails().addAll(append.getEmails());
		main.getPersonInfomations().putAll(main.getPersonInfomations());
		if (main.getHost() == null)
			main.setHost(append.getHost());
		if (main.getId() == null)
			main.setId(append.getHost());
		if (main.getUrl() == null)
			main.setUrl(append.getUrl());
		if (main.getUsername() == null) {
			main.setUsername(append.getUsername());
		}
	}

}
