package org.jerrymouse.friendmap.network;

import java.util.List;

public class NetworkConfig {
	private boolean isInGFW = false;
	private List<String> gfwList;
	public boolean isInGFW() {
		return isInGFW;
	}
	public void setInGFW(boolean isInGFW) {
		this.isInGFW = isInGFW;
	}
	public List<String> getGfwList() {
		return gfwList;
	}
	public void setGfwList(List<String> gfwList) {
		this.gfwList = gfwList;
	}
}
