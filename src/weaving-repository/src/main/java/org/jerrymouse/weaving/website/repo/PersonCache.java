package org.jerrymouse.weaving.website.repo;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.jerrymouse.weaving.model.analysis.AnalysisePerson;
import org.springframework.stereotype.Component;

@Component
public class PersonCache {
	private Map<String, AnalysisePerson> map = new WeakHashMap<String, AnalysisePerson>();
	private Map<String, List<AnalysisePerson>> maps = new WeakHashMap<String, List<AnalysisePerson>>();

	public void put(String key, AnalysisePerson person) {
		map.put(key, person);
	}

	public AnalysisePerson get(String key) {
		return map.get(key);
	}

	public void puts(String key, List<AnalysisePerson> person) {
		maps.put(key, person);
	}

	public List<AnalysisePerson> gets(String key) {
		return maps.get(key);
	}
}
