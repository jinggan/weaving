package org.jerrymouse.weaving.network.fuckGFW;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class NetworkConfigXml {
	private static Log log = LogFactory.getLog(NetworkConfigXml.class);

	private Document document;

	NetworkConfigXml(String xmlPath) {
		try {
			InputStream in = null;
			try {
				in = NetworkConfigXml.class.getClassLoader()
						.getResourceAsStream(xmlPath);
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

	@SuppressWarnings("unchecked")
	public List<String> getGfwList() {
		if (document == null)
			return null;
		Element unit = document.getRootElement().element("GFW-list");
		List<Element> elements = unit.elements("website");
		List<String> list = new ArrayList<String>();
		for (Element e : elements) {
			list.add(e.getText());
		}
		return list;

	}
}