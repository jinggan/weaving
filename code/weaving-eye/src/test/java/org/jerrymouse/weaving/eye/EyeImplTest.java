package org.jerrymouse.weaving.eye;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jerrymouse.jsa4j.db.kv.DB;
import org.jerrymouse.jsa4j.db.kv.DBManagerFactory;
import org.jerrymouse.weaving.network.Network;
import org.jerrymouse.weaving.network.NetworkFactory;
import org.jerrymouse.weaving.webpage.WebpageRepository;
import org.jerrymouse.weaving.webpage.WebpageRepositoryFactory;
import org.jerrymouse.weaving.webpage.WebpageRepositoryImplTest;
import org.junit.Before;
import org.junit.Test;

public class EyeImplTest {
	private Eye eye;
	Log log = LogFactory.getLog(WebpageRepositoryImplTest.class);

	@Before
	public void setUp() throws Exception {
		DB db = new DBManagerFactory().getDBManager(DBManagerFactory.DERBY)
				.getDB();
		WebpageRepository repository = new WebpageRepositoryFactory()
				.getWebpageRepository(db);
		Network network=new NetworkFactory().getNetWork();
	}

	@Test
	public void testGet() {
	}

}
