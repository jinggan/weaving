package org.jerrymouse.weaving.extracter.utils;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.TransformerException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cyberneko.html.parsers.DOMParser;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xpath.internal.XPathAPI;

@Component
public class DomUtils {
	private static Log log = LogFactory.getLog(DomUtils.class);

	public Node getSingleNodeFromXpath(Document doc, String xpath) {
		List<Node> nodes = getNodesFromXpath(doc, xpath);
		if (nodes == null || nodes.size() < 1)
			return new Node();
		return nodes.get(0);
	}

	public List<Node> getNodesFromXpath(Document doc, String xpath) {
		xpath = xpath.toUpperCase();
		List<Node> analysisNodes;
		analysisNodes = new ArrayList<Node>();
		try {
			NodeList nodes = XPathAPI.selectNodeList(doc, xpath);
			if (nodes == null)
				return analysisNodes;
			for (int i = 0; i < nodes.getLength(); i++) {
				analysisNodes.add(new Node(nodes.item(i)));
			}
		} catch (TransformerException e) {
			log.trace(e.getMessageAndLocation());
		}
		return analysisNodes;
	}

	public List<Node> getNodesFromXpath(String htmlContent, String xpath) {
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
