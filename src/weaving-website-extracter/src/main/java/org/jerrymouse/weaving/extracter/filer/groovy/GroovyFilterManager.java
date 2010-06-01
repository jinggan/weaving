package org.jerrymouse.weaving.extracter.filer.groovy;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jerrymouse.weaving.extracter.utils.DomUtils;
import org.jerrymouse.weaving.extracter.utils.StringUtils;
import org.jerrymouse.weaving.eye.Eye;
import org.springframework.stereotype.Component;

@Component
public class GroovyFilterManager {
	@Resource
	private GroovyFilterRepository filterRepository;
	@Resource
	private Eye eye;
	ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
	@Resource
	private DomUtils domUtils;
	@Resource
	private StringUtils stringUtils;
	private static Log log = LogFactory.getLog(GroovyFilterManager.class);
	List<GroovyFilter> groovyFilters;

	public List<GroovyFilter> getGroovyFilters() {
		if (filterRepository.cache == null)
			groovyFilters = null;
		if (groovyFilters == null) {
			groovyFilters = new ArrayList<GroovyFilter>();
			for (String name : filterRepository.getScripts().keySet()) {
				groovyFilters.add(getGroovyFilter(name));
			}
		}
		return groovyFilters;
	}

	public GroovyFilter getGroovyFilter(String name) {
		return getGroovyFilterByScript(filterRepository.getScripts().get(name));
	}

	public GroovyFilter getGroovyFilterByScript(String script) {
		GroovyFilter filter = null;
		try {
			filter = new GroovyFilter();
			ScriptEngine engine = scriptEngineManager.getEngineByName("groovy");
			engine.put("eye", eye);
			engine.put("domUtils", domUtils);
			engine.put("stringUtils", stringUtils);
			engine.eval(script);
			filter.setEngine(engine);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return filter;
	}
}
