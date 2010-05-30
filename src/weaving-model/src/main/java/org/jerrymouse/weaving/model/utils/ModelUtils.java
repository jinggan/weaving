package org.jerrymouse.weaving.model.utils;

import org.jerrymouse.weaving.model.Connections;
import org.jerrymouse.weaving.model.Feeds;
import org.jerrymouse.weaving.model.Profile;

public class ModelUtils<P extends Profile, F extends Feeds, C extends Connections> {

	public P copy(Profile profile, P p) {
		if (p == null||profile==null)
			return null;
		p.setAvatarLinks(profile.getAvatarLinks());
		p.setEmails(profile.getEmails());
		p.setId(profile.getId());
		p.setPersonInfomations(profile.getPersonInfomations());
		p.setUrl(profile.getUrl());
		p.setUsername(profile.getUsername());
		return p;
	}

	public F copy(Feeds feeds, F f) {
		if (f == null || feeds==null)
			return null;
		f.setFeedLinks(feeds.getFeedLinks());
		return f;
	}

	public C copy(Connections connections, C c) {
		if (c == null||connections==null)
			return null;
		c.setFollowedLinks(connections.getFollowedLinks());
		c.setFollowLinks(connections.getFollowLinks());
		c.setFriendLinks(connections.getFriendLinks());
		c.setSelfLinks(connections.getSelfLinks());
		return c;
	}
}
