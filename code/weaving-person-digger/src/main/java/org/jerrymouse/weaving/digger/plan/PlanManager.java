package org.jerrymouse.weaving.digger.plan;

import javax.annotation.Resource;

import org.jerrymouse.weaving.model.analysis.AnalysisePerson;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public class PlanManager implements BeanFactoryAware {

	@Resource
	private QueryAnalysiser queryAnalysiser;

	public DigPlan createPlan(String resource) {
		AnalysisePerson person = queryAnalysiser.analysise(resource);
		DigPlan digPlan = beanFactory.getBean(DigPlan.class);
		digPlan.setPerson(person);
		return digPlan;
	}

	private BeanFactory beanFactory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

}
