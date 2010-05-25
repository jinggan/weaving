package org.jerrymouse.weaving.search;

import java.util.List;

import org.jerrymouse.weaving.model.Person;

public interface Searcher {

	List<Person> search(String q);

}
