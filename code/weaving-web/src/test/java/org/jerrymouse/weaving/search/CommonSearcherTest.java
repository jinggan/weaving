package org.jerrymouse.weaving.search;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.jerrymouse.weaving.model.Person;
import org.jerrymouse.weaving.test.TestCaseBase;
import org.junit.Before;
import org.junit.Test;

public class CommonSearcherTest extends TestCaseBase {
	@Resource
	private CommonSearcher commonSearcher;

	@Test
	public void testSearch() {
		List<Person> persons = commonSearcher.search("kaiyannju@gmail.com");
		log.trace(persons);
	}

}
