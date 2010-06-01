package org.jerrymouse.getfavicon.image;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;

public class ImageRepo {
	private List<Resource> images;
	private Resource defaultImage;

	public void setDefaultImage(Resource defaultImage) {
		this.defaultImage = defaultImage;
	}

	public void setImages(List<Resource> images) {
		this.images = images;
	}

	public byte[] get(String domain) {
		byte[] bytes = null;
		try {

			for (Resource resource : images) {
				if (match(domain, resource.getFilename())) {
					if (resource != null)
						bytes = IOUtils.toByteArray(resource.getInputStream());
				}
			}
			if (bytes == null)
				bytes = IOUtils.toByteArray(defaultImage.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bytes;
	}

	private boolean match(String domain, String filename) {
		filename = filename.substring(0, filename.length() - ".png".length());
		return domain.contains(filename);
	}
}
