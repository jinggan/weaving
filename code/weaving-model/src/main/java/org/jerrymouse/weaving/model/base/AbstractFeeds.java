package org.jerrymouse.weaving.model.base;

import java.util.List;

import org.jerrymouse.weaving.model.Feeds;

public abstract class AbstractFeeds implements Feeds {
	/**
	 * 信息源地址
	 */
	private List<String> feedLinks;

	public List<String> getFeedLinks() {
		return feedLinks;
	}

	public void setFeedLinks(List<String> feedLinks) {
		this.feedLinks = feedLinks;
	}

}
