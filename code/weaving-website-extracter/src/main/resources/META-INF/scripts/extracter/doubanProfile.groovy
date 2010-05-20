import org.jerrymouse.weaving.model.Website;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jerrymouse.weaving.analysis.model.AnalysiseProfile;
import org.jerrymouse.weaving.extracter.analysis.filer.utils.Node;
import org.jerrymouse.weaving.extracter.analysis.filer.utils.StringUtils;
import org.jerrymouse.weaving.model.Profile;
import org.jerrymouse.weaving.model.Website;

def boolean isEnsure(){
	true;
}

def boolean match(String url){
	stringUtils.match(url, "http://www.douban.com/people/");
}

def analysis(Website webSite){
	Profile profile=webSite.profile;
	if(profile==null){
		webSite.profile=new AnalysiseProfile();
	}
	webSite.profile.id=getIdFromUrl(webSite.profile.url);
	webSite.profile.host=stringUtils.getHost(webSite.profile.url);
	String htmlContent = eye.see(new URL(profile.getUrl()));
	if (htmlContent == null)
		return;
	webSite.profile.username=getUsernameFromContent(htmlContent);
	List<String> avatarLinks = new ArrayList<String>();
	avatarLinks.add(getSmallAvatarLinks(htmlContent));
	avatarLinks.add(getBigAvatarLinks(htmlContent));
	profile.setAvatarLinks(avatarLinks);
}

def String getIdFromUrl(String url) {
	stringUtils.urlParser(url, "douban.com/people/{id}");
}
		

def String getBigAvatarLinks(String htmlContent) {
	String xpath = "/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[2]/td[2]/img";
	Node node = domUtils.getSingleNodeFromXpath(htmlContent, xpath);
	return node.getAtrribute("src");
}

def String getUsernameFromContent(String htmlContent) {
	String xpath = "/html/head/title";
	Node node = domUtils.getSingleNodeFromXpath(htmlContent, xpath);
	node.getTextContent();
}

def String getSmallAvatarLinks(String htmlContent) {
	String xpath = "/html/body/div[2]/div[2]/div/div/div/div/a/img";
	Node node = domUtils.getSingleNodeFromXpath(htmlContent, xpath);
	node.getAtrribute("src");
}