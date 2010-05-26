package org.jerrymouse.weaving.digger.plan;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.model.analysis.AnalysisePerson;
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
	AnalysisePerson analysise(String query) {
		Website website = AnalysiseWebsite.getInstance();
		if (isUrl(query)) {
			website.getProfile().setUrl(query);
		} else if (isEmail(query)) {
			website.getProfile().getEmails().add(query);
		} else {
			website.getProfile().setUsername(query);
		}
		AnalysisePerson person = AnalysisePerson.getInstance();
		person.getWebsites().add(website);
		return person;
	}

	boolean isEmail(String query) {
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

		// Match the given string with the pattern
		Matcher m = p.matcher(query);

		// check whether match is found
		boolean matchFound = m.matches();

		return matchFound;
		// EmailValidator emailValidator = EmailValidator.getInstance();
		// return emailValidator.isValid(query);

		// // Checks for email addresses starting with
		// // inappropriate symbols like dots or @ signs.
		// Pattern p = Pattern.compile("^\\.|^\\@");
		// Matcher m = p.matcher(query);
		// if (m.find())
		// return false;
		// // Checks for email addresses that start with
		// // www. and prints a message if it does.
		// p = Pattern.compile("^www\\.");
		// m = p.matcher(query);
		// if (m.find()) {
		// return false;
		// }
		// p = Pattern.compile("[^A-Za-z0-9\\.\\@_\\-~#]+");
		// m = p.matcher(query);
		// StringBuffer sb = new StringBuffer();
		// boolean result = m.find();
		// boolean deletedIllegalChars = false;
		// while (result) {
		// deletedIllegalChars = true;
		// m.appendReplacement(sb, "");
		// result = m.find();
		// }
		//
		// // Add the last segment of input to the new String
		// m.appendTail(sb);
		// query = sb.toString();
		// if (deletedIllegalChars) {
		// return false;
		// }
		// return true;

	}

	boolean isUrl(String query) {
		// UrlValidator urlValidator=new UrlValidator();
		// return urlValidator.isValid(query);
		try {
			new URL(query);
		} catch (MalformedURLException e) {
			return false;
		}
		return true;
	}
}
