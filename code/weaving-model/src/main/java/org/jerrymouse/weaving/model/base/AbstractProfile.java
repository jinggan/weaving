package org.jerrymouse.weaving.model.base;

import java.util.List;
import java.util.Map;

import org.jerrymouse.weaving.model.Profile;

public abstract class AbstractProfile implements Profile{

	/**
	 * 头像链接s
	 */
	private List<String> avatarLinks;
	/**
	 * Emails
	 */
	private List<String> emails;

	/**
	 * id,一般不可读
	 */
	private String id;

	/**
	 * 基本信息(真实姓名,生日,性别,地点....)<br/>
	 * 比较灵活
	 */
	private Map<String, String> personInfomations;

	/**
	 * 个人主页
	 */
	private String url;

	/**
	 * 用户名，一般可读
	 */
	private String username;

	public List<String> getAvatarLinks() {
		return avatarLinks;
	}

	public List<String> getEmails() {
		return emails;
	}

	public String getId() {
		return id;
	}

	public Map<String, String> getPersonInfomations() {
		return personInfomations;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public void setAvatarLinks(List<String> avatarLinks) {
		this.avatarLinks = avatarLinks;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPersonInfomations(Map<String, String> personInfomations) {
		this.personInfomations = personInfomations;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}