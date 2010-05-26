package org.jerrymouse.weaving.website.repo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.jerrymouse.jsa4j.db.kv.DB;
import org.jerrymouse.jsa4j.db.kv.Indexer;
import org.jerrymouse.jsa4j.db.kv.JsonUtil;
import org.jerrymouse.jsa4j.db.kv.Repository;
import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.website.repo.model.PersonEntity;
import org.jerrymouse.weaving.website.repo.model.utils.EntityUtils;
import org.springframework.stereotype.Component;

@Component
public class PersonRepository {
	@Resource
	private DB db;
	private Indexer indexer;
	private static String repoPrefix = "personRepo";
	private static String indexPrefix = "personIndex";

	private Repository repository;
	private JsonUtil<PersonEntity> jsonUtil = new JsonUtil<PersonEntity>();
	@Resource
	private EntityUtils entityUtils;

	public Repository getRepository() {
		if (repository == null)
			repository = new Repository(repoPrefix, db);
		return repository;
	}

	public Indexer getIndexer() {
		if (indexer == null)
			indexer = new Indexer(indexPrefix, db);
		return indexer;
	}

	public List<PersonEntity> getFromIndex(String index) {
		Set<String> set = getIndexer().getKey(index);
		List<PersonEntity> persons = new ArrayList<PersonEntity>();
		for (String k : set) {
			if (k != null)
				persons.add(get(k));
		}
		return persons;
	}

	public PersonEntity get(String key) {
		PersonEntity personEntity = null;
		String json = getRepository().get(key);
		if (json != null) {
			personEntity = jsonUtil.toBean(json, PersonEntity.class);
		}
		return personEntity;
	}

	/**
	 * key为username
	 * 
	 * @param key
	 * @param website
	 * @return
	 */
	public String put(String key, Person person) {
		PersonEntity personEntity = entityUtils.copy(person);
		String json = jsonUtil.toJson(personEntity);
		key = getRepository().put(key, json);
		mkIndex(key, person);
		return key;
	}

	private void mkIndex(String key, Person person) {
		Set<String> content = new HashSet<String>();
		for (Website website : person) {
			content.add(website.getProfile().getUrl());
			content.add(website.getProfile().getUsername());
		}
		getIndexer().makeIndexs(key, new ArrayList<String>(content));
	}

}
