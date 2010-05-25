package org.jerrymouse.weaving.digger.filter.privider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.digger.filter.DigFilter;
import org.jerrymouse.weaving.digger.plan.PersonCleaner;
import org.jerrymouse.weaving.eye.Eye;
import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.model.analysis.AnalysiseProfile;
import org.jerrymouse.weaving.model.analysis.AnalysiseWebsite;
import org.springframework.stereotype.Component;

@Component
public class UserNameFilter implements DigFilter {
	@Resource
	private Eye eye;
	@Resource
	private PersonCleaner personCleaner;

	@Override
	public void dig(Person person) {
		List<String> usernames = new ArrayList<String>();
		for (Website website : person.getWebsites()) {
			if (website.getProfile() != null) {
				if (website.getProfile().getUsername() != null)
					usernames.add(website.getProfile().getUsername());
			}
		}
		List<String> urls = mkUrls(usernames);
		for (String url : urls) {
			try {
				if (eye.see(new URL(url)) == null)
					continue;
				Website website = AnalysiseWebsite.getInstance();
				website.getProfile().setUrl(url);
				person.getWebsites().add(website);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		personCleaner.clean(person);
	}

	private List<String> mkUrls(List<String> usernames) {
		List<String> urls = new ArrayList<String>();
		for (String username : usernames) {
			urls.add("http://twitter.com/" + username);
			urls.add("http://facebook.com/" + username);
			urls.add("http://facebook.com/" + username);
			urls.add("http://www.google.com/profiles/" + username);
		}
		return urls;
	}

}
