package org.jerrymouse.weaving.extracter.analysis.model;

import org.jerrymouse.weaving.model.Profile;
import org.jerrymouse.weaving.model.base.AbstractWebsite;

public class AnalysiseWebsite extends AbstractWebsite {

	@Override
	public Profile getProfile() {
		if (profile == null)
			profile = new AnalysiseProfile();
		return profile;
	}
}
