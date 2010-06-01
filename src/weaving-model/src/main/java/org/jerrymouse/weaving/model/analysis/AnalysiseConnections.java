package org.jerrymouse.weaving.model.analysis;

import java.util.ArrayList;

import org.jerrymouse.weaving.model.base.AbstractConnections;

public class AnalysiseConnections extends AbstractConnections {
	private AnalysiseConnections() {
	}
	
	public static AnalysiseConnections getInstance() {
		AnalysiseConnections analysiseConnections = new AnalysiseConnections();
		analysiseConnections.setFollowedLinks(new ArrayList<String>());
		analysiseConnections.setFollowLinks(new ArrayList<String>());
		analysiseConnections.setFriendLinks(new ArrayList<String>());
		analysiseConnections.setSelfLinks(new ArrayList<String>());
		return analysiseConnections;
	}
}
