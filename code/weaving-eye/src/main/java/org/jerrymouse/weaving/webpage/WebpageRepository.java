package org.jerrymouse.weaving.webpage;

import java.net.URI;

public interface WebpageRepository {

	String get(URI url);

	void put(URI url, String webContent);

}
