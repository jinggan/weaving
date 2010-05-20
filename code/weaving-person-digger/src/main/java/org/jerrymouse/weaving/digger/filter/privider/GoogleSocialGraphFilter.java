package org.jerrymouse.weaving.digger.filter.privider;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.jerrymouse.weaving.analysis.model.AnalysiseFeeds;
import org.jerrymouse.weaving.analysis.model.AnalysiseProfile;
import org.jerrymouse.weaving.analysis.model.AnalysiseWebsite;
import org.jerrymouse.weaving.digger.filter.Filter;
import org.jerrymouse.weaving.eye.Eye;
import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Profile;
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
		List<Website> websites = analyseJson(json);
	}

	private List<Website> analyseJson(String json) {
		List<Website> list = new ArrayList<Website>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode personData = mapper.readTree(json);
			Iterator<String> iterator = personData.getFieldNames();
			while (iterator.hasNext()) {
				String filed = iterator.next();
				JsonNode jsonNode = personData.get(filed);
				JsonNode attributes = jsonNode.get("attributes");

				JsonNode url = attributes.get("url");
				JsonNode profile = attributes.get("profile");
				JsonNode rss = attributes.get("rss");
				JsonNode atom = attributes.get("atom");
				JsonNode photo = attributes.get("photo");
				JsonNode fn = attributes.get("fn");

				Website website = new AnalysiseWebsite();
				list.add(website);
				website.setProfile(new AnalysiseProfile());
				if (profile != null) {
					website.getProfile().setUrl(jsonNodeToString(profile));
				} else if (filed != null) {
					website.getProfile().setUrl(filed);
				} else if (url != null) {
					website.getProfile().setUrl(jsonNodeToString(url));
				}
				website.getProfile().setAvatarLinks(new ArrayList<String>());
				website.getProfile().getAvatarLinks().add(
						jsonNodeToString(photo));
				website.getProfile().setUsername(jsonNodeToString(fn));
				website.setFeeds(new AnalysiseFeeds());
				website.getFeeds().setFeedLinks(new ArrayList<String>());
				website.getFeeds().getFeedLinks().add(jsonNodeToString(atom));
				website.getFeeds().getFeedLinks().add(jsonNodeToString(rss));
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.trace(list);
		return list;
	}

	private String jsonNodeToString(JsonNode jsonNode) {
		if (jsonNode == null)
			return null;
		return jsonNode.getTextValue();
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
		List<String> qs = new ArrayList<String>();
		for (Website website : person) {
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
		if (qs == null)
			return null;
		String q = "";
		for (String string : qs) {
			q += string + ",";
		}
		q = q.substring(0, q.lastIndexOf(','));
		return q;
	}

	@Override
	public boolean needRepeat() {
		return true;
	}

}
