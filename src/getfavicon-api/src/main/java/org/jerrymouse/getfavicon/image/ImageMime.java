package org.jerrymouse.getfavicon.image;

import java.util.Map;

public class ImageMime {
	private Map<String, String> mimi;

	public void setMimi(Map<String, String> mimi) {
		this.mimi = mimi;
	}

	public String get(String k) {
		return mimi.get(k);
	}
}
