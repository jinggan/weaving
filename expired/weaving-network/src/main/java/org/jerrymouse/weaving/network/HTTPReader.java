package org.jerrymouse.weaving.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class HTTPReader {
	private Proxy proxy;

	public void setProxy(Proxy proxy) {
		this.proxy = proxy;
	}

	public String read(URI uri) {
		HttpURLConnection connection = null;
		InputStream inputStream = null;
		try {
			try {
				URL url = uri.toURL();
				if (proxy != null) {
					connection = (HttpURLConnection) url.openConnection(proxy);
				} else {
					connection = (HttpURLConnection) url.openConnection();
				}
				connection.setDoOutput(true);
				connection.setRequestProperty("User-Agent",
						"Mozilla/5.0 (compatible; MSIE 6.0; Windows NT)");
				connection.setRequestMethod("GET");
				if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
					inputStream = connection.getInputStream();
					return IOUtils.toString(inputStream);
				} else {
					return null;
				}
			} finally {
				if (inputStream != null)
					inputStream.close();
				if (connection != null)
					connection.disconnect();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public Proxy getProxy() {
		return proxy;
	}
}
