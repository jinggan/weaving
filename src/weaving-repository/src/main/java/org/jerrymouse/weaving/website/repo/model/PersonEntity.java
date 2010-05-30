package org.jerrymouse.weaving.website.repo.model;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.model.base.AbstractPerson;

public class PersonEntity {
	private String key;

	public void setWebsiteUrls(List<String> websiteUrls) {
		this.websiteUrls = websiteUrls;
	}

	private List<String> websiteUrls;

	public List<String> getWebsiteUrls() {
		return websiteUrls;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	@Override
	public int hashCode() {
		if (key != null)
			return key.hashCode();
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		return hashCode() == obj.hashCode();
	}
}
