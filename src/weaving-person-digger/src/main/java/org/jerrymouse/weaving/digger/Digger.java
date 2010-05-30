package org.jerrymouse.weaving.digger;

import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.digger.plan.DigPlan;
import org.jerrymouse.weaving.digger.plan.PersonGetter;
import org.jerrymouse.weaving.digger.plan.PlanManager;
import org.jerrymouse.weaving.model.analysis.AnalysisePerson;
import org.jerrymouse.weaving.website.repo.PersonCache;
import org.jerrymouse.weaving.website.repo.PersonRepository;
import org.jerrymouse.weaving.website.repo.model.PersonEntity;
import org.springframework.stereotype.Component;

/**
 * 支持google douban facebook 和 twitter
 * 
 * @author yankai
 * 
 */
@Component
public class Digger {

	@Resource
	private PlanManager planManager;
	@Resource
	private PersonRepository personRepository;
	@Resource
	private PersonGetter personGetter;
	@Resource
	private PersonCache personCache;

	public List<AnalysisePerson> dig(String query) {
		if (personCache.gets(query) != null)
			return personCache.gets(query);
		DigPlan plan = planManager.createPlan(query);
		List<AnalysisePerson> persons = plan.execute();
		personCache.puts(query, persons);
		return persons;
	}

	public AnalysisePerson get(String id) {
		if (personCache.get(id) != null)
			return personCache.get(id);
		PersonEntity personEntity = personRepository.get(id);
		AnalysisePerson analysisePerson = personGetter.get(personEntity);
		personCache.put(id, analysisePerson);
		return analysisePerson;
	}

}
