package org.jerrymouse.getfavicon.image;

import java.util.Map;
import java.util.WeakHashMap;

import org.springframework.stereotype.Component;

@Component
public class ImageCache {
	private Map<String, Object> ms = new WeakHashMap<String, Object>();

	public byte[] get(String domain) {
		if (!ms.containsKey(domain))
			return null;
		return (byte[]) ms.get(domain);
	}

	public void put(String key, byte[] bs) {
		ms.put(key, bs);
	}

	public byte[] get(String domain, String format, int w, int h) {
		return get(toKey(domain, format, w, h));
	}

	public void put(String domain, String format, int w, int h, byte[] bs) {
		put(toKey(domain, format, w, h), bs);
	}

	private String toKey(String domain, String format, int w, int h) {
		if (domain == null)
			domain = "null";
		if (format == null)
			format = "null";
		return domain + "-" + format + "-" + w + "-" + h;
	}
}
