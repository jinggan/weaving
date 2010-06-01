package org.jerrymouse.weaving.developTool.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jerrymouse.weaving.extracter.analysis.filer.groovy.GroovyFilterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-develop-tool-web.xml",
		"classpath:spring-eye.xml", "classpath:spring-extracter.xml" })
public class DebugControllerTest {
	@Resource
	private DebugController debugController;
	private Log log = LogFactory.getLog(DebugControllerTest.class);

	@Test
	public void testDebug() throws IOException {
		ModelMap map = new ModelMap();
		String script = IOUtils.toString(getConfigInputStream(classpath
				+ "META-INF/scripts/doubanProfile.groovy"));
		debugController.debug("http://www.douban.com/people/yankay/", script,
				map);
		log.trace(map);
	}

	private static String classpath = "classpath:";

	private InputStream getConfigInputStream(String path) {
		InputStream inputStream = null;
		if (path.startsWith(classpath)) {
			path = path.substring(classpath.length());
			inputStream = GroovyFilterRepository.class.getClassLoader()
					.getResourceAsStream(path);
		} else {
			try {
				inputStream = new FileInputStream(new File(path));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return inputStream;
	}
}
