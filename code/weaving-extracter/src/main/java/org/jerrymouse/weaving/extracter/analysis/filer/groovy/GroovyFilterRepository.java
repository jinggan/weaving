package org.jerrymouse.weaving.extracter.analysis.filer.groovy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.jerrymouse.jsa4j.db.kv.DB;
import org.jerrymouse.jsa4j.db.kv.JsonUtil;
import org.jerrymouse.jsa4j.db.kv.Repository;
import org.springframework.stereotype.Component;

import sun.misc.Cleaner;

public class GroovyFilterRepository {
	private static String key = "main";
	private static String repoPrefix = "groovyFilters";
	private DB db;
	private JsonUtil<Map> jsonUtil = new JsonUtil<Map>();
	private Map<String, String> localScripts;
	private Repository repository;
	private static String classpath = "classpath:";
	private Map<String, String> cache;

	private Repository getRepository() {
		if (repository == null)
			repository = new Repository(repoPrefix, db);
		return repository;
	}

	public Map<String, String> getScripts() {
		if (cache != null) {
			return cache;
		} else {
			refesh();
		}
		cache = jsonUtil.toBean(getRepository().get(key), Map.class);
		return cache;
	}

	public void clean() {
		putScripts(null);
	}

	private void refesh() {
		String scriptsJson = getRepository().get(key);
		Map<String, String> scripts;
		if (scriptsJson == null)
			scripts = new HashMap<String, String>();
		else
			scripts = jsonUtil.toBean(scriptsJson, Map.class);
		Map<String, String> scriptsLocal = getFromLocal();
		scriptsLocal.putAll(scripts);
		putScripts(scriptsLocal);
	}

	public void setDb(DB db) {
		this.db = db;
	}

	public void setLocalScripts(Map<String, String> localScripts) {
		this.localScripts = localScripts;
	}

	// private Map<String, String> cache;
	private Map<String, String> getFromLocal() {
		Map<String, String> m = new HashMap<String, String>();
		for (Map.Entry<String, String> entry : localScripts.entrySet()) {
			try {
				String content = IOUtils.toString(getConfigInputStream(entry
						.getValue()));
				m.put(entry.getKey(), content);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return m;
	}

	private InputStream getConfigInputStream(String path) {
		InputStream inputStream = null;
		if (path.startsWith(classpath)) {
			path = path.substring(classpath.length());
			inputStream = GroovyFilterRepository.class.getClassLoader()
					.getResourceAsStream(path);
		} else {
			try {
				inputStream = new FileInputStream(new File(path));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return inputStream;
	}

	public void putScripts(Map<String, String> map) {
		cache = null;
		String scriptsJson = jsonUtil.toJson(map);
		getRepository().put(key, scriptsJson);
	}
}
