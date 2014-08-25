package com.takeuse.hack2.keypass.view;

import android.database.Cursor;

public interface ListViewModelObserver {

	public void loadListView(Cursor cursor);
}
