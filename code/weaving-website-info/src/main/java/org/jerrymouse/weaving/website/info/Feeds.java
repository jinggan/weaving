package org.jerrymouse.weaving.website.info;

import java.util.List;

public interface Feeds {
	/**
	 * 信息源地址
	 */
	// private List<String> feedLinks;

	public void setFeedLinks(List<String> feedLinks);

	public List<String> getFeedLinks();
}
