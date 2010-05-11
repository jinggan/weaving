package org.jerrymouse.weaving.extracter.analysis.filer;

import java.util.ArrayList;
import java.util.List;

import org.jerrymouse.weaving.extracter.analysis.filer.douban.DoubanProfileFilter;
import org.jerrymouse.weaving.eye.Eye;
import org.jerrymouse.weaving.eye.EyeFactory;

public class FilterManager {
	List<Filter> filters;
	private Eye eye;

	public void setEye(Eye eye) {
		this.eye = eye;
	}

	public Eye getEye() {
		if (eye == null)
			eye = new EyeFactory().getEye();
		return eye;
	}

	public void init() {
		filters = new ArrayList<Filter>();
		DoubanProfileFilter filter = new DoubanProfileFilter();
		filter.setEye(getEye());
		filters.add(filter);
	}

	public List<Filter> getFilters() {
		if (filters == null)
			init();
		return filters;
	}

}
