package org.jerrymouse.weaving.model.base;

import java.util.List;

import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Website;

public class AbstractPerson implements Person {
	private List<Website> websites;

	@Override
	public List<Website> getWebsites() {
		return websites;
	}

	@Override
	public void setWebsites(List<Website> websites) {
		this.websites = websites;
	}

}
