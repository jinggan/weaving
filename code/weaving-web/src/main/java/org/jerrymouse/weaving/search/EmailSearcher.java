package org.jerrymouse.weaving.search;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.digger.Digger;
import org.jerrymouse.weaving.model.Person;
import org.springframework.stereotype.Component;

@Component
public class EmailSearcher implements Searcher {
	@Resource
	private Digger digger;

	public List<Person> search(String q) {
		List<Person> persons = new ArrayList<Person>();
		return null;
	}

}
