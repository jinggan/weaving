package org.jerrymouse.weaving.network.fuckGFW;

import java.net.Proxy;
import java.net.URI;

import org.jerrymouse.weaving.network.NetworkConfig;

public class Fucker {
	public Proxy getProxy(URI url) {
		if (networkConfig.isInGFW() && shouldFuck(url))
			return getSocketProxy();
		return null;
	}

	private NetworkConfig networkConfig;

	public Fucker(NetworkConfig networkConfig) {
		this.networkConfig = networkConfig;
	}

	public Proxy getSocketProxy() {
		return null;
	}

	public boolean shouldFuck(URI url) {
		for (String block : networkConfig.getGfwList()) {
			if (url.toString().contains(block))
				return true;
		}
		return false;
	}
}
