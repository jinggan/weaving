package org.jerrymouse.weaving.model;

import java.util.List;

/**
 * 个人网页的宿主， 用来描述个人页面背后的幕后黑手
 */
public interface Person extends Iterable<Website>{
	public List<Website> getWebsites();

	public void setWebsites(List<Website> websites);
}
