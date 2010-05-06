package org.jerrymouse.friendmap.network;

public class NetworkFactory {
	private NetworkConfig networkConfig;

	public void setNetworkConfig(NetworkConfig networkConfig) {
		this.networkConfig = networkConfig;
	}

	public Network getNetWork() {
		Network network=new NetworkImpl(networkConfig);
		return network;
	}

	public NetworkConfig getNetworkConfig() {
		if (networkConfig == null)
			networkConfig = new NetworkConfig();
		return networkConfig;
	}
}
