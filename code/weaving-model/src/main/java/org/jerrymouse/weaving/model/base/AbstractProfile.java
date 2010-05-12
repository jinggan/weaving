package org.jerrymouse.weaving.model.base;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.jerrymouse.weaving.model.Profile;

public abstract class AbstractProfile implements Profile{

	/**
	 * 头像链接s
	 */
	protected List<String> avatarLinks;
	/**
	 * Emails
	 */
	protected List<String> emails;

	/**
	 * id,一般不可读
	 */
	protected String id;

	/**
	 * 基本信息(真实姓名,生日,性别,地点....)<br/>
	 * 比较灵活
	 */
	protected Map<String, String> personInfomations;

	/**
	 * 个人主页
	 */
	protected String url;

	/**
	 * 用户名，一般可读
	 */
	protected String username;

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
