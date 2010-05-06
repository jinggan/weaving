package org.jerrymouse.friendmap.network;

import java.net.URI;

public interface Network {
	/**
	 * get网上的信息，支持HTTP，HTTPS，和翻墙。
	 * 
	 * @param url
	 * @return 内容，如果访问失败则返回null
	 */
	String get(URI url);
}
