package org.jerrymouse.weaving.extracter.analysis.filer.groovy;

import java.util.Map;

import javax.annotation.Resource;

import org.jerrymouse.weaving.extracter.filer.groovy.GroovyFilterRepository;
import org.jerrymouse.weaving.test.TestCaseBase;
import org.junit.Before;
import org.junit.Test;

public class GroovyFilterRepositoryTest extends TestCaseBase {
	@Resource
	private GroovyFilterRepository filterRepository;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGet() throws Exception {
		Map<String, String> map = filterRepository.getScripts();
		log.trace(map);
		map = filterRepository.getScripts();
		log.trace(map);
	}
}
