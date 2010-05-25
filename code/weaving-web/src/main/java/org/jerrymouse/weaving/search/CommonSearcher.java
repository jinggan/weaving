package org.jerrymouse.weaving.search;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.model.Person;
import org.springframework.stereotype.Component;

@Component
public class CommonSearcher {

	@Resource
	private EmailSearcher emailSearcher;
	@Resource
	private UrlSearcher urlSearcher;
	@Resource
	private UsernameSearcher usernameSearcher;

	public List<Person> search(String q) {
		List<Person> persons = new ArrayList<Person>();
		for (Searcher searcher : getSearchers()) {
			List<Person> ps = searcher.search(q);
			if (ps != null)
				persons.addAll(ps);
		}
		return persons;
	}

	private List<Searcher> getSearchers() {
		List<Searcher> searchers = new ArrayList<Searcher>();
		searchers.add(emailSearcher);
		searchers.add(urlSearcher);
		searchers.add(usernameSearcher);
		return searchers;
	}

}
