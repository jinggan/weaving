package org.jerrymouse.weaving.extracter.analysis.filer.groovy;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.jerrymouse.weaving.extracter.filer.groovy.GroovyFilter;
import org.jerrymouse.weaving.extracter.filer.groovy.GroovyFilterManager;
import org.jerrymouse.weaving.test.TestCaseBase;
import org.junit.Before;
import org.junit.Test;

public class GroovyFilterManagerTest extends TestCaseBase {
	@Resource
	private GroovyFilterManager groovyFilterManager;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGet() throws Exception {
		GroovyFilter groovyFilter = groovyFilterManager
				.getGroovyFilter("doubanProfile");
		log.trace(groovyFilter);
	}
}
