package org.jerrymouse.weaving.digger.plan;

import java.util.ArrayList;
import java.util.List;

import org.jerrymouse.weaving.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonValidater {
	public List<Person> validate(Person person) {
		List<Person> persons = new ArrayList<Person>();
		persons.add(person);
		return persons;
	}

	public	List<Person> validate(List<Person> persons) {
		return persons;
	}

	
}
