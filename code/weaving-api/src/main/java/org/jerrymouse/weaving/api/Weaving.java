package org.jerrymouse.weaving.api;

import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Website;

public interface Weaving {
	public Person digPerson(String url);

	public Website extractWebsite(String url);

	public String getUrl(Website website);
}
