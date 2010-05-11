package org.jerrymouse.weaving.model.base;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.jerrymouse.weaving.model.Connections;

public abstract class AbstractConnections implements Connections {

	/**
	 * Followed的人到站内链接s
	 */
	private List<String> followedLinks;

	/**
	 * Follow人的站内和站外链接s
	 */
	private List<String> followLinks;

	/**
	 * 朋友的站内链接s
	 */
	private List<String> friendLinks;

	/**
	 * 自己的站外链接s
	 */
	private List<String> selfLinks;

	public List<String> getFollowedLinks() {
		return followedLinks;
	}

	public void setFollowedLinks(List<String> followedLinks) {
		this.followedLinks = followedLinks;
	}

	public List<String> getFollowLinks() {
		return followLinks;
	}

	public void setFollowLinks(List<String> followLinks) {
		this.followLinks = followLinks;
	}

	public List<String> getFriendLinks() {
		return friendLinks;
	}

	public void setFriendLinks(List<String> friendLinks) {
		this.friendLinks = friendLinks;
	}

	public List<String> getSelfLinks() {
		return selfLinks;
	}

	public void setSelfLinks(List<String> selfLinks) {
		this.selfLinks = selfLinks;
	}@Override
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
