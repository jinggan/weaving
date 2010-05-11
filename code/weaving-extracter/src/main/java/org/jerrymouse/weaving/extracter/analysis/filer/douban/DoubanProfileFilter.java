package org.jerrymouse.weaving.extracter.analysis.filer.douban;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jerrymouse.weaving.extracter.analysis.filer.AnalysiserUtils;
import org.jerrymouse.weaving.extracter.analysis.filer.Filter;
import org.jerrymouse.weaving.eye.Eye;
import org.jerrymouse.weaving.model.Profile;
import org.jerrymouse.weaving.model.Website;
import org.w3c.dom.Node;

public class DoubanProfileFilter implements Filter {
	private Eye eye;
	private static Log log = LogFactory.getLog(DoubanProfileFilter.class);

	public void setEye(Eye eye) {
		this.eye = eye;
	}

	@Override
	public void analysis(Website website) {
		try {
			Profile profile = website.getProfile();
			profile.setId(getIdFromUrl(profile.getUrl()));
			String htmlContent = eye.see(new URI(profile.getUrl()));
			if (htmlContent == null)
				return;
			profile.setUsername(getUsernameFromContent(htmlContent));
			List<String> avatarLinks = new ArrayList<String>();
			avatarLinks.add(getSmallAvatarLinks(htmlContent));
			avatarLinks.add(getBigAvatarLinks(htmlContent));
			profile.setAvatarLinks(avatarLinks);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	private String getBigAvatarLinks(String htmlContent) {
		String xpath = "/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[2]/td[2]/img";
		Node node = new AnalysiserUtils().getSingleNodeFromXpath(htmlContent,
				xpath);
		if (node == null)
			return null;
		String imageLink = node.getAttributes().getNamedItem("src")
				.getTextContent().trim();
		return imageLink;
	}

	private String getUsernameFromContent(String htmlContent) {
		String xpath = "/html/body/div[2]/div[2]/div/div/div/div[2]/h1";
		Node node = new AnalysiserUtils().getSingleNodeFromXpath(htmlContent,
				xpath);
		return node.getTextContent().trim();
	}

	private String getIdFromUrl(String url) {
		String k = new AnalysiserUtils().stringMode(url,
				"douban.com/people/[^/]*");
		String n = k.substring("douban.com/people/".length());
		return n;
	}

	@Override
	public boolean isEnsure() {
		return true;
	}

	@Override
	public boolean match(String url) {
		if (url.contains("http://www.douban.com/people/"))
			return true;
		return false;
	}

	private String getSmallAvatarLinks(String htmlContent) {
		String xpath = "/html/body/div[2]/div[2]/div/div/div/div/a/img";
		Node node = new AnalysiserUtils().getSingleNodeFromXpath(htmlContent,
				xpath);
		String imageLink = node.getAttributes().getNamedItem("src")
				.getTextContent().trim();
		return imageLink;

	}

}
