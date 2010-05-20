package org.jerrymouse.weaving.model.base;

import java.util.Iterator;
import java.util.List;

import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Website;

public class AbstractPerson implements Person, Iterable<Website> {
	private List<Website> websites;

	@Override
	public List<Website> getWebsites() {
		return websites;
	}

	@Override
	public void setWebsites(List<Website> websites) {
		this.websites = websites;
	}

	@Override
	public Iterator<Website> iterator() {
		if (websites != null)
			return websites.iterator();
		return null;
	}

}
