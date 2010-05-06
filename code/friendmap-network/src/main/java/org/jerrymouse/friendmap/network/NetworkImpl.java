package org.jerrymouse.friendmap.network;

import java.net.URI;

import org.jerrymouse.friendmap.network.fuckGFW.Fucker;

public class NetworkImpl implements Network {
	private NetworkConfig networkConfig;

	public NetworkImpl(NetworkConfig networkConfig) {
		this.networkConfig = networkConfig;
	}

	@Override
	public String get(URI url) {
		Fucker fucker = new Fucker(networkConfig);
		HTTPReader httpReader = new HTTPReader();
		httpReader.setProxy(fucker.getProxy(url));
		return httpReader.read(url);
	}

}
