package org.jerrymouse.weaving.model.analysis;

import java.util.ArrayList;
import java.util.HashMap;

import org.jerrymouse.weaving.model.base.AbstractWebsite;

public class AnalysiseWebsite extends AbstractWebsite {
	private AnalysiseWebsite() {
	}

	public static AnalysiseWebsite getInstance() {
		AnalysiseWebsite analysiseWebsite = new AnalysiseWebsite();
		analysiseWebsite.setConnections(AnalysiseConnections.getInstance());
		analysiseWebsite.setFeeds(AnalysiseFeeds.getInstance());
		analysiseWebsite.setProfile(AnalysiseProfile.getInstance());
		return analysiseWebsite;
	}

}
