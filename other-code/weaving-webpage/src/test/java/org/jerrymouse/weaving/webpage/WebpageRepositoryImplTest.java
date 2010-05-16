package org.jerrymouse.weaving.webpage;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jerrymouse.jsa4j.db.kv.DB;
import org.jerrymouse.jsa4j.db.kv.DBManagerFactory;
import org.junit.Before;
import org.junit.Test;

public class WebpageRepositoryImplTest {
	WebpageRepository repository;
	Log log = LogFactory.getLog(WebpageRepositoryImplTest.class);

	@Before
	public void setUp() throws Exception {
		DB db = new DBManagerFactory().getDBManager(DBManagerFactory.DERBY)
				.getDB();
		repository = new WebpageRepositoryFactory().getWebpageRepository(db);
	}

	@Test
	public void testGet() {
		try {
			String content = repository.get(new URI("http://www.google.com"));
			log.trace(content);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPut() {
		try {
			repository.put(new URI("http://www.google.com"), "good");
			String content = repository.get(new URI("http://www.google.com"));
			log.trace(content);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
