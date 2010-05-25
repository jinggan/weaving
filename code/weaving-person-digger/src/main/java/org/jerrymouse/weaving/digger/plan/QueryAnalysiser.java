package org.jerrymouse.weaving.digger.plan;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.model.analysis.AnalysisePerson;
import org.jerrymouse.weaving.model.analysis.AnalysiseProfile;
import org.jerrymouse.weaving.model.analysis.AnalysiseWebsite;
import org.springframework.stereotype.Component;

@Component
public class QueryAnalysiser {
	/**
	 * email username url
	 * 
	 * @param query
	 * @return
	 */
	Person analysise(String query) {
		Website website = new AnalysiseWebsite();
		if (isUrl(query)) {
			website.setProfile(new AnalysiseProfile());
			website.getProfile().setUrl(query);
		} else if (isEmail(query)) {
			website.setProfile(new AnalysiseProfile());
			website.getProfile().setEmails(new ArrayList<String>());
			website.getProfile().getEmails().add(query);
		} else {
			website.setProfile(new AnalysiseProfile());
			website.getProfile().setUsername(query);
		}
		Person person = new AnalysisePerson();
		person.setWebsites(new ArrayList<Website>());
		person.getWebsites().add(website);
		return person;
	}

	boolean isEmail(String query) {
		// Checks for email addresses starting with
		// inappropriate symbols like dots or @ signs.
		Pattern p = Pattern.compile("^\\.|^\\@");
		Matcher m = p.matcher(query);
		if (m.find())
			return false;
		// Checks for email addresses that start with
		// www. and prints a message if it does.
		p = Pattern.compile("^www\\.");
		m = p.matcher(query);
		if (m.find()) {
			return false;
		}
		p = Pattern.compile("[^A-Za-z0-9\\.\\@_\\-~#]+");
		m = p.matcher(query);
		StringBuffer sb = new StringBuffer();
		boolean result = m.find();
		boolean deletedIllegalChars = false;
		while (result) {
			deletedIllegalChars = true;
			m.appendReplacement(sb, "");
			result = m.find();
		}

		// Add the last segment of input to the new String
		m.appendTail(sb);
		query = sb.toString();
		if (deletedIllegalChars) {
			return false;
		}
		return true;

	}

	boolean isUrl(String query) {
		try {
			new URL(query);
		} catch (MalformedURLException e) {
			return false;
		}
		return true;
	}
}
