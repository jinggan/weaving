package org.jerrymouse.weaving.extracter.analysis.model;

import org.jerrymouse.weaving.model.Connections;
import org.jerrymouse.weaving.model.Feeds;
import org.jerrymouse.weaving.model.Profile;
import org.jerrymouse.weaving.model.Website;

public  class AnalysiserWebsite implements Website {
	private Connections connections;
	private Feeds feeds;
	private Profile profile;

	public Connections getConnections() {
		return connections;
	}

	public void setConnections(Connections connections) {
		this.connections = connections;
	}

	public Feeds getFeeds() {
		return feeds;
	}

	public void setFeeds(Feeds feeds) {
		this.feeds = feeds;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}
