package org.jerrymouse.weaving.network;

import java.net.URI;

import org.jerrymouse.weaving.network.fuckGFW.Fucker;

public class NetworkImpl implements Network {
	private Fucker fucker;

	public void setFucker(Fucker fucker) {
		this.fucker = fucker;
	}

	@Override
	public String get(URI url) {
		HTTPReader httpReader = new HTTPReader();
		httpReader.setProxy(fucker.getProxy(url));
		return httpReader.read(url);
	}

}
