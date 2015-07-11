package com.littlewhywhat.context.android.data;

import java.util.HashMap;

public class Data {
	private static final String[] empty = new String[] {};
	public static final String ROOT_ID = "root";
	private static final String[] ROOT_CHILDREN = new String[] { "my courses", "weather" };
	private static final String MY_COURSES_ID = ROOT_CHILDREN[0];
	private static final String WEATHER_ID = ROOT_CHILDREN[1];
	private static final String[] MC_CHILDREN = new String[] { "Design", "Programming", "Cloud Services" };
	private static final String[] WEATHER_CHILDREN = new String[] { "Sun", "Stars", "Cloud" };
	private static final String[] CLOUD_CLONES = new String[] { WEATHER_CHILDREN[2], MC_CHILDREN[2] };
	private static final String[] DESIGN_CLONES = new String[] { MC_CHILDREN[0], WEATHER_CHILDREN[1] };
	private static final String CLOUD_CLONES_ID = "Cloud clones";
	private static final String DESIGN_CLONES_ID = "Design clones";

	private static final HashMap<String, String> mClonesToClonesIds = new HashMap<String, String>();
 	private static final HashMap<String, String[]> mChildren = new HashMap<String, String[]>();
 	private static final HashMap<String, String> mParents = new HashMap<String, String>();

 	public Data() {
 		mParents.put(ROOT_ID, ROOT_ID); 	
 		setRelationship(ROOT_ID, ROOT_CHILDREN);
 		setRelationship(MY_COURSES_ID, MC_CHILDREN);
 		setRelationship(WEATHER_ID, WEATHER_CHILDREN);	
 		
 		setCloneConnection(DESIGN_CLONES_ID, DESIGN_CLONES);
 		setCloneConnection(CLOUD_CLONES_ID, CLOUD_CLONES);
 	}

 	private void setCloneConnection(String clonesId, String[] clones) {
 		mParents.put(clonesId, clonesId);
 		mChildren.put(clonesId, clones);
 		for (int i = 0; i < clones.length; i++) {
 			mClonesToClonesIds.put(clones[i], clonesId);
 		}
 	}

 	private void setRelationship(String parentId, String[] childrenIds) {
 		mChildren.put(parentId, childrenIds);
 		for (int i = 0; i < childrenIds.length; i++) {
 			mParents.put(childrenIds[i], parentId);
 		}
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

	public String getClonesId(String id) {
		return mClonesToClonesIds.get(id);
	}
}