package org.jerrymouse.weaving.extracter.analysis.filer;

import org.jerrymouse.weaving.extracter.analysis.filer.analysis.DomUtils;
import org.jerrymouse.weaving.extracter.analysis.filer.analysis.StringUtils;
import org.jerrymouse.weaving.eye.Eye;
import org.jerrymouse.weaving.model.Website;

public interface Filter {
	boolean match(String url);

	boolean isEnsure();;

	void analysis(Website webSite);

	public void setEye(Eye eye);

	public void setDomUtils(DomUtils domUtils);

	public void setStringUtils(StringUtils stringUtils);
}
