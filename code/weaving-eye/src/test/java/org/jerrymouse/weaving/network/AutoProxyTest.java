package org.jerrymouse.weaving.network;

import java.net.URL;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-eye.xml" })
public class AutoProxyTest {
	@Resource
	private AutoProxy gfwList;

	private static Log log = LogFactory.getLog(AutoProxy.class);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInit() throws Exception {
		log.trace(gfwList.shouldFuck(new URL("http://www.twitter.com")));
	}
}
