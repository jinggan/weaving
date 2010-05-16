package org.jerrymouse.weaving.extracter.analysis.filer;

import org.jerrymouse.weaving.extracter.analysis.model.AnalysiseWebsite;
import org.jerrymouse.weaving.model.Website;

public interface Filter {
	boolean match(String url);

	boolean isEnsure();;

	void analysis(Website webSite);

}
