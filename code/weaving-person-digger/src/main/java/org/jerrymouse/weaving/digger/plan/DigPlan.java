package org.jerrymouse.weaving.digger.plan;

import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.digger.filter.DigFilterManager;
import org.jerrymouse.weaving.digger.filter.DigFilter;
import org.jerrymouse.weaving.digger.filter.privider.GoogleSocialGraphFilter;
import org.jerrymouse.weaving.digger.filter.privider.UserNameFilter;
import org.jerrymouse.weaving.extracter.Extracter;
import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Website;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Component
public class DigPlan {

	private Person person;
	@Resource
	private GoogleSocialGraphFilter googleSocialGraphFilter;

	@Resource
	private UserNameFilter userNameFilter;
	@Resource
	private Extracter extracter;
	@Resource
	private PersonValidater personValidater;

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Person> execute() {
		userNameFilter.dig(person);
		googleSocialGraphFilter.dig(person);
		for (Website w : person) {
			extracter.extract(w);
		}
		return personValidater.validate(person);
	}
}
