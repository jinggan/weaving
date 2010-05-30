package org.jerrymouse.weaving.webpage;

import java.net.MalformedURLException;
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
public class WebpageRepositoryTest {
	@Resource
	private WebpageRepository webpageRepository;

	private static Log log = LogFactory.getLog(WebpageRepositoryTest.class);

	@Test
	public void testPut() throws MalformedURLException {
		webpageRepository.put(new URL("http://www.97sese.com"), "97sese");
		String content = webpageRepository
				.get(new URL("http://www.97sese.com"));
		log.trace(content);
	}
}
