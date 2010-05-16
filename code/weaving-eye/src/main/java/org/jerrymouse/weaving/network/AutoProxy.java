package org.jerrymouse.weaving.network;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.Proxy.Type;
import java.util.List;

public class AutoProxy {
	private boolean inGFW;
	private List<String> list;
	private Proxy proxy;
	private String proxyHost;
	private int proxyport;

	public Proxy getProxy() {
		if (proxy == null) {
			proxy.type();
			proxy = new Proxy(Type.SOCKS, new InetSocketAddress(
					proxyHost, proxyport));
		}
		return proxy;
	}

	public void setInGFW(boolean inGFW) {
		this.inGFW = inGFW;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public void setProxyport(int proxyport) {
		this.proxyport = proxyport;
	}

	public boolean shouldFuck(URL url) {
		if (!inGFW)
			return false;
		for (String block : list) {
			if (url.toString().contains(block))
				return true;
		}
		return false;
	}

}
