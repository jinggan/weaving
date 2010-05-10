package org.jerrymouse.weaving.webpage;

import java.net.URI;

import org.jerrymouse.jsa4j.db.kv.DB;
import org.jerrymouse.jsa4j.db.kv.Indexer;
import org.jerrymouse.jsa4j.db.kv.Repository;

public class WebpageRepositoryImpl implements WebpageRepository {
	private DB db;
	private static String webpagePrefix = "webpage";
	// private static String webpageUrlPrefix = "webpage.url";
	private Repository repository;

	// private Indexer indexer;

	public void setDb(DB db) {
		this.db = db;
	}

	private Repository getRepository() {
		if (repository == null) {
			repository = new Repository(webpagePrefix, db);
		}
		return repository;
	}

	//
	// private Indexer getIndexer() {
	// if (indexer == null) {
	// indexer = new Indexer(webpageUrlPrefix, db);
	// }
	// return indexer;
	// }

	@Override
	public String get(URI url) {
		String key = url.toString();
		return getRepository().get(key);
	}

	@Override
	public void put(URI url, String webContent) {
		String key = url.toString();
		getRepository().put(key, webContent);
	}
}
