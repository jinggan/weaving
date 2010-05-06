package org.jerrymouse.weaving.network;

public class NetworkConfigFactory {
	/**
	 * 默认为：“META-INF/weaving-network.xml“
	 */
	private String configPath = "META-INF/weaving-network.xml";

	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}

	public String getConfigPath() {
		return configPath;
	}

	public NetworkConfig getNetworkConfig() {
		return null;
	}
}
