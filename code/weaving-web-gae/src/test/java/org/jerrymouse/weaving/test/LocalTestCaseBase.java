package org.jerrymouse.weaving.test;

import org.junit.After;
import org.junit.Before;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalImagesServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalMemcacheServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public abstract class LocalTestCaseBase extends TestCaseBase {

	private LocalServiceTestHelper helper;

	@Before
	public void setUp() {
		helper = new LocalServiceTestHelper(
				new LocalMemcacheServiceTestConfig(),
				new LocalDatastoreServiceTestConfig(),
				new LocalImagesServiceTestConfig());
		helper.setUp();
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

}