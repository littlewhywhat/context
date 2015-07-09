package com.littlewhywhat.context.android.data;

public class Data {
	private static final String[] empty = new String[] {};
	private static final String[] root = new String[] { "my courses", "weather" };
	private static final String[] myCourses = new String[] { "Design", "Programming", "Cloud" };
	private static final String[] weather = new String[] { "Sun", "Stars", "Cloud" };
 	private static final String[][] data = new String[][] { myCourses, weather };
	
	public String[] getRoot() {
		return root;
	}

	public String[] getChildren(long id) {
		final int intId = (int)id;
		if (data.length > intId)
			return data[intId];
		return empty;
	}
}