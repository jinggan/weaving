package org.jerrymouse.weaving.network;

import org.jerrymouse.weaving.network.fuckGFW.Fucker;
import org.jerrymouse.weaving.network.fuckGFW.GFWList;

public class NetworkFactory {
	private String configPath = "META-INF/weaving-network.xml";
	private boolean isInGFW = false;

	public Network getNetWork() {
		NetworkImpl network = new NetworkImpl();
		GFWList gfwList = GFWList.read(configPath);
		Fucker fucker = new Fucker();
		fucker.setInGFW(isInGFW);
		fucker.setGfwList(gfwList);
		network.setFucker(fucker);
		return network;
	}

	public void setInGFW(boolean isInGFW) {
		this.isInGFW = isInGFW;
	}

	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}

}
