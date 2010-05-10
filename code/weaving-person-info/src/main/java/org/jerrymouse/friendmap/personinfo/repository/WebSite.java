package org.jerrymouse.friendmap.personinfo.repository;

import java.util.List;
import java.util.Map;

public abstract class WebSite {
	/**
	 * 该网页的宿主，
	 */
	private Person person;

	/**
	 * 头像链接s
	 */
	private List<String> avatarLinks;

	/**
	 * Emails
	 */
	private List<String> emails;

	/**
	 * 产出资讯Rss(es)
	 */
	private List<String> feedLinks;
	/**
	 * Followed的人到站内链接s
	 */
	private List<WebSite> followedPersonWebSite;
	/**
	 * Follow人的站内和站外链接s
	 */
	private List<WebSite> followPersonWebSite;
	/**
	 * 朋友到站内链接s
	 */
	private List<WebSite> friendsPersonWebSite;

	private String id;
	/**
	 * 基本信息(真实姓名,生日,性别,地点....)<br/>
	 * 比较灵活，但是也有一定的规范
	 */
	private Map<String, String> personBasicInfomation;


	/**
	 * 个人主页
	 */
	private String personPage;
	/**
	 * 自己的站外链接s
	 */
	private List<WebSite> selfWebSiteLinks;;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 服务商代号 like Google 如果是个人博客则为域名 如 yankay.com
	 */
	private String websiteID;

	public List<String> getAvatarLinks() {
		return avatarLinks;
	}

	public List<String> getEmails() {
		return emails;
	}

	public List<String> getFeedLinks() {
		return feedLinks;
	}

	public List<WebSite> getFollowedPersonWebSite() {
		return followedPersonWebSite;
	}

	public List<WebSite> getFollowPersonWebSite() {
		return followPersonWebSite;
	}

	public List<WebSite> getFriendsPersonWebSite() {
		return friendsPersonWebSite;
	}

	public String getId() {
		return id;
	}

	public Map<String, String> getPersonBasicInfomation() {
		return personBasicInfomation;
	}


	public String getPersonPage() {
		return personPage;
	}

	public List<WebSite> getSelfWebSiteLinks() {
		return selfWebSiteLinks;
	}

	public String getUsername() {
		return username;
	}

	public String getWebsiteID() {
		return websiteID;
	}

	public void setAvatarLinks(List<String> avatarLinks) {
		this.avatarLinks = avatarLinks;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public void setFeedLinks(List<String> feedLinks) {
		this.feedLinks = feedLinks;
	}

	public void setFollowedPersonWebSite(List<WebSite> followedPersonWebSite) {
		this.followedPersonWebSite = followedPersonWebSite;
	}

	public void setFollowPersonWebSite(List<WebSite> followPersonWebSite) {
		this.followPersonWebSite = followPersonWebSite;
	}

	public void setFriendsPersonWebSite(List<WebSite> friendsPersonWebSite) {
		this.friendsPersonWebSite = friendsPersonWebSite;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPersonBasicInfomation(
			Map<String, String> personBasicInfomation) {
		this.personBasicInfomation = personBasicInfomation;
	}


	public void setPersonPage(String personPage) {
		this.personPage = personPage;
	}

	public void setSelfWebSiteLinks(List<WebSite> selfWebSiteLinks) {
		this.selfWebSiteLinks = selfWebSiteLinks;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setWebsiteID(String websiteID) {
		this.websiteID = websiteID;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

}