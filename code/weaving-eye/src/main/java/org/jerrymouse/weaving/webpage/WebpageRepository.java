package org.jerrymouse.weaving.webpage;

import java.net.URL;

import javax.annotation.Resource;

import org.jerrymouse.jsa4j.db.kv.DB;
import org.jerrymouse.jsa4j.db.kv.Repository;
import org.springframework.stereotype.Component;

@Component
public class WebpageRepository {

	private static String webpagePrefix = "webpage";
	@Resource(name = "db")
	private DB db;
	private Repository repository;

	public String get(URL url) {
		String key = url.toString();
		String webContent = getRepository().get(key);
		return webContent;
	}

	private Repository getRepository() {
		if (repository == null) {
			repository = new Repository(webpagePrefix, db);
		}
		return repository;
	}

	public void put(URL url, String webContent) {
		if (webContent == null)
			webContent = "null";
		String key = url.toString();
		getRepository().put(key, webContent);
	}

	public void setDb(DB db) {
		this.db = db;
	}
}
