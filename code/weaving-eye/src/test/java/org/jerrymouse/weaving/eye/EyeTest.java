package org.jerrymouse.weaving.eye;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
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
		"classpath:spring-eye-test.xml" })
public class EyeTest {
	@Resource
	private Eye eye;
	private static Log log = LogFactory.getLog(EyeTest.class);

	@Test
	public void testGet() throws URISyntaxException, MalformedURLException {
		log.trace("begin");
		String content = eye.see(new URL("http://yankay.com"));
		log.trace(content);
		String content2 = eye.see(new URL("http://yankay.com"));
		log.trace(content2);
	}
}
