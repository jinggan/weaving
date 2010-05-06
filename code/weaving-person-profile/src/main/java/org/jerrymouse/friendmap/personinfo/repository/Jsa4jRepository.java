package org.jerrymouse.friendmap.personinfo.repository;

import org.jerrymouse.friendmap.personinfo.repository.bean.PersonBean;
import org.jerrymouse.friendmap.personinfo.repository.bean.WebSiteBean;
import org.jerrymouse.jsa4j.db.kv.DB;
import org.jerrymouse.jsa4j.db.kv.JsonUtil;

public class Jsa4jRepository implements Repository {
	public static JsonUtil<Person> pJsonUtil = new JsonUtil<Person>();
	public static JsonUtil<WebSite> wJsonUtil = new JsonUtil<WebSite>();
	private DB db;

	public Jsa4jRepository(DB db) {
		this.db = db;
	}

	@Override
	public void deletePerson(String personId) {
		db.put(personId, null);
	}

	@Override
	public void deleteWebSite(String webSiteId) {
		db.put(webSiteId, null);
	}

	@Override
	public PersonBean getPerson(String personId) {
		String json = db.get(personId);
		PersonBean personBean = (PersonBean) pJsonUtil.toBean(json,
				PersonBean.class);
		personBean.setRepository(this);
		return personBean;
	}

	@Override
	public WebSiteBean getWebSite(String webSiteId) {
		String json = db.get(webSiteId);
		WebSiteBean personBean = (WebSiteBean) wJsonUtil.toBean(json,
				WebSiteBean.class);
		personBean.setRepository(this);
		return personBean;
	}

	@Override
	public PersonBean putPerson(Person person) {
		if (person == null)
			return null;
		String json = pJsonUtil.toJson(person);
		String personId = db.put(person.getId(), json);
		return getPerson(personId);
	}

	@Override
	public WebSiteBean putWebSite(WebSite webSite) {
		if (webSite == null)
			return null;
		String json = wJsonUtil.toJson(webSite);
		String personId = db.put(webSite.getId(), json);
		return getWebSite(personId);
	}

}
