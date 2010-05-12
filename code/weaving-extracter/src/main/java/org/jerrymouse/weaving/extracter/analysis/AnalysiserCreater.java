package org.jerrymouse.weaving.extracter.analysis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
import org.jerrymouse.weaving.extracter.analysis.filer.Filter;
import org.jerrymouse.weaving.extracter.analysis.filer.FilterManager;

public class AnalysiserCreater {
	private FilterManager filterManager;
	private String configPath = "META-INF/weaving-extracter.xml";

	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}

	public Analysiser create(String url) {
		List<Filter> filters = new ArrayList<Filter>();
		for (Filter f : getFilterManager().getFilters()) {
			filters.add(f);
		}
		Analysiser analysiser = new Analysiser();
		analysiser.setFilters(filters);
		return analysiser;
	}

	public FilterManager getFilterManager() {
		if (filterManager == null)
			filterManager = new FilterManager();
		return filterManager;
	}

	public void setFilterManager(FilterManager filterManager) {
		this.filterManager = filterManager;
	}
}

/**
 * 解析XML配置文件
 * 
 * @author yankai
 * 
 */
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

	List<String> getSrciptNames() {
		if (document == null)
			return null;
		List<String> list = new ArrayList<String>();

		List<Element> elements = getSrcipts().elements();
		for (Element element : elements) {
			list.add(element.getText());
		}
		return list;
	}

	private Element getSrcipts() {
		if (document == null)
			return null;
		return document.getRootElement().element("scripts");
	}

}