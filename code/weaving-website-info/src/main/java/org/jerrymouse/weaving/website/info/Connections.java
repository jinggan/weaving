package org.jerrymouse.weaving.website.info;

import java.util.List;

public interface Connections {

	/**
	 * Followed的人到站内链接s
	 */
	// private List<String> followedLinks;

	/**
	 * Follow人的站内和站外链接s
	 */
	// private List<String> followLinks;

	/**
	 * 朋友的站内链接s
	 */
	// private List<String> friendLinks;

	/**
	 * 自己的站外链接s
	 */
	// private List<String> selfLinks;
	
	public List<String> getFollowedLinks();

	public List<String> getFollowLinks();

	public List<String> getFriendLinks();

	public List<String> getSelfLinks();

	public void setFollowedLinks(List<String> followedLinks) ;

	public void setFollowLinks(List<String> followLinks) ;

	public void setFriendLinks(List<String> friendLinks) ;

	public void setSelfLinks(List<String> selfLinks);
	
}
