package org.jerrymouse.weaving.api;

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

	public Person digPerson(String url) {
		return digger.dig(url);
	}

	public Website extractWebsite(String url) {
		return extracter.extract(url);
	}

}
