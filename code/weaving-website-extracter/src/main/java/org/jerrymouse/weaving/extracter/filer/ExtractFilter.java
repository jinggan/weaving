package org.jerrymouse.weaving.extracter.filer;

import org.jerrymouse.weaving.model.Website;

public interface ExtractFilter {
	boolean match(Website website);

	/**
	 * needCommonExtract?
	 * 
	 * @return
	 */
	boolean isEnsure();;

	void analysis(Website webSite);

}
