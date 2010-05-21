package org.jerrymouse.weaving.extracter.filer.groovy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.jerrymouse.jsa4j.db.kv.DB;
import org.jerrymouse.jsa4j.db.kv.JsonUtil;
import org.jerrymouse.jsa4j.db.kv.Repository;
import org.springframework.core.io.Resource;

public class GroovyFilterRepository {
	private static String key = "main";
	private static String repoPrefix = "groovyFilters";
	Map<String, String> cache;
	private DB db;
	private JsonUtil<Map> jsonUtil = new JsonUtil<Map>();
	private Map<String, Resource> localScripts;
	private Repository repository;

	public void clean() {
		putScripts(null);
	}

	// private Map<String, String> cache;
	private Map<String, String> getFromLocal() {
		Map<String, String> m = new HashMap<String, String>();
		for (Map.Entry<String, Resource> entry : localScripts.entrySet()) {
			try {
				String content = IOUtils.toString(entry.getValue()
						.getInputStream());
				m.put(entry.getKey(), content);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return m;
	}

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

	public void putScripts(Map<String, String> map) {
		cache = null;
		String scriptsJson = jsonUtil.toJson(map);
		getRepository().put(key, scriptsJson);
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

	// private InputStream getConfigInputStream(String path) {
	// InputStream inputStream = null;
	// if (path.startsWith(classpath)) {
	// path = path.substring(classpath.length());
	// inputStream = GroovyFilterRepository.class.getClassLoader()
	// .getResourceAsStream(path);
	// } else {
	// try {
	// inputStream = new FileInputStream(new File(path));
	// } catch (FileNotFoundException e) {
	// e.printStackTrace();
	// }
	// }
	// return inputStream;
	// }

	public void setLocalScripts(Map<String, Resource> localScripts) {
		this.localScripts = localScripts;
	}
}
