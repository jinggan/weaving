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
		NetworkConfigFactory networkConfigFactory = new NetworkConfigFactory();
		this.networkConfig = networkConfigFactory.getNetworkConfig();
	}

	public NetworkFactory(String configPath) {
		super();
		NetworkConfigFactory networkConfigFactory = new NetworkConfigFactory();
		if (configPath != null) {
			networkConfigFactory.setConfigPath(configPath);
		}
		this.networkConfig = networkConfigFactory.getNetworkConfig();
	}

	public Network getNetWork() {
		Network network = new NetworkImpl(networkConfig);
		return network;
	}

}
