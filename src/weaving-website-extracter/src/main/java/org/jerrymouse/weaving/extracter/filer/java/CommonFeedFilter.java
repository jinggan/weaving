package org.jerrymouse.weaving.extracter.filer.java;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jerrymouse.weaving.extracter.filer.ExtractFilter;
import org.jerrymouse.weaving.extracter.utils.DomUtils;
import org.jerrymouse.weaving.extracter.utils.Node;
import org.jerrymouse.weaving.eye.Eye;
import org.jerrymouse.weaving.model.Website;
import org.springframework.stereotype.Component;

@Component
public class CommonFeedFilter implements ExtractFilter {

	private static Log log = LogFactory.getLog(CommonFeedFilter.class);
	@Resource
	private Eye eye;
	@Resource
	private DomUtils domUtils;

	@Override
	public void analysis(Website webSite) {
		try {
			if (webSite.getProfile() == null)
				return;
			if (webSite.getProfile().getUrl() == null)
				return;
			String content = eye.see(new URL(webSite.getProfile().getUrl()));
			List<String> feeds = getFeeds(content);
			// if (webSite.getFeeds() == null) {
			// webSite.setFeeds(new AnalysiseFeeds());
			// }
			webSite.getFeeds().setFeedLinks(feeds);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	private List<String> getFeeds(String content) {
		List<Node> nodes = domUtils.getNodesFromXpath(content,
				"/html/head/link".toUpperCase());
		List<String> list = new ArrayList<String>();
		for (Node node : nodes) {
			if ("alternate".equalsIgnoreCase(node.getAtrribute("rel"))) {
				list.add(node.getAtrribute("href"));
			}
		}
		return list;
	}

	@Override
	public boolean isEnsure() {
		return true;
	}

	@Override
	public boolean match(Website website) {
		return true;
	}

}
