package org.jerrymouse.weaving.core.config;

import org.jerrymouse.jsa4j.search.Searcher;

public class SearchFactory {
	private Searcher searcher;

	public void setSearcher(Searcher searcher) {
		this.searcher = searcher;
	}

	public Searcher getSearcher() {
		return searcher;
	}
}
