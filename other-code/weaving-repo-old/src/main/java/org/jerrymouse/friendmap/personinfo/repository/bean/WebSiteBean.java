package org.jerrymouse.friendmap.personinfo.repository.bean;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.jerrymouse.friendmap.personinfo.repository.Jsa4jRepository;
import org.jerrymouse.friendmap.personinfo.repository.Repository;
import org.jerrymouse.weaving.bean.Person;
import org.jerrymouse.weaving.bean.WebSite;

public class WebSiteBean extends WebSite {
	private Repository repository;
	/**
	 * 个人ID
	 */
	private String personId;

	@JsonIgnore
	@Override
	public Person getPerson() {
		super.setPerson(repository.getPerson(personId));
		return super.getPerson();
	}

	@Override
	public void setPerson(Person person) {
		personId = person.getId();
		super.setPerson(person);
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}

	public String toString() {
		return Jsa4jRepository.wJsonUtil.toJson(this);
	}
}