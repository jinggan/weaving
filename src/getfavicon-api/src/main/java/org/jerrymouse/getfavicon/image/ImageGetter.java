package org.jerrymouse.getfavicon.image;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class ImageGetter {
	@Resource
	private ImageCache cache;
	@Resource
	private ImageRepo imageRepo;

	public byte[] get(String url) {
		String domain = toDomain(url);
		byte[] bs;
		bs = cache.get(domain);
		if (bs == null) {
			bs = imageRepo.get(domain);
			if (bs != null) {
				cache.put(domain, bs);
			}
		}
		return bs;
	}

	public byte[] get(String url, String format, int w, int h) {
		String domain = toDomain(url);
		byte[] bs;
		bs = cache.get(domain, format, w, h);
		if (bs == null) {
			cache.put(domain, format, w, h, bs);
		}
		return bs;
	}

	public String toDomain(String urlStr) {
		int i = urlStr.lastIndexOf(".");
		if (i == -1)
			return urlStr;
		urlStr = urlStr.substring(0, i);
		i = urlStr.lastIndexOf(".");
		if (i == -1)
			return urlStr;
		urlStr = urlStr.substring(i + 1);
		return urlStr;
	}
}
