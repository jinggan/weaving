package org.jerrymouse.weaving.digger;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.jerrymouse.weaving.digger.filter.DigFilterManager;
import org.jerrymouse.weaving.digger.filter.Filter;
import org.jerrymouse.weaving.extracter.Extracter;
import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.model.analysis.AnalysisePerson;
import org.jerrymouse.weaving.model.analysis.AnalysiseProfile;
import org.jerrymouse.weaving.model.analysis.AnalysiseWebsite;
import org.springframework.stereotype.Component;

@Component
public class Digger {
	@Resource
	private DigFilterManager digFilterManager;
	@Resource
	private Extracter extracter;

	public Person dig(String url) {
		Website website = new AnalysiseWebsite();
		website.setProfile(new AnalysiseProfile());
		website.getProfile().setUrl(url);
		Person person = new AnalysisePerson();
		person.setWebsites(new ArrayList<Website>());
		person.getWebsites().add(website);
		for (Filter f : digFilterManager.getFilters()) {
			f.dig(person);
		}
		for (Website w : person) {
			extracter.extract(w);
		}
		return person;
	}

}
