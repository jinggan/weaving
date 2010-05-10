package org.jerrymouse.weaving.extracter.analysis.filer.douban;

import org.jerrymouse.weaving.extracter.analysis.filer.Filter;
import org.jerrymouse.weaving.model.Website;

public class DoubanProfileFilter implements Filter {

	@Override
	public void analysis(Website website) {

	}

	@Override
	public boolean isEnsure() {
		return true;
	}

	@Override
	public boolean match(String url) {
		if (url.contains("http://www.douban.com/people/"))
			return true;
		return false;
	}

}
