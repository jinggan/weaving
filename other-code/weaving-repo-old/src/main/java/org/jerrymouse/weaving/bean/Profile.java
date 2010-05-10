package org.jerrymouse.weaving.bean;

import java.util.List;
import java.util.Map;

public interface Profile {

	/**
	 * 个人主页
	 */
	// private String url;
	/**
	 * 用户名，一般可读
	 */
	// private String username;
	/**
	 * id,一般不可读
	 */
	// private String id;
	/**
	 * Emails
	 */
	// private List<String> emails;
	/**
	 * 头像链接s
	 */
	// private List<String> avatarLinks;

	/**
	 * 基本信息(真实姓名,生日,性别,地点....)<br/>
	 * 比较灵活
	 */
	// private Map<String, String> personInfomations;

	public String getUrl();

	public void setUrl(String url);

	public String getUsername();

	public void setUsername(String username);

	public String getId();

	public void setId(String id);

	public List<String> getEmails();

	public void setEmails(List<String> emails);

	public List<String> getAvatarLinks();

	public void setAvatarLinks(List<String> avatarLinks);

	public Map<String, String> getPersonInfomations();

	public void setPersonInfomations(Map<String, String> personInfomations);
}
