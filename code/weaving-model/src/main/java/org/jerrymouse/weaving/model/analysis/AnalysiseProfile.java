package org.jerrymouse.weaving.model.analysis;

import java.util.ArrayList;
import java.util.HashMap;

import org.jerrymouse.weaving.model.Profile;
import org.jerrymouse.weaving.model.base.AbstractProfile;

public class AnalysiseProfile extends AbstractProfile {
	private AnalysiseProfile() {
	}

	public static Profile getInstance() {
		AnalysiseProfile analysiseProfile = new AnalysiseProfile();
		analysiseProfile.setAvatarLinks(new ArrayList<String>());
		analysiseProfile.setEmails(new ArrayList<String>());
		analysiseProfile.setPersonInfomations(new HashMap<String, String>());
		return analysiseProfile;
	}
}
