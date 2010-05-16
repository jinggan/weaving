package org.jerrymouse.weaving.extracter.analysis.filer.utils;

import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class StringUtils {
	private static Log log = LogFactory.getLog(StringUtils.class);
	public static String CONTAIN = "contain:";
	public static String REGEX = "regex:";

	/**
	 *只能支持一个变量<br/>
	 * mode like http://www.douban.com/people/{username}/
	 * 
	 * @param url
	 * @param mode
	 * @return
	 */
	public String urlParser(String url, String pattern) {
		int i0 = pattern.indexOf('{');
		int i1 = pattern.indexOf('}');
		String left = pattern.substring(i1 + 1);
		String regex = pattern.substring(0, i0) + "[^/]*" + left;
		Scanner scanner = new Scanner(url);
		String result = scanner.findInLine(regex);
		if (result == null)
			return null;
		result = result.substring(i0);
		result = result.substring(0, result.length() - left.length());
		return result;
	}

	public boolean match(String url, String pattern) {
		String m = null;
		if (url.startsWith(REGEX)) {
			m = url.substring(REGEX.length());
			return url.matches(m);
		} else if (url.startsWith(CONTAIN)) {
			m = url.substring(CONTAIN.length());
			return url.contains(m.trim());
		} else {
			return url.contains(pattern.trim());
		}

	}

}
