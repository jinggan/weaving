package org.jerrymouse.weaving.extracter.utils;

import org.jerrymouse.weaving.model.Connections;
import org.jerrymouse.weaving.model.Feeds;
import org.jerrymouse.weaving.model.Profile;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.model.analysis.AnalysiseConnections;
import org.jerrymouse.weaving.model.analysis.AnalysiseFeeds;
import org.jerrymouse.weaving.model.analysis.AnalysiseProfile;
import org.jerrymouse.weaving.model.utils.ModelUtils;
import org.springframework.stereotype.Component;

@Component
public class AnalysiseModelUtils {
	private ModelUtils<Profile, Feeds, Connections> modelUtils = new ModelUtils<Profile, Feeds, Connections>();

	public Website copy(Website website, Website analysiseWebsite) {
		if (analysiseWebsite == null)
			return analysiseWebsite;
		// if (analysiseWebsite.getProfile() == null)
		// analysiseWebsite.setProfile(AnalysiseProfile.);
		// if (analysiseWebsite.getConnections() == null)
		// analysiseWebsite.setConnections(new AnalysiseConnections());
		// if (analysiseWebsite.getFeeds() == null)
		// analysiseWebsite.setFeeds(new AnalysiseFeeds());
		analysiseWebsite.setProfile(modelUtils.copy(website.getProfile(),
				analysiseWebsite.getProfile()));
		analysiseWebsite.setConnections(modelUtils.copy(website
				.getConnections(), analysiseWebsite.getConnections()));
		analysiseWebsite.setFeeds(modelUtils.copy(website.getFeeds(),
				analysiseWebsite.getFeeds()));
		return analysiseWebsite;
	}
}
