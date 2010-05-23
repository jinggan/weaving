package org.jerrymouse.weaving.eye;

import java.net.URL;

import javax.annotation.Resource;

import org.jerrymouse.weaving.network.Network;
import org.jerrymouse.weaving.webpage.WebpageRepository;
import org.springframework.stereotype.Component;

@Component
public class Eye {
	@Resource
	Network network;
	@Resource
	WebpageRepository webpageRepository;

	public String see(URL url) {
		String webContent = webpageRepository.get(url);
		if ("null".equals(webContent))
			return null;
		if (webContent == null) {
			webContent = network.get(url);
			webpageRepository.put(url, webContent);
		}
		return webContent;
	}

	public String seeLastest(URL url) {
		String webContent = network.get(url);
		if (webContent == null)
			return null;
		webpageRepository.put(url, webContent);
		return webContent;
	}

}
