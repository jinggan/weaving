package org.jerrymouse.weaving.extracter.analysis.filer.douban;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jerrymouse.weaving.extracter.analysis.filer.Filter;
import org.jerrymouse.weaving.extracter.analysis.filer.analysis.DomUtils;
import org.jerrymouse.weaving.extracter.analysis.filer.analysis.Node;
import org.jerrymouse.weaving.extracter.analysis.filer.analysis.StringUtils;
import org.jerrymouse.weaving.eye.Eye;
import org.jerrymouse.weaving.model.Profile;
import org.jerrymouse.weaving.model.Website;

public class DoubanProfileFilter implements Filter {
	private Eye eye;
	private static Log log = LogFactory.getLog(DoubanProfileFilter.class);
	private DomUtils domUtils;
	private StringUtils stringUtils;

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
		Node node = domUtils.getSingleNodeFromXpath(htmlContent,
				xpath);
		return node.getAtrribute("src");
	}

	private String getUsernameFromContent(String htmlContent) {
		String xpath = "/html/body/div[2]/div[2]/div/div/div/div[2]/h1";
		Node node = domUtils.getSingleNodeFromXpath(htmlContent,
				xpath);
		return node.getTextContent();
	}

	private String getIdFromUrl(String url) {
		return stringUtils.urlParser(url,
				"douban.com/people/{id}");
	}

	@Override
	public boolean isEnsure() {
		return true;
	}

	@Override
	public boolean match(String url) {
		return stringUtils.match(url,
				StringUtils.CONTAIN + "http://www.douban.com/people/");
	}

	private String getSmallAvatarLinks(String htmlContent) {
		String xpath = "/html/body/div[2]/div[2]/div/div/div/div/a/img";
		Node node = domUtils.getSingleNodeFromXpath(htmlContent,
				xpath);
		return node.getAtrribute("src");
	}

	@Override
	public void setDomUtils(DomUtils domUtils) {
		this.domUtils = domUtils;
	}

	@Override
	public void setStringUtils(StringUtils stringUtils) {
		this.stringUtils = stringUtils;
	}

}
