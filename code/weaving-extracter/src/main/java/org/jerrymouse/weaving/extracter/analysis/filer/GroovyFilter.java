package org.jerrymouse.weaving.extracter.analysis.filer;

import org.jerrymouse.weaving.eye.Eye;
import org.jerrymouse.weaving.model.Website;

public class GroovyFilter implements Filter {
	String analysisScript;
	private boolean ensure;
	/**
	 * like contain: like regx:
	 */
	private String matchRegulator;
	private static String contain = "contain:";
	private static String regex = "regex:";
	private Eye eye;

	public void setEye(Eye eye) {
		this.eye = eye;
	}

	@Override
	public void analysis(Website website) {

	}

	@Override
	public boolean isEnsure() {
		return false;
	}

	@Override
	public boolean match(String url) {
		String m = null;
		if (matchRegulator.startsWith(contain)) {
			m = matchRegulator.substring(contain.length());
			return url.contains(m.trim());
		} else if (matchRegulator.startsWith(regex))
			m = matchRegulator.substring(regex.length());
		return url.matches(m);
	}
}
