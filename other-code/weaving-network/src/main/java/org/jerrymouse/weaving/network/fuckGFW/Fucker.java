package org.jerrymouse.weaving.network.fuckGFW;

import java.net.Proxy;
import java.net.URI;

public class Fucker {
	private GFWList gfwList;
	private boolean isInGFW;

	public void setGfwList(GFWList gfwList) {
		this.gfwList = gfwList;
	}

	public void setInGFW(boolean isInGFW) {
		this.isInGFW = isInGFW;
	}

	public Proxy getProxy(URI url) {
		if (isInGFW && gfwList.shouldFuck(url))
			return getSocketProxy();
		return null;
	}

	public Proxy getSocketProxy() {
		return null;
	}

}
