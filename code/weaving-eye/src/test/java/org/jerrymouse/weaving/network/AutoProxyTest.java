package org.jerrymouse.weaving.network;

import java.net.URL;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-eye.xml",
		"classpath:spring-eye-test.xml" })public class AutoProxyTest {
	@Resource
	private AutoProxy gfwList;

	private static Log log = LogFactory.getLog(AutoProxy.class);

	@Test
	public void testInit() throws Exception {
		log.trace(gfwList.shouldFuck(new URL("http://www.twitter.com")));
	}
}
