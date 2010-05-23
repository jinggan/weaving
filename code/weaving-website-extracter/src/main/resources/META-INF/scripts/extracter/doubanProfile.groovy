import org.jerrymouse.weaving.model.Website;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jerrymouse.weaving.model.analysis.AnalysiseConnections;
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

def analysis(Website website){
	if(website.profile==null){
		return;
	}
	website.profile.id=getIdFromUrl(website.profile.url);
	website.profile.host=stringUtils.getHost(website.profile.url);
	String htmlContent = eye.see(new URL(website.profile.url));
	if (htmlContent == null)
		return;
	website.profile.username=getUsernameFromContent(htmlContent);
	if(website.profile.avatarLinks==null){
		website.profile.avatarLinks=new ArrayList<String>();
	}
	website.profile.avatarLinks.add(getSmallAvatarLinks(htmlContent));
	website.profile.avatarLinks.add(getBigAvatarLinks(htmlContent));
	if(website.connections==null){
		website.connections=new AnalysiseConnections();
	}
	if(website.connections.selfLinks==null){
		website.connections.selfLinks=new ArrayList<String>();
	}
	String selfLink=selfLink(htmlContent);
	if(selfLink!=null){
		website.connections.selfLinks.add(selfLink);
	}
	
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


def String selfLink(String htmlContent){
	String xpath = "//A[@target=\"_blank\"]";
	List<Node> nodes = domUtils.getNamedNodesFromXpath(htmlContent, xpath);
	for (Node node : nodes) {
		if(node.getAtrribute("href")!=null){
			if(node.getAtrribute("href").contains(node.getTextContent()))
				return node.getAtrribute("href");
		}
	}
}