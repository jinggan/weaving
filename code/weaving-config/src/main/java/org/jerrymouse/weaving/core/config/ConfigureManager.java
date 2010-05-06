package org.jerrymouse.weaving.core.config;

import org.jerrymouse.jsa4j.db.kv.DBManagerFactory;

public class ConfigureManager {
	public static String GAE = "gae";
	public static String LOCAL = "local";
	private static String DERBY = "derby";
	private static String JCACHE = "jcache";
	private static String GAEMEM = "gae-mem";

	public Configure getConfigure(String env) {
		Configure configure = new Configure();
		DBManagerFactory dbManagerFactory = new DBManagerFactory();
		if (GAE.equals(env)) {
			configure.setMemDB(dbManagerFactory.getDBManager(GAEMEM).getDB());
			configure.setPersistenceDB(dbManagerFactory.getDBManager(GAE)
					.getDB());
		} else if (LOCAL.equals(env)) {
			configure.setMemDB(dbManagerFactory.getDBManager(JCACHE).getDB());
			configure.setPersistenceDB(dbManagerFactory.getDBManager(DERBY)
					.getDB());
		} else {
			return null;
		}
		return configure;
	}
}
