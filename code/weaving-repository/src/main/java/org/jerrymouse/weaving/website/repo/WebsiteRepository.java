package org.jerrymouse.weaving.website.repo;

import javax.annotation.Resource;

import org.jerrymouse.jsa4j.db.kv.DB;
import org.jerrymouse.jsa4j.db.kv.JsonUtil;
import org.jerrymouse.jsa4j.db.kv.Repository;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.website.repo.model.WebsiteEntity;
import org.jerrymouse.weaving.website.repo.model.utils.EntityUtils;
import org.springframework.stereotype.Component;

@Component
public class WebsiteRepository {
	@Resource
	private DB db;
	private static String repoPrefix = "webisteRepo";
	private Repository repository;
	private JsonUtil<WebsiteEntity> jsonUtil = new JsonUtil<WebsiteEntity>();
	@Resource
	private EntityUtils entityUtils;

	public Repository getRepository() {
		if (repository == null)
			repository = new Repository(repoPrefix, db);
		return repository;
	}

	public Website get(String key) {
		WebsiteEntity websiteEntity = null;
		String json = getRepository().get(key);
		if (json != null) {
			websiteEntity = jsonUtil.toBean(json, WebsiteEntity.class);
		}
		return websiteEntity;
	}

	/**
	 * key为url
	 * 
	 * @param key
	 * @param website
	 * @return
	 */
	private String put(String key, Website website) {
		WebsiteEntity websiteEntity = entityUtils.copy(website);
		String json = jsonUtil.toJson(websiteEntity);
		key = getRepository().put(key, json);
		return key;
	}

	public String put(Website website) {
		WebsiteEntity websiteEntity = entityUtils.copy(website);
		String json = jsonUtil.toJson(websiteEntity);
		String key = getRepository().put(website.getProfile().getUrl(), json);
		return key;
	}
}
