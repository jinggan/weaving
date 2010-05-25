import com.sun.xml.internal.ws.util.StringUtils;

import org.jerrymouse.weaving.model.Website;

import org.jerrymouse.weaving.model.Website;

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
	stringUtils.match(website, "www.google.com/profiles/");
}

def analysis(Website website){
	website.profile.id=getIdFromUrl(website.profile.url);
	website.profile.host=stringUtils.getHost(website.profile.url);
	String htmlContent = eye.see(new URL(website.profile.url));
	if (htmlContent == null)
		return;
	website.profile.username=getUsernameFromContent(htmlContent);
	website.profile.emails.add(getEmailFromUsername(website.profile.id));
	website.profile.avatarLinks.add(getSmallAvatarLinks(htmlContent));
	List<String> links=selfLinks(htmlContent);
	if(links!=null){
		website.connections.selfLinks.addAll(links);
	}
}

def String getIdFromUrl(String url) {
	stringUtils.urlParser(url, "google.com/profiles/{id}");
}
		

def String getUsernameFromContent(String htmlContent) {
	String xpath = "/html/body/div[5]/div/div[2]/h1/span".toUpperCase();
	Node node = domUtils.getSingleNodeFromXpath(htmlContent, xpath);
	node.getTextContent();
}
def String getEmailFromUsername(String id) {
	if(id!=null){
		if(!stringUtils.isNumber(id))
			return id+"@gmail.com";
	}
	return null;
}

def String getSmallAvatarLinks(String htmlContent) {
	String xpath = "/html/body/div[5]/div/div/div/img".toUpperCase();
	Node node = domUtils.getSingleNodeFromXpath(htmlContent, xpath);
	node.getAtrribute("src");
}

def List<String> selfLinks(String htmlContent){
	String xpath = "/html/body/div[5]/div[2]/div[2]/div/ul/ul/li/div/a".toUpperCase();
	List<Node> nodes = domUtils.getNodesFromXpath(htmlContent, xpath);
	List<String> links=new ArrayList<String>();
	nodes.each { 
		links.add(it.getAtrribute("href"));
	}
	return links;
}