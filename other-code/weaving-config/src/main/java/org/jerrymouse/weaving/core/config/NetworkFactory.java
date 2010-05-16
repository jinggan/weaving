package org.jerrymouse.weaving.core.config;

import org.jerrymouse.weaving.network.Network;

public class NetworkFactory {

	public Network getNetwork() {
		return network;
	}

	public void setNetwork(Network network) {
		this.network = network;
	}

	private Network network;

}
