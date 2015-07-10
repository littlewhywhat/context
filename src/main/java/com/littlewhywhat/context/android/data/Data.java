package com.littlewhywhat.context.android.data;

import java.util.HashMap;

public class Data {
	private static final String[] empty = new String[] {};
	private static final String root = "root";
	private static final String[] rootChildren = new String[] { "my courses", "weather" };
	private static final String[] myCourses = new String[] { "Design", "Programming", "Cloud" };
	private static final String[] weather = new String[] { "Sun", "Stars", "Cloud" };
	
 	private static final HashMap<String, String[]> data = new HashMap<String, String[]>();

 	public Data() {
 		data.put(root, rootChildren);
 		data.put(rootChildren[0], myCourses);
 		data.put(rootChildren[1], weather);
 	}

	public String[] getRoot() {
		return data.get(root);
	}

	public String[] getChildren(String id) {
		final String[] children = data.get(id);
		if (children != null)
			return children;
		return empty;
	}
}