package org.jerrymouse.weaving.digger;

import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.digger.plan.DigPlan;
import org.jerrymouse.weaving.digger.plan.PlanManager;
import org.jerrymouse.weaving.model.Person;
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

	public List<Person> dig(String query) {
		DigPlan plan = planManager.createPlan(query);
		List<Person> persons = plan.execute();
		return persons;
	}

	

}
