package org.jerrymouse.weaving.webpage;

import org.jerrymouse.jsa4j.db.kv.DB;
import org.jerrymouse.jsa4j.db.kv.DBManagerFactory;

public class WebpageRepositoryFactory {
	private DB db;

	public void setDb(DB db) {
		this.db = db;
	}

	public DB getDb() {
		return db;
	}

	public WebpageRepository getWebpageRepository(DB db) {
		this.db = db;
		return getWebpageRepository();
	}

	public WebpageRepository getWebpageRepository() {
		WebpageRepositoryImpl webpageRepository = new WebpageRepositoryImpl();
		webpageRepository.setDb(getDb());
		return webpageRepository;
	}
}
