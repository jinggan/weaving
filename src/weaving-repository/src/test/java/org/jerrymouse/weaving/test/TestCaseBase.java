package org.jerrymouse.weaving.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-repository-test.xml",
		"classpath:spring-repository.xml" })
public abstract class TestCaseBase {
	protected Log log = LogFactory.getLog(getClass());
}