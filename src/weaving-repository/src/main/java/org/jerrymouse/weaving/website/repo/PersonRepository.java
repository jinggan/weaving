package org.jerrymouse.weaving.website.repo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.jerrymouse.jsa4j.db.kv.DB;
import org.jerrymouse.jsa4j.db.kv.Indexer;
import org.jerrymouse.jsa4j.db.kv.JsonUtil;
import org.jerrymouse.jsa4j.db.kv.KeyMaker;
import org.jerrymouse.jsa4j.db.kv.Repository;
import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.model.analysis.AnalysisePerson;
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
		if (set != null) {
			for (String k : set) {
				if (k != null)
					persons.add(get(k));
			}
		}
		return persons;
	}

	public List<PersonEntity> getFromIndexes(List<String> indexes) {
		List<PersonEntity> persons = new ArrayList<PersonEntity>();
		for (String index : indexes) {
			List<PersonEntity> ps = getFromIndex(index);
			persons.addAll(ps);
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
		personEntity.setKey(key);
		String json = jsonUtil.toJson(personEntity);
		key = getRepository().put(key, json);
		mkIndex(key, person);
		return key;
	}

	private void mkIndex(String key, Person person) {
		Set<String> content = new HashSet<String>();
		for (Website website : person) {
			content.add(website.getProfile().getUrl());
		}
		getIndexer().makeIndexs(key, new ArrayList<String>(content));
	}

	public void put(AnalysisePerson analysisePerson) {
		Set<PersonEntity> persons = new HashSet<PersonEntity>();
		for (Website website : analysisePerson) {
			String url = website.getProfile().getUrl();
			persons.addAll(getFromIndex(url));
		}
		if (persons.size() == 0) {
			String key = mkKey(analysisePerson);
			put(key, analysisePerson);
			analysisePerson.setKey(key);
		} else if (persons.size() == 1) {
			String key = persons.iterator().next().getKey();
			put(key, analysisePerson);
			analysisePerson.setKey(key);
		} else {
			String key = persons.iterator().next().getKey();
			put(key, analysisePerson);
			analysisePerson.setKey(key);
		}
	}

	private String mkKey(AnalysisePerson analysisePerson) {
		for (Website website : analysisePerson) {
			String k = website.getProfile().getId();
			if (k == null)
				continue;
			if (get(k) != null)
				continue;
			else {
				return k;
			}
		}
		return KeyMaker.make();
	}
}
