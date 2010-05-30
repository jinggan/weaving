package org.jerrymouse.weaving.digger.filter.privider;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.digger.filter.DigFilter;
import org.jerrymouse.weaving.extracter.Extracter;
import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.model.Website;
import org.jerrymouse.weaving.website.repo.PersonRepository;
import org.jerrymouse.weaving.website.repo.model.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class DBFilter implements DigFilter {
	@Resource
	private PersonRepository personRepository;
	@Resource
	private Extracter extracter;

	@Override
	public void dig(Person person) {
		List<String> list = new ArrayList<String>();
		for (Website website : person) {
			list.add(website.getProfile().getUrl());
		}
		PersonEntity personEntity = null;
		if (list.size() != 0) {
			List<PersonEntity> entities = personRepository.getFromIndex(list
					.get(0));
			if (entities != null && entities.size() != 0)
				personEntity = entities.get(0);
		}
		List<Website> websites = new ArrayList<Website>();
		if (personEntity != null) {
			for (String url : personEntity.getWebsiteUrls()) {
				Website website = extracter.extract(url);
				if (website != null)
					websites.add(website);
			}
		}

	}
}
