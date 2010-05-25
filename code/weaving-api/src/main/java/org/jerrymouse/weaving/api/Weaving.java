package org.jerrymouse.weaving.api;

import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.digger.Digger;
import org.jerrymouse.weaving.extracter.Extracter;
import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Website;
import org.springframework.stereotype.Component;

@Component
public class Weaving {
	@Resource
	private Digger digger;
	@Resource
	private Extracter extracter;

	public List<Person> digPerson(String resource) {
		return digger.dig(resource);
	}

	public Website extractWebsite(String url) {
		return extracter.extract(url);
	}

}
