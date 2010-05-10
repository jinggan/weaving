package org.jerrymouse.weaving.network;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class NetworkConfig {
	private boolean isInGFW = false;
	private List<String> gfwList;

	public boolean isInGFW() {
		return isInGFW;
	}

	public void setInGFW(boolean isInGFW) {
		this.isInGFW = isInGFW;
	}

	public List<String> getGfwList() {
		return gfwList;
	}

	public void setGfwList(List<String> gfwList) {
		this.gfwList = gfwList;
	}

}

class XMLConfig {
	private static Log log = LogFactory.getLog(XMLConfig.class);

	private Document document;

	XMLConfig(String xmlPath) {
		try {
			InputStream in = null;
			try {
				in = XMLConfig.class.getClassLoader().getResourceAsStream(
						xmlPath);
				if (in == null)
					return;
				SAXReader reader = new SAXReader();
				document = reader.read(in);
			} finally {
				if (in != null)
					in.close();
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	String getProvider(String name) {
		if (document == null)
			return null;
		Element unit = getUnit(name);
		Element provider = unit.element("provider");
		if (provider.getText() != null)
			return provider.getText().trim();
		return name;
	}

	private Element getUnit(String name) {
		if (document == null)
			return null;
		List<Element> elements = document.getRootElement().elements();
		for (Element element : elements) {
			Attribute attribute = element.attribute("name");
			if (attribute.getText() != null && attribute.getText().equals(name)) {
				return element;
			}
			log.trace(attribute.getText());
		}
		return null;
	}

	Map<String, String> getProperties(String name) {
		if (document == null)
			return null;
		Element unit = getUnit(name);
		Element properties = unit.element("properties");
		if (properties == null)
			return null;
		List<Element> elements = properties.elements();
		Map<String, String> map = new HashMap<String, String>();
		for (Element element : elements) {
			String k = element.attribute("name").getText();
			String v = element.attribute("value").getText();
			map.put(k, v);
		}
		return map;
	}

}