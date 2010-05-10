package org.jerrymouse.weaving.bean;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 个人网页的宿主， 用来描述个人页面背后的幕后黑手
 */
public abstract class Person {

	private String id;

	private List<WebSite> webSites;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 只可以Set已经有ID的PersonWebSite。如果没有的话，可以用KeyMaker作一个，或在先保存一下
	 * 
	 * @param wbSites
	 */
	public void setWebSites(List<WebSite> webSites) {
		this.webSites = webSites;
	}

	@JsonIgnore
	public List<WebSite> getWebSites() {
		return webSites;
	}

}
