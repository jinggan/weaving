package org.jerrymouse.weaving.website.repo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.model.Connections;
import org.jerrymouse.weaving.model.Profile;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.website.repo.model.ConnectionsEntity;
import org.jerrymouse.weaving.website.repo.model.ProfileEntity;
import org.jerrymouse.weaving.website.repo.model.WebsiteEntity;
import org.junit.Before;
import org.junit.Test;

public class WebsiteRepositoryTest extends TestCaseBase {
	@Resource
	private WebsiteRepository websiteRepository;

	@Before
	public void setUp() throws Exception {
	}

	private Website getWebsite() {
		Website website = new WebsiteEntity();
		Profile profile = new ProfileEntity();
		profile.setId("xx");
		profile.setUrl("aaa");
		profile.setUsername("cc");
		Connections connections = new ConnectionsEntity();
		List<String> followedLinks = new ArrayList<String>();
		followedLinks.add("xxx");
		connections.setFollowedLinks(followedLinks);
		website.setConnections(connections);
		website.setProfile(profile);
		return website;
	}

	@Test
	public void testPut() {
		String key = websiteRepository.put(getWebsite());
		log.trace(key);
		Website website = websiteRepository.get(key);
		log.trace(website);
	}

}
