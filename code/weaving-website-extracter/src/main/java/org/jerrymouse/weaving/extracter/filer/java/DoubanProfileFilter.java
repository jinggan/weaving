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
import org.jerrymouse.weaving.extracter.utils.StringUtils;
import org.jerrymouse.weaving.eye.Eye;
import org.jerrymouse.weaving.model.Profile;
import org.jerrymouse.weaving.model.Website;
import org.springframework.stereotype.Component;

@Component
@Deprecated
public class DoubanProfileFilter implements ExtractFilter {
	@Resource
	private Eye eye;
	private static Log log = LogFactory.getLog(DoubanProfileFilter.class);
	@Resource
	private DomUtils domUtils;
	@Resource
	private StringUtils stringUtils;

	public void setEye(Eye eye) {
		this.eye = eye;
	}

	@Override
	public void analysis(Website website) {
		try {
			// if (website.getProfile() == null)
			// website.setProfile(new AnalysiseProfile());
			Profile profile = website.getProfile();
			profile.setId(getIdFromUrl(profile.getUrl()));
			String htmlContent = eye.see(new URL(profile.getUrl()));
			if (htmlContent == null)
				return;
			profile.setUsername(getUsernameFromContent(htmlContent));
			List<String> avatarLinks = new ArrayList<String>();
			avatarLinks.add(getSmallAvatarLinks(htmlContent));
			avatarLinks.add(getBigAvatarLinks(htmlContent));
			profile.setAvatarLinks(avatarLinks);
			// if (website.getConnections() == null) {
			// website.setConnections(new AnalysiseConnections());
			// }
			if (website.getConnections().getSelfLinks() == null) {
				website.getConnections().setSelfLinks(new ArrayList<String>());
			}
			String selfLink = selfLink(htmlContent);
			if (selfLink != null) {
				website.getConnections().getSelfLinks().add(selfLink);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	private String getBigAvatarLinks(String htmlContent) {
		String xpath = "/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[2]/td[2]/img"
				.toUpperCase();
		Node node = domUtils.getSingleNodeFromXpath(htmlContent, xpath);
		return node.getAtrribute("src");
	}

	private String getUsernameFromContent(String htmlContent) {
		String xpath = "/html/body/div[2]/div[2]/div/div/div/div[2]/h1"
				.toUpperCase();
		Node node = domUtils.getSingleNodeFromXpath(htmlContent, xpath);
		return node.getTextContent();
	}

	private String getIdFromUrl(String url) {
		return stringUtils.urlParser(url, "douban.com/people/{id}"
				.toUpperCase());
	}

	@Override
	public boolean isEnsure() {
		return true;
	}

	private String getSmallAvatarLinks(String htmlContent) {
		String xpath = "/html/body/div[2]/div[2]/div/div/div/div/a/img";
		Node node = domUtils.getSingleNodeFromXpath(htmlContent, xpath);
		return node.getAtrribute("src");
	}

	private String selfLink(String htmlContent) {
		String xpath = "//A[@target=\"_blank\"]";
		List<Node> nodes = domUtils.getNamedNodesFromXpath(htmlContent, xpath);
		for (Node node : nodes) {
			if (node.getAtrribute("href").contains(node.getTextContent()))
				return node.getAtrribute("href");
		}
		return null;
	}

	@Override
	public boolean match(Website website) {
		return stringUtils.match(website, "http://www.douban.com/people/");
	}

}
