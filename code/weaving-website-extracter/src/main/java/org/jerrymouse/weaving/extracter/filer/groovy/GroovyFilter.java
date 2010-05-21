package org.jerrymouse.weaving.extracter.filer.groovy;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.jerrymouse.weaving.extracter.filer.ExtractFilter;
import org.jerrymouse.weaving.model.Website;

public class GroovyFilter implements ExtractFilter {

	private ScriptEngine engine;

	@Override
	public void analysis(Website webSite) {
		try {
			Invocable inv = (Invocable) engine;
			inv.invokeFunction("analysis", webSite);
		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
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

	public void setEngine(ScriptEngine engine) {
		this.engine = engine;
	}

	@Override
	public boolean match(Website website) {
		Boolean result = null;
		try {
			Invocable inv = (Invocable) engine;
			result = (Boolean) inv.invokeFunction("match", website);
		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return result;
	}

}
