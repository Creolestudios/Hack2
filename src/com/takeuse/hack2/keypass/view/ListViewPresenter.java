package com.takeuse.hack2.keypass.view;

import android.content.Context;
import android.database.Cursor;

public class ListViewPresenter implements IListViewerObserver,ListViewModelObserver {
	
	private Context mContext;
	
	private IListViewer mListViewer;
	
	private IListeViewModel mListeViewModel;
	
	public ListViewPresenter(){
		this.mListeViewModel = new ListViewModelImpl(this);
	}
	
	public Context getContext(){
		return mContext;
	}
	
	@Override
	public void registerContext(Context context) {
		this.mContext = context;
	}

	@Override
	public void addViewListener(IListViewer iListViewer) {
		this.mListViewer = iListViewer;
	}

	@Override
	public void FetchRawData() {
		mListeViewModel.fetchRawData();
	}

	@Override
	public void loadListView(Cursor cursor) {
		mListViewer.updateListView(cursor);
	}

	
}
