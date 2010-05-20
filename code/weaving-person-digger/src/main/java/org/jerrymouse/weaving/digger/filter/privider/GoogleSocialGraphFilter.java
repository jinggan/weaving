package org.jerrymouse.weaving.digger.filter.privider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jerrymouse.weaving.digger.filter.Filter;
import org.jerrymouse.weaving.eye.Eye;
import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Website;
import org.springframework.stereotype.Component;

@Component
public class GoogleSocialGraphFilter implements Filter {
	@Resource
	private Eye eye;

	private static Log log = LogFactory.getLog(GoogleSocialGraphFilter.class);

	@Override
	public void dig(Person person) {
		if (person == null)
			return;
		digme(person);
	}

	private void digme(Person person) {
		String json = getJson(person);
	}

	private String getJson(Person person) {
		String query = "otherme?";
		String q = getQ(person);
		if (q == null)
			return null;
		else {
			query += "q=" + q;
		}
		try {
			log.trace("http://socialgraph.apis.google.com/" + query);
			return eye.see(new URL("http://socialgraph.apis.google.com/"
					+ query));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;

	}

	private String getQ(Person person) {
		List<Website> websites = person.getWebsites();
		List<String> qs = new ArrayList<String>();
		for (Website website : websites) {
			try {
				if (website.getProfile() != null) {
					qs.add(website.getProfile().getUrl());
					if (website.getProfile().getEmails() != null) {
						qs.addAll(website.getProfile().getEmails());
					}
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
		String q = "";
		for (String string : qs) {
			q += string + ",";
		}
		q.substring(0, q.length() - 1);
		return q;
	}

	@Override
	public boolean needRepeat() {
		return true;
	}

}
