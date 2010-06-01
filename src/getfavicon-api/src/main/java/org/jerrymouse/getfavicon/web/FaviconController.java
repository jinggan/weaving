package org.jerrymouse.getfavicon.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.jerrymouse.getfavicon.image.ImageGetter;
import org.jerrymouse.getfavicon.image.ImageMime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FaviconController {
	@Resource
	private ImageGetter getter;
	@Resource
	private ImageMime imageMime;

	@RequestMapping("/getfavicon")
	public void favicon(
			@RequestParam String domain,
			@RequestParam(required = false, defaultValue = "png") String format,
			@RequestParam(required = false, defaultValue = "0") Integer w,
			@RequestParam(required = false, defaultValue = "0") Integer h,
			HttpServletResponse response) {
		try {
			response.addHeader("max-age", "3600000");
			byte[] bs = null;
			if ("jpg".equalsIgnoreCase(format)
					|| "jpeg".equalsIgnoreCase(format)) {
				format = "jpg";
			} else
				format = "png";
			if ("png".equals(format) && w == 0 && h == 0) {
				bs = getter.get(domain);
			} else {
				bs = getter.get(domain, format, w, h);
			}
			if (bs != null) {
				IOUtils.copy(new ByteArrayInputStream(bs), response
						.getOutputStream());
				response.setContentType(imageMime.get(format));
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}