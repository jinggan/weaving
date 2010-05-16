package org.jerrymouse.weaving.extracter.analysis.filer.java;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jerrymouse.weaving.extracter.analysis.filer.Filter;
import org.jerrymouse.weaving.extracter.analysis.filer.utils.DomUtils;
import org.jerrymouse.weaving.extracter.analysis.filer.utils.Node;
import org.jerrymouse.weaving.extracter.analysis.filer.utils.StringUtils;
import org.jerrymouse.weaving.extracter.analysis.model.AnalysiseProfile;
import org.jerrymouse.weaving.extracter.analysis.model.AnalysiseWebsite;
import org.jerrymouse.weaving.eye.Eye;
import org.jerrymouse.weaving.model.Profile;
import org.jerrymouse.weaving.model.Website;
import org.springframework.stereotype.Component;

@Component
public class DoubanProfileFilter implements Filter {
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
			if (website.getProfile() == null)
				website.setProfile(new AnalysiseProfile());
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
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	private String getBigAvatarLinks(String htmlContent) {
		String xpath = "/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[2]/td[2]/img";
		Node node = domUtils.getSingleNodeFromXpath(htmlContent, xpath);
		return node.getAtrribute("src");
	}

	private String getUsernameFromContent(String htmlContent) {
		String xpath = "/html/body/div[2]/div[2]/div/div/div/div[2]/h1";
		Node node = domUtils.getSingleNodeFromXpath(htmlContent, xpath);
		return node.getTextContent();
	}

	private String getIdFromUrl(String url) {
		return stringUtils.urlParser(url, "douban.com/people/{id}");
	}

	@Override
	public boolean isEnsure() {
		return true;
	}

	@Override
	public boolean match(String url) {
		return stringUtils.match(url, "http://www.douban.com/people/");
	}

	private String getSmallAvatarLinks(String htmlContent) {
		String xpath = "/html/body/div[2]/div[2]/div/div/div/div/a/img";
		Node node = domUtils.getSingleNodeFromXpath(htmlContent, xpath);
		return node.getAtrribute("src");
	}

}
