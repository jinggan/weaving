package org.jerrymouse.weaving.digger.plan;

import javax.annotation.Resource;

import org.jerrymouse.weaving.extracter.Extracter;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.model.analysis.AnalysisePerson;
import org.jerrymouse.weaving.website.repo.model.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonGetter {
	@Resource
	private Extracter extracter;

	public AnalysisePerson get(PersonEntity personEntity) {
		AnalysisePerson analysisePerson = AnalysisePerson.getInstance();
		analysisePerson.setKey(personEntity.getKey());
		for (String url : personEntity.getWebsiteUrls()) {
			Website website = extracter.extract(url);
			analysisePerson.getWebsites().add(website);
		}
		return analysisePerson;
	}

}
