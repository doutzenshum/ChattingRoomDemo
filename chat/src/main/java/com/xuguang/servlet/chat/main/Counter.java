package com.xuguang.servlet.chat.main;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Counter implements Serializable {

	private static final long serialVersionUID = 9059807303969346046L;
	private int allCount = 0;
	private Set<String> onLine = new LinkedHashSet<String>();

	public Counter() {
	}

	public boolean addOnLine(String name) {
		boolean r = onLine.add(name);
		if (r) {
			allCount++;
		}
		return r;
	}

	public boolean renameOnLine(String oldName, String newName) {
		if (onLine.contains(oldName)) {
			onLine.remove(oldName);
		} else {
			return false;
		}
		if (onLine.add(newName)) {
			return true;
		} else {
			onLine.add(oldName);
			return false;
		}
	}

	public void removeOnLine(String name) {
		onLine.remove(name);
	}

	public int getOnLineCount() {
		return onLine.size();
	}

	public int getAllCount() {
		return allCount;
	}

	public Set<String> getOnLine() {
		return Collections.unmodifiableSet(onLine);
	}
}
