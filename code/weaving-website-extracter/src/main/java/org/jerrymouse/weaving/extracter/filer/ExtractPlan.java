package org.jerrymouse.weaving.extracter.filer;

import java.util.ArrayList;
import java.util.List;

import org.jerrymouse.weaving.model.Website;

public class ExtractPlan {
	private List<ExtractFilter> extractFilters;

	public void execute(Website website) {
		for (ExtractFilter extractFilter : getExtractFilters()) {
			try {
				extractFilter.analysis(website);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void add(ExtractFilter extractFilter) {
		getExtractFilters().add(extractFilter);
	}

	public List<ExtractFilter> getExtractFilters() {
		if (extractFilters == null)
			extractFilters = new ArrayList<ExtractFilter>();
		return extractFilters;
	}

}
