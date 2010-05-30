package org.jerrymouse.weaving.digger.plan;

import java.util.ArrayList;
import java.util.List;

import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.analysis.AnalysisePerson;
import org.springframework.stereotype.Component;

@Component
public class PersonValidater {
	public List<AnalysisePerson> validate(AnalysisePerson person) {
		List<AnalysisePerson> persons = new ArrayList<AnalysisePerson>();
		persons.add(person);
		return persons;
	}

	public List<Person> validate(List<Person> persons) {
		return persons;
	}

}
