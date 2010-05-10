package org.jerrymouse.friendmap.personinfo.repository.bean;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.jerrymouse.friendmap.personinfo.repository.Jsa4jRepository;
import org.jerrymouse.friendmap.personinfo.repository.Repository;
import org.jerrymouse.weaving.bean.Person;
import org.jerrymouse.weaving.bean.WebSite;

public class PersonBean extends Person {
	private Repository repository;
	private List<String> webSiteIds;

	public void setRepository(Repository repository) {
		this.repository = repository;
	}

	@Override
	public void setWebSites(List<WebSite> webSites) {
		webSiteIds = new ArrayList<String>();
		for (WebSite webSite : webSites) {
			webSiteIds.add(webSite.getId());
		}
		super.setWebSites(null);
	}

	@JsonIgnore
	@Override
	public List<WebSite> getWebSites() {
		if (super.getWebSites() == null) {
			List<WebSite> personWebSites = new ArrayList<WebSite>();
			for (String webSiteId : webSiteIds) {
				WebSite personWebSite = repository.getWebSite(webSiteId);
				personWebSites.add(personWebSite);
			}
			super.setWebSites(personWebSites);
		}
		return super.getWebSites();
	}

	public void setPersonWebSiteIds(List<String> personWebSiteIds) {
		this.webSiteIds = personWebSiteIds;
	}

	public List<String> getPersonWebSiteIds() {
		return webSiteIds;
	}

	@Override
	public String toString() {
		return Jsa4jRepository.pJsonUtil.toJson(this);
	}
}
