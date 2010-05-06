package org.jerrymouse.friendmap.network.fuckGFW;

import java.net.Proxy;
import java.net.URI;

import org.jerrymouse.friendmap.network.NetworkConfig;

public class Fucker {
	public Proxy getProxy(URI url) {
		if (networkConfig.isInGFW() && shouldFuck())
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

	public boolean shouldFuck() {
		// TODO Auto-generated method stub
		return false;
	}
}
