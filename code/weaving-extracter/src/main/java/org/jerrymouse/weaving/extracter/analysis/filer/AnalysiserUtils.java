package org.jerrymouse.weaving.extracter.analysis.filer;

import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

import javax.xml.transform.TransformerException;

import org.cyberneko.html.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xpath.internal.XPathAPI;

public class AnalysiserUtils {

	/**
	 * mode like http://www.douban.com/people//
	 * 
	 * @param url
	 * @param mode
	 */
	public String stringMode(String url, String mode) {
		Scanner scanner = new Scanner(url);
		String result = scanner.findInLine(mode);
		return result;
	}

	public Node getSingleNodeFromXpath(Document doc, String xpath) {
		NodeList nodes = getNodesFromXpath(doc, xpath);
		return nodes.item(0);
	}

	public NodeList getNodesFromXpath(Document doc, String xpath) {
		xpath = xpath.toUpperCase();
		try {
			return XPathAPI.selectNodeList(doc, xpath);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return null;
	}

	public NodeList getNodesFromXpath(String htmlContent, String xpath) {
		return getNodesFromXpath(getDocument(htmlContent), xpath);
	}

	public Document getDocument(String htmlContent) {
		try {
			DOMParser dom = new DOMParser();
			dom.setFeature("http://xml.org/sax/features/namespaces", false);
			dom.parse(new InputSource(new StringReader(htmlContent)));
			return dom.getDocument();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Node getSingleNodeFromXpath(String htmlContent, String xpath) {
		return getSingleNodeFromXpath(getDocument(htmlContent), xpath);
	}
}
