package org.jerrymouse.weaving.website.repo;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jerrymouse.jsa4j.db.kv.DB;
import org.jerrymouse.jsa4j.db.kv.JsonUtil;
import org.jerrymouse.jsa4j.db.kv.KeyMaker;
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
	// private static String indexPrefix = "webisteRepoUrl";
	private Repository repository;
	private JsonUtil<WebsiteEntity> jsonUtil = new JsonUtil<WebsiteEntity>();
	@Resource
	private EntityUtils entityUtils;
	private Log log = LogFactory.getLog(WebsiteRepository.class);

	// private Indexer indexer;
	public Repository getRepository() {
		if (repository == null)
			repository = new Repository(repoPrefix, db);
		return repository;
	}

	public Website get(String key) {
		WebsiteEntity websiteEntity = null;
		String json = getRepository().get(key);
		log.trace(json);
		if (json != null) {
			websiteEntity = jsonUtil.toBean(json, WebsiteEntity.class);
		}
		return websiteEntity;
	}

	// private Website getFromUrl(String url) {
	// return null;
	// }

	public String put(String key, Website website) {
		WebsiteEntity websiteEntity = entityUtils.copy(website);
		String json = jsonUtil.toJson(websiteEntity);
		log.trace(json);
		return getRepository().put(key, json);
	}

}
