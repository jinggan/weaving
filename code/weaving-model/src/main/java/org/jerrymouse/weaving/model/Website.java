package org.jerrymouse.weaving.model;

public interface Website {
	// private Profile profile;
	// private Connections connections;
	// private Feeds feeds;

	public Profile getProfile();

	public void setProfile(Profile profile);

	public Connections getConnections();

	public void setConnections(Connections connections);

	public Feeds getFeeds();

	public void setFeeds(Feeds feeds);

}
