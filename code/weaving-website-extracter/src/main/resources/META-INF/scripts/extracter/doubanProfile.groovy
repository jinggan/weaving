import org.jerrymouse.weaving.model.Website;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jerrymouse.weaving.model.analysis.AnalysiseProfile;
import org.jerrymouse.weaving.extracter.utils.Node;
import org.jerrymouse.weaving.extracter.utils.StringUtils;
import org.jerrymouse.weaving.model.Profile;
import org.jerrymouse.weaving.model.Website;

def boolean isEnsure(){
	true;
}

def boolean match(Website website){
	stringUtils.match(website, "http://www.douban.com/people/");
}

def analysis(Website webSite){
	if(webSite.profile==null){
		return;
	}
	webSite.profile.id=getIdFromUrl(webSite.profile.url);
	webSite.profile.host=stringUtils.getHost(webSite.profile.url);
	String htmlContent = eye.see(new URL(webSite.profile.url));
	if (htmlContent == null)
		return;
	webSite.profile.username=getUsernameFromContent(htmlContent);
	if(webSite.profile.avatarLinks==null){
		webSite.profile.avatarLinks=new ArrayList<String>();
	}
	webSite.profile.avatarLinks.add(getSmallAvatarLinks(htmlContent));
	webSite.profile.avatarLinks.add(getBigAvatarLinks(htmlContent));
}

def String getIdFromUrl(String url) {
	stringUtils.urlParser(url, "douban.com/people/{id}");
}
		

def String getBigAvatarLinks(String htmlContent) {
	String xpath = "/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[2]/td[2]/img".toUpperCase();
	Node node = domUtils.getSingleNodeFromXpath(htmlContent, xpath);
	return node.getAtrribute("src");
}

def String getUsernameFromContent(String htmlContent) {
	String xpath = "/html/head/title".toUpperCase();
	Node node = domUtils.getSingleNodeFromXpath(htmlContent, xpath);
	node.getTextContent();
}

def String getSmallAvatarLinks(String htmlContent) {
	String xpath = "/html/body/div[2]/div[2]/div/div/div/div/a/img".toUpperCase();
	Node node = domUtils.getSingleNodeFromXpath(htmlContent, xpath);
	node.getAtrribute("src");
}