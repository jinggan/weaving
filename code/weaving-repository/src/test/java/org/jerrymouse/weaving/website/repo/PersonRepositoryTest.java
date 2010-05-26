package org.jerrymouse.weaving.website.repo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.model.Connections;
import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Profile;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.model.base.AbstractPerson;
import org.jerrymouse.weaving.test.TestCaseBase;
import org.jerrymouse.weaving.website.repo.model.ConnectionsEntity;
import org.jerrymouse.weaving.website.repo.model.PersonEntity;
import org.jerrymouse.weaving.website.repo.model.ProfileEntity;
import org.jerrymouse.weaving.website.repo.model.WebsiteEntity;
import org.junit.Test;

public class PersonRepositoryTest extends TestCaseBase {
	@Resource
	private PersonRepository personRepository;

	@Test
	public void testPut() {
		String key = personRepository.put("cc", getPerson());
		log.trace(key);
	}

	@Test
	public void testGetFromIndex() {
		List<PersonEntity> personEntitys = personRepository.getFromIndex("aaa");
		log.trace(personEntitys);
	}

	@Test
	public void testGet() {
		PersonEntity personEntity = personRepository.get("cc");
		log.trace(personEntity.getWebsiteUrls());
	}

	private Person getPerson() {
		Person person = new PersonMock();
		person.setWebsites(new ArrayList<Website>());
		person.getWebsites().add(getWebsite());
		return person;
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

}

class PersonMock extends AbstractPerson {

}