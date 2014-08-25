package com.takeuse.hack2.keypass.view;

import android.content.Context;

public interface IListViewerObserver {
	
	public void registerContext(Context context);
	
	public void addViewListener(IListViewer iListViewer);
	
	public void FetchRawData();
	
}
