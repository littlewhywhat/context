package com.littlewhywhat.context.android.data;

import java.util.HashMap;

public class Data {
	private static final String[] empty = new String[] {};
	public static final String ROOT_ID = "root";
	public static final String CLOUD_CONTEXT_ID = "Cloud context";
	private static final String[] rootChildren = new String[] { "my courses", "weather" };
	private static final String[] myCourses = new String[] { "Design", "Programming", "Cloud Services" };
	private static final String[] weather = new String[] { "Sun", "Stars", "Cloud" };
	private static final String[] contexts = new String[] { weather[2], myCourses[2] };

	private static final HashMap<String, String> mContexts = new HashMap<String, String>();
 	private static final HashMap<String, String[]> mChildren = new HashMap<String, String[]>();
 	private static final HashMap<String, String> mParents = new HashMap<String, String>();

 	public Data() {
 		mChildren.put(ROOT_ID, rootChildren);
 		mChildren.put(rootChildren[0], myCourses);
 		mChildren.put(rootChildren[1], weather);
 		for (int i = 0; i < contexts.length; i++) {
 			mContexts.put(contexts[i], CLOUD_CONTEXT_ID);
 			mChildren.put(CLOUD_CONTEXT_ID, contexts);
 		}
 		mParents.put(CLOUD_CONTEXT_ID, CLOUD_CONTEXT_ID);
 		mParents.put(ROOT_ID, ROOT_ID);
 		for (int i = 0; i < rootChildren.length; i++) {
 			mParents.put(rootChildren[i], ROOT_ID);
 		}
 		for (int i = 0; i < myCourses.length; i++) {
 			mParents.put(myCourses[i], rootChildren[0]);
 		}
 		for (int i = 0; i < weather.length; i++) {
 			mParents.put(weather[i], rootChildren[1]);
 		}
 	}

	public String[] getRoot() {
		return mChildren.get(ROOT_ID);
	}

	public String[] getChildren(String id) {
		final String[] children = mChildren.get(id);
		if (children != null)
			return children;
		return empty;
	}

	public String getParent(String childId) {
		return mParents.get(childId);
	}

	public String getContext(String id) {
		return mContexts.get(id);
	}
}