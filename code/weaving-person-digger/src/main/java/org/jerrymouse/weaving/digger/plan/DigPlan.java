package org.jerrymouse.weaving.digger.plan;

import javax.annotation.Resource;

import org.jerrymouse.weaving.digger.filter.DigFilterManager;
import org.jerrymouse.weaving.digger.filter.Filter;
import org.jerrymouse.weaving.extracter.Extracter;
import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Website;

public class DigPlan {
	private Person person;
	private DigFilterManager digFilterManager;
	private Extracter extracter;

	public void setDigFilterManager(DigFilterManager digFilterManager) {
		this.digFilterManager = digFilterManager;
	}

	public void setExtracter(Extracter extracter) {
		this.extracter = extracter;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void execute(DigPlan plan) {
		Person person = plan.getPerson();
		for (Filter f : digFilterManager.getFilters()) {
			f.dig(person);
		}
		for (Website w : person) {
			extracter.extract(w);
		}
	}
}
