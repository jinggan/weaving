package org.jerrymouse.weaving.extracter.filer.java;

import org.jerrymouse.weaving.extracter.filer.ExtractFilter;
import org.jerrymouse.weaving.model.Website;
import org.springframework.stereotype.Component;

@Component
public class CommonProfileFilter implements ExtractFilter {

	@Override
	public void analysis(Website webSite) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEnsure() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean match(Website url) {
		// TODO Auto-generated method stub
		return false;
	}

}
