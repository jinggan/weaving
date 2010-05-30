package org.jerrymouse.weaving.model.analysis;

import java.util.ArrayList;

import org.jerrymouse.weaving.model.base.AbstractFeeds;

public class AnalysiseFeeds extends AbstractFeeds {
	private AnalysiseFeeds() {
	}
	
	public static AnalysiseFeeds getInstance() {
		AnalysiseFeeds analysiseFeeds = new AnalysiseFeeds();
		analysiseFeeds.setFeedLinks(new ArrayList<String>());
		return analysiseFeeds;
	}
}
