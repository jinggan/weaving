package org.jerrymouse.weaving.model.base;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
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
	@Override
	public String toString() {
		try {
			return BeanUtils.describe(this).toString();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return super.toString();
	}
}
