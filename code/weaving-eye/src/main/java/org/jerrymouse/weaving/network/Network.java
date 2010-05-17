package org.jerrymouse.weaving.network;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

@Component
public class Network {
	@Resource(name = "autoProxy")
	private AutoProxy autoProxy;

	public String get(URL url) {
		HttpURLConnection connection = null;
		String content = null;
		try {
			if (autoProxy.shouldFuck(url)) {
				connection = (HttpURLConnection) url.openConnection(autoProxy
						.getProxy());
			} else {
				connection = (HttpURLConnection) url.openConnection();
			}
			content = read(url, connection);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.disconnect();
		}
		return content;
	}

	private String read(URL url, HttpURLConnection connection) {
		InputStream inputStream = null;
		String content = null;
		try {
			connection.setDoOutput(true);
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (compatible; MSIE 6.0; Windows NT)");
			connection.setRequestMethod("GET");
			inputStream = connection.getInputStream();
			content = IOUtils.toString(inputStream);
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null)
				IOUtils.closeQuietly(inputStream);
		}
		return content;
	}

	public void setAutoProxy(AutoProxy autoProxy) {
		this.autoProxy = autoProxy;
	}

}
