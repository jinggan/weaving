package org.jerrymouse.weaving.digger.plan;

import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.digger.filter.privider.GoogleSocialGraphFilter;
import org.jerrymouse.weaving.digger.filter.privider.UserNameFilter;
import org.jerrymouse.weaving.extracter.Extracter;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.model.analysis.AnalysisePerson;
import org.jerrymouse.weaving.website.repo.PersonRepository;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Component
public class DigPlan {

	private AnalysisePerson person;
	@Resource
	private GoogleSocialGraphFilter googleSocialGraphFilter;

	@Resource
	private UserNameFilter userNameFilter;
	@Resource
	private Extracter extracter;
	@Resource
	private PersonValidater personValidater;
	@Resource
	private PersonRepository personRepository;

	public void setPerson(AnalysisePerson person) {
		this.person = person;
	}

	public List<AnalysisePerson> execute() {
		userNameFilter.dig(person);
		// dbFilter.dig(person);
		googleSocialGraphFilter.dig(person);
		for (Website w : person) {
			extracter.extract(w);
		}
		List<AnalysisePerson> analysisePersons = personValidater
				.validate(person);
		put(analysisePersons);
		return analysisePersons;
	}

	private void put(List<AnalysisePerson> analysisePersons) {
		for (AnalysisePerson analysisePerson : analysisePersons) {
			personRepository.put(analysisePerson);
		}
	}

	// private void mkKey(AnalysisePerson analysisePerson) {
	// if (analysisePerson.getKey() == null) {
	// for (Website website : analysisePerson) {
	// if(website.getProfile().getUsername()!=null)
	// analysisePerson.setKey(key);
	// }
	// }
	// }
}
