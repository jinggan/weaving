package org.jerrymouse.weaving.website.repo.model.utils;

import java.util.ArrayList;
import java.util.List;

import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.model.utils.ModelUtils;
import org.jerrymouse.weaving.website.repo.model.ConnectionsEntity;
import org.jerrymouse.weaving.website.repo.model.FeedsEntity;
import org.jerrymouse.weaving.website.repo.model.PersonEntity;
import org.jerrymouse.weaving.website.repo.model.ProfileEntity;
import org.jerrymouse.weaving.website.repo.model.WebsiteEntity;
import org.springframework.stereotype.Component;

@Component
public class EntityUtils {
	private ModelUtils<ProfileEntity, FeedsEntity, ConnectionsEntity> modelUtils = new ModelUtils<ProfileEntity, FeedsEntity, ConnectionsEntity>();

	public WebsiteEntity copy(Website website) {
		WebsiteEntity websiteEntity = new WebsiteEntity();
		websiteEntity.setProfile(modelUtils.copy(website.getProfile(),
				new ProfileEntity()));
		websiteEntity.setConnections(modelUtils.copy(website.getConnections(),
				new ConnectionsEntity()));
		websiteEntity.setFeeds(modelUtils.copy(website.getFeeds(),
				new FeedsEntity()));
		return websiteEntity;
	}

	public PersonEntity copy(Person person) {
		PersonEntity personEntity = new PersonEntity();
		List<String> list = new ArrayList<String>();
		if (person.getWebsites() != null) {
			for (Website website : person.getWebsites()) {
				list.add(website.getProfile().getUrl());
			}
		}
		personEntity.setWebsiteUrls(list);
		return personEntity;
	}
}
