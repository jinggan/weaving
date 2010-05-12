package org.jerrymouse.weaving.extracter.analysis.filer;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.jerrymouse.weaving.extracter.analysis.filer.analysis.DomUtils;
import org.jerrymouse.weaving.extracter.analysis.filer.analysis.StringUtils;
import org.jerrymouse.weaving.eye.Eye;
import org.jerrymouse.weaving.model.Website;

public class GroovyFilter implements Filter {

	private String script;

	public void setScript(String script) {
		this.script = script;
	}

	@Override
	public void analysis(Website webSite) {

	}

	@Override
	public boolean isEnsure() {
		Boolean result = null;
		try {
			result = (Boolean) ((Invocable) engine).invokeFunction("isEnsure");
		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean match(String url) {
		return false;
	}

	public void setDomUtils(DomUtils domUtils) {
		engine.put("domUtils", domUtils);
	}

	private ScriptEngine engine;

	/**
	 * 新的
	 * 
	 * @param engine
	 */
	public void setEngine(ScriptEngine engine) {
		this.engine = engine;
	}

	public void setEye(Eye eye) {
		engine.put("eye", eye);
	}

	public void setStringUtils(StringUtils stringUtils) {
		engine.put("stringUtils", stringUtils);
	}

}
