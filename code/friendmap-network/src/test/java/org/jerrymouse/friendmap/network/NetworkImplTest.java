package org.jerrymouse.friendmap.network;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

public class NetworkImplTest {
	Network network;
	private Log log = LogFactory.getLog(NetworkImplTest.class);

	@Before
	public void setup() {
		NetworkConfig networkConfig = new NetworkConfig();
		networkConfig.setInGFW(false);
		network = new NetworkImpl(networkConfig);
	}

	@Test
	public void testGetForward() throws URISyntaxException {
		URI uri = new URI("http://www.google.cn");
		String content = network.get(uri);
		log.trace(content);
		assertNotNull(content);
	}

	@Test
	public void testGetHttps() throws URISyntaxException {
		URI uri = new URI("https://www.google.com/profiles/KaiYanNju#buzz");
		String content = network.get(uri);
		log.trace(content);
		assertNotNull(content);
	}

}
