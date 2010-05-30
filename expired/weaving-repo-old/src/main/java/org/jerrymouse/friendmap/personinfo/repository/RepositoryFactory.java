package org.jerrymouse.friendmap.personinfo.repository;

import org.jerrymouse.jsa4j.db.kv.DB;

public class RepositoryFactory {
	private DB db;

	public void setDb(DB db) {
		this.db = db;
	}

	public Repository getRepositroy() {
		Repository repository = new Jsa4jRepository(db);
		return repository;
	}
}