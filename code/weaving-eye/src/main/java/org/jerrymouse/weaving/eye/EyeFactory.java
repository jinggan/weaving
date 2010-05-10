package org.jerrymouse.weaving.eye;

import org.jerrymouse.weaving.network.Network;
import org.jerrymouse.weaving.network.NetworkFactory;
import org.jerrymouse.weaving.webpage.WebpageRepository;
import org.jerrymouse.weaving.webpage.WebpageRepositoryFactory;

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

	public Network getNetwork() {
		if (network == null)
			network = new NetworkFactory().getNetWork();
		return network;
	}

	public WebpageRepository getWebpageRepository() {
		if (webpageRepository == null)
			webpageRepository = new WebpageRepositoryFactory()
					.getWebpageRepository();
		return webpageRepository;
	}

	public Eye getEye() {
		EyeImpl eye = new EyeImpl();
		eye.setNetwork(network);
		eye.setWebpageRepository(webpageRepository);
		return eye;
	}

}
