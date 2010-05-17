package org.jerrymouse.weaving.model.base;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.jerrymouse.weaving.model.Feeds;

public abstract class AbstractFeeds implements Feeds {
	/**
	 * 信息源地址
	 */
	protected List<String> feedLinks;

	public List<String> getFeedLinks() {
		return feedLinks;
	}

	public void setFeedLinks(List<String> feedLinks) {
		this.feedLinks = feedLinks;
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
