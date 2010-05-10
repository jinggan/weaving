package org.jerrymouse.weaving.eye;

import java.net.URI;

import org.jerrymouse.weaving.network.Network;
import org.jerrymouse.weaving.webpage.WebpageRepository;

public class EyeImpl implements Eye {
	Network network;
	WebpageRepository webpageRepository;

	@Override
	public String get(URI url) {
		String webContent = webpageRepository.get(url);
		if (webContent == null) {
			webContent = network.get(url);
			if (webContent == null)
				return null;
			webpageRepository.put(url, webContent);
		}
		return webContent;
	}

	public void setNetwork(Network network) {
		this.network = network;
	}

	public void setWebpageRepository(WebpageRepository webpageRepository) {
		this.webpageRepository = webpageRepository;
	}

	@Override
	public String getLastest(URI url) {
		String webContent = network.get(url);
		if (webContent == null)
			return null;
		webpageRepository.put(url, webContent);
		return webContent;
	}

}
