package org.jerrymouse.weaving.extracter.filer;

import org.jerrymouse.weaving.model.Website;

public interface ExtractFilter {
	boolean match(String url);

	boolean isEnsure();;

	void analysis(Website webSite);

}
