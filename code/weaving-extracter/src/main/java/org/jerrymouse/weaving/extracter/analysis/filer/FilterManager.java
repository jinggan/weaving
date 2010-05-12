package org.jerrymouse.weaving.extracter.analysis.filer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.jerrymouse.weaving.extracter.analysis.filer.analysis.DomUtils;
import org.jerrymouse.weaving.extracter.analysis.filer.analysis.StringUtils;
import org.jerrymouse.weaving.extracter.analysis.filer.douban.DoubanProfileFilter;
import org.jerrymouse.weaving.eye.Eye;
import org.jerrymouse.weaving.eye.EyeFactory;

public class FilterManager {
	List<Filter> filters;
	private Eye eye;
	ScriptEngineManager factory = new ScriptEngineManager();


	public ScriptEngine newEngine() {
		return factory.getEngineByName("groovy");
	}

	public void setEye(Eye eye) {
		this.eye = eye;
	}

	public Eye getEye() {
		if (eye == null)
			eye = new EyeFactory().getEye();
		return eye;
	}

	private void init() {
		filters = new ArrayList<Filter>();

		// Filter filter = fillResource(new DoubanProfileFilter(), getEye());
		List<String> scripts = getScripts();
		for (String script : scripts) {
			GroovyFilter groovyFilter = new GroovyFilter();
			groovyFilter.setEngine(newEngine());
			groovyFilter.setScript(script);
			fillResource(groovyFilter, getEye());
			filters.add(groovyFilter);
		}
	}

	private List<String> getScripts() {
		
		return null;
	}

	public List<Filter> getFilters() {
		if (filters == null)
			init();
		return filters;
	}

	private Filter fillResource(Filter filter, Eye eye) {
		filter.setEye(eye);
		filter.setDomUtils(getDomUtils());
		filter.setStringUtils(getStringUtils());
		return filter;
	}

	public DomUtils getDomUtils() {
		if (domUtils == null)
			domUtils = new DomUtils();
		return domUtils;
	}

	private DomUtils domUtils;
	private StringUtils stringUtils;

	public StringUtils getStringUtils() {
		if (stringUtils == null)
			stringUtils = new StringUtils();
		return stringUtils;
	}

	public void setStringUtils(StringUtils stringUtils) {
		this.stringUtils = stringUtils;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	public void setDomUtils(DomUtils domUtils) {
		this.domUtils = domUtils;
	}

}
