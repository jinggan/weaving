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
import org.jerrymouse.weaving.model.analysis.AnalysiseConnections;
import org.springframework.stereotype.Component;

@Component
public class CommonConnectionFilter implements ExtractFilter {
	@Resource
	private Eye eye;
	@Resource
	private DomUtils domUtils;
	private static Log log = LogFactory.getLog(CommonConnectionFilter.class);

	@Override
	public void analysis(Website webSite) {
		try {
			if (webSite.getProfile() == null)
				return;
			if (webSite.getProfile().getUrl() == null)
				return;
			String content = eye.see(new URL(webSite.getProfile().getUrl()));
//			if (webSite.getConnections() == null) {
//				webSite.setConnections(new AnalysiseConnections());
//			}
			webSite.getConnections().setSelfLinks(getMe(content));
			webSite.getConnections().setFriendLinks(getFriend(content));
			webSite.getConnections().setFollowLinks(getContact(content));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	private List<String> getContact(String content) {
		List<String> list = new ArrayList<String>();
		List<String> contact = getLinks(content, "contact");
		List<String> acquaintance = getLinks(content, "acquaintance");
		if (contact != null)
			list.addAll(contact);
		if (acquaintance != null)
			list.addAll(acquaintance);
		return list;

	}

	private List<String> getFriend(String content) {
		return getLinks(content, "friend");
	}

	private List<String> getMe(String content) {
		return getLinks(content, "me");
	}

	private List<String> getLinks(String content, String ref) {
		List<String> list = new ArrayList<String>();
		List<Node> nodes = domUtils.getNodesFromXpath(content, "//a");
		for (Node node : nodes) {

			String rel=node.getAtrribute("rel");
			if(rel!=null){
//				log.trace(node.getAtrribute("rel"));
//				log.trace(node.getAtrribute("href"));
				if(rel.contains(ref)){
					list.add(node.getAtrribute("href"));
				}
			}
		}
		return list;
	}

	@Override
	public boolean isEnsure() {
		return false;
	}

	@Override
	public boolean match(Website website) {
		return false;
	}

}
