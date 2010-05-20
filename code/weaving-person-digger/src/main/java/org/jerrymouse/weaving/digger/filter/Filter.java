package org.jerrymouse.weaving.digger.filter;

import org.jerrymouse.weaving.model.Person;

public interface Filter {
	void dig(Person person);

	boolean needRepeat();
}
