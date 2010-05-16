package org.jerrymouse.weaving.core.config;

import org.jerrymouse.jsa4j.db.kv.DB;

public class DBFactory {
	private DB memDB;
	private DB persistenceDB;

	public DB getMemDB() {
		return memDB;
	}

	public void setMemDB(DB memDB) {
		this.memDB = memDB;
	}

	public DB getPersistenceDB() {
		return persistenceDB;
	}

	public void setPersistenceDB(DB persistenceDB) {
		this.persistenceDB = persistenceDB;
	}

}
