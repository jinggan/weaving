package org.jerrymouse.weaving.website.repo.model;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.model.base.AbstractPerson;

public class PersonEntity {

	public void setWebsiteUrls(List<String> websiteUrls) {
		this.websiteUrls = websiteUrls;
	}

	private List<String> websiteUrls;

	public List<String> getWebsiteUrls() {
		return websiteUrls;
	}
}
