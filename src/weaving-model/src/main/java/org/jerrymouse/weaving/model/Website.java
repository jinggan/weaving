package org.jerrymouse.weaving.model;

public interface Website {
	// private Profile profile;
	// private Connections connections;
	// private Feeds feeds;

	public Connections getConnections();

	public Feeds getFeeds();

	public Profile getProfile();

	public void setConnections(Connections connections);

	public void setFeeds(Feeds feeds);

	public void setProfile(Profile profile);
	
}
