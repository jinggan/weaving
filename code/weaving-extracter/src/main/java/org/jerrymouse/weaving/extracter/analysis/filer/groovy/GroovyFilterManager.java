package org.jerrymouse.weaving.extracter.analysis.filer.groovy;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jerrymouse.weaving.extracter.analysis.filer.utils.DomUtils;
import org.jerrymouse.weaving.extracter.analysis.filer.utils.StringUtils;
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

	public List<GroovyFilter> getGroovyFilters() {
		List<GroovyFilter> groovyFilters = new ArrayList<GroovyFilter>();
		for (String name : filterRepository.getScripts().keySet()) {
			groovyFilters.add(getGroovyFilter(name));
		}
		return groovyFilters;
	}

	public GroovyFilter getGroovyFilter(String name) {
		GroovyFilter filter = null;
		try {
			filter = new GroovyFilter();
			String script = filterRepository.getScripts().get(name);
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
