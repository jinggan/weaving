package org.jerrymouse.weaving.eye;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jerrymouse.jsa4j.db.kv.DB;
import org.jerrymouse.jsa4j.db.kv.DBManagerFactory;
import org.jerrymouse.weaving.network.Network;
import org.jerrymouse.weaving.network.NetworkFactory;
import org.jerrymouse.weaving.webpage.WebpageRepository;
import org.jerrymouse.weaving.webpage.WebpageRepositoryFactory;
import org.junit.Before;
import org.junit.Test;

public class EyeImplTest {
	private Eye eye;
	Log log = LogFactory.getLog(EyeImplTest.class);

	@Before
	public void setUp() throws Exception {
		DB db = new DBManagerFactory().getDBManager(DBManagerFactory.DERBY)
				.getDB();
		WebpageRepository repository = new WebpageRepositoryFactory()
				.getWebpageRepository(db);
		Network network = new NetworkFactory().getNetWork();
		EyeFactory eyeFactory = new EyeFactory();
		eyeFactory.setNetwork(network);
		eyeFactory.setWebpageRepository(repository);
		eye = eyeFactory.getEye();
	}

	@Test
	public void testGet() throws URISyntaxException {
		log.trace("begin");
		String content = eye.see(new URI("http://yankay.com"));
		log.trace(content);
		String content2 = eye.see(new URI("http://yankay.com"));
		log.trace(content2);
	}
}
