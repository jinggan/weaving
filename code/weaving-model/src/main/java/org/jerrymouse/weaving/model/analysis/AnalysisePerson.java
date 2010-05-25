package org.jerrymouse.weaving.model.analysis;

import java.util.ArrayList;

import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.model.base.AbstractPerson;

public class AnalysisePerson extends AbstractPerson {
	private AnalysisePerson() {
	}

	public static AnalysisePerson getInstance() {
		AnalysisePerson analysisePerson = new AnalysisePerson();
		analysisePerson.setWebsites(new ArrayList<Website>());
		return analysisePerson;
	}
}
