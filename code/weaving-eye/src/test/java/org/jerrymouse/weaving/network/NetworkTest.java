package org.jerrymouse.weaving.network;

import static org.junit.Assert.assertNotNull;

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
@ContextConfiguration(locations = { "classpath:spring-eye.xml" })
public class NetworkTest {
	@Resource
	Network network;
	private static Log log = LogFactory.getLog(NetworkTest.class);

	// @Before
	// public void setup() {
	// network = new NetworkFactory().getNetWork();
	// }
	//
	// @Test
	// public void testGetForward() throws URISyntaxException {
	// URI uri = new URI("http://www.google.com");
	// log.trace(uri.toString());
	// String content = network.get(uri);
	// log.trace(content);
	// assertNotNull(content);
	// }

	@Test
	public void testGetHttps() throws URISyntaxException, MalformedURLException {
		URL uri = new URL("https://www.google.com/profiles/KaiYanNju#buzz");
		String content = network.get(uri);
		log.trace(content);
		assertNotNull(content);
	}

}
