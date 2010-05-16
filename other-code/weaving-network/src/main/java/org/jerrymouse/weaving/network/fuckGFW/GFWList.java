package org.jerrymouse.weaving.network.fuckGFW;

import java.net.URI;
import java.util.List;

public class GFWList {
	private List<String> gfwList;
	private static String defaultConfigPath = "META-INF/weaving-network-default.xml";

	public boolean shouldFuck(URI url) {
		for (String block : gfwList) {
			if (url.toString().contains(block))
				return true;
		}
		return false;
	}

	public void setGfwList(List<String> gfwList) {
		this.gfwList = gfwList;
	}

	public static GFWList read(String configPath) {
		NetworkConfigXml defaultXml = new NetworkConfigXml(defaultConfigPath);
		NetworkConfigXml xml = new NetworkConfigXml(configPath);

		GFWList gfwList = new GFWList();
		gfwList.setGfwList(defaultXml.getGfwList());
		if (xml.getGfwList() != null) {
			gfwList.setGfwList(xml.getGfwList());
		}

		return gfwList;
	}
}
