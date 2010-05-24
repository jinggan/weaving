package org.jerrymouse.weaving.digger.plan;

import javax.annotation.Resource;

import org.jerrymouse.weaving.digger.filter.DigFilterManager;
import org.jerrymouse.weaving.extracter.Extracter;
import org.jerrymouse.weaving.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PlanManager {
	@Resource
	private DigFilterManager digFilterManager;
	@Resource
	private Extracter extracter;

	public DigPlan createPlan(Person person) {
		DigPlan digPlan = new DigPlan();
		digPlan.setDigFilterManager(digFilterManager);
		digPlan.setExtracter(extracter);
		digPlan.setPerson(person);
		return digPlan;
	}

}
