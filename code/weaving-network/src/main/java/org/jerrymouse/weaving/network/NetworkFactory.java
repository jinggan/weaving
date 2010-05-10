package org.jerrymouse.weaving.network;

public class NetworkFactory {
	private NetworkConfig networkConfig;

	public void setNetworkConfig(NetworkConfig networkConfig) {
		this.networkConfig = networkConfig;
	}

	public NetworkFactory(NetworkConfig networkConfig) {
		super();
		this.networkConfig = networkConfig;
	}

	public NetworkFactory() {
		super();
	}

	public Network getNetWork() {
		Network network = new NetworkImpl(getNetworkConfig());
		return network;
	}

	public NetworkConfig getNetworkConfig() {
		if (networkConfig == null) {
			networkConfig = new NetworkConfig();
			networkConfig.setInGFW(false);
		}
		return networkConfig;
	}

}
