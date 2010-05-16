package org.jerrymouse.weaving.extracter.analysis.filer.groovy;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.jerrymouse.weaving.test.TestCaseBase;
import org.junit.Before;
import org.junit.Test;

public class GroovyFilterManagerTest extends TestCaseBase {
	@Resource
	private GroovyFilterManager filterManager;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGet() throws Exception {
		GroovyFilter groovyFilter = filterManager
				.getGroovyFilter("doubanProfile");
		log.trace(groovyFilter);
	}
}
