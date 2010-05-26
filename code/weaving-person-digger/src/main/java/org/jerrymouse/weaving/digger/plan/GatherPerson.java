package org.jerrymouse.weaving.digger.plan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.model.base.AbstractPerson;

public class GatherPerson extends AbstractPerson {

	public String getUsername() {
		for (Website website : getWebsites()) {
			if (website.getProfile().getUsername() != null)
				return website.getProfile().getUsername();
		}
		return null;
	}

	public String getAvatar() {
		for (Website website : getWebsites()) {
			if (website.getProfile().getAvatarLinks() != null
					&& website.getProfile().getAvatarLinks().size() != 0)
				return website.getProfile().getAvatarLinks().get(0);
		}
		return null;
	}

	public String getEmail() {
		for (Website website : getWebsites()) {
			if (website.getProfile().getEmails() != null
					&& website.getProfile().getEmails().size() != 0)
				return website.getProfile().getEmails().get(0);
		}
		return null;
	}

	public List<String> getUrls() {
		List<String> urls = new ArrayList<String>();
		for (Website website : getWebsites()) {
			if (website.getProfile().getUrl() != null)
				urls.add(website.getProfile().getUrl());
		}
		return urls;
	}
	
	

	public String getUrl() {
		if (getUrls().size() != 0)
			return getUrls().get(0);
		return null;
	}

	public static GatherPerson getInstance(Person person) {
		GatherPerson gatherPerson = new GatherPerson();
		gatherPerson.setWebsites(person.getWebsites());
		return gatherPerson;
	}
}
