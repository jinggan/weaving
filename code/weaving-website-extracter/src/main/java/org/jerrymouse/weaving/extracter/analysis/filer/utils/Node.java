package org.jerrymouse.weaving.extracter.analysis.filer.utils;

import org.springframework.stereotype.Component;

public class Node {
	private org.w3c.dom.Node node;

	public boolean isEmtry() {
		return node == null;
	}

	public String getAtrribute(String name) {
		if (isEmtry())
			return null;
		org.w3c.dom.Node a = node.getAttributes().getNamedItem(name);
		if (a == null)
			return null;
		String r = a.getTextContent();
		if (r == null)
			return null;
		return r.trim();
	}

	public Node() {
	}

	public Node(org.w3c.dom.Node node) {
		this.node = node;
	}

	public String getTextContent() {
		if (isEmtry())
			return null;
		String r = node.getTextContent();
		if (r == null)
			return null;
		return r.trim();
	}
}
