package org.jerrymouse.weaving.eye;

import org.jerrymouse.weaving.network.Network;
import org.jerrymouse.weaving.webpage.WebpageRepository;

public class EyeFactory {
	Network network;
	WebpageRepository webpageRepository;

	public EyeFactory() {
	}

	public void setNetwork(Network network) {
		this.network = network;
	}

	public void setWebpageRepository(WebpageRepository webpageRepository) {
		this.webpageRepository = webpageRepository;
	}

	public Eye getEye(Network network, WebpageRepository webpageRepository) {
		this.network = network;
		this.webpageRepository = webpageRepository;
		return getEye();
	}

	public Eye getEye() {
		EyeImpl eye = new EyeImpl();
		eye.setNetwork(network);
		eye.setWebpageRepository(webpageRepository);
		return eye;
	}

}
