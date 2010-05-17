package org.jerrymouse.weaving.website.repo.model;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.jerrymouse.weaving.model.Connections;
import org.jerrymouse.weaving.model.Feeds;
import org.jerrymouse.weaving.model.Profile;
import org.jerrymouse.weaving.model.base.AbstractWebsite;

/**
 * @author yankai
 * 
 */
public class WebsiteEntity extends AbstractWebsite {
	@JsonDeserialize(as = ConnectionsEntity.class)
	@Override
	public void setConnections(Connections connections) {
		super.setConnections(connections);
	}

	@JsonDeserialize(as = ProfileEntity.class)
	@Override
	public void setProfile(Profile profile) {
		super.setProfile(profile);
	}

	@JsonDeserialize(as = FeedsEntity.class)
	@Override
	public void setFeeds(Feeds feeds) {
		super.setFeeds(feeds);
	}

}
