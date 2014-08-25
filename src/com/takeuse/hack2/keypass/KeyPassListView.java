package com.takeuse.hack2.keypass;

import com.takeuse.hack2.R;
import com.takeuse.hack2.adapter.ListViewAdapter;
import com.takeuse.hack2.keypass.view.IListViewer;
import com.takeuse.hack2.keypass.view.IListViewerObserver;
import com.takeuse.hack2.keypass.view.ListViewPresenter;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

/**
 * 
 * @author Bhavdip
 *
 */
public class KeyPassListView extends Activity implements IListViewer{
	
	private IListViewerObserver mObserver;
	
	private ListView mListView;
	
	private ListViewAdapter mListViewAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_listview);
		
		mListView = (ListView)findViewById(R.id.listview);
		
		mObserver = new ListViewPresenter();
		
		mObserver.registerContext(this);
		
		mObserver.addViewListener(this);
		
		mObserver.FetchRawData();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	@Override
	public void updateListView(Cursor cursor) {
		if (cursor != null && cursor.getCount() > 0) {
			mListViewAdapter = new ListViewAdapter(this,cursor,false);
			mListView.setAdapter(mListViewAdapter);
		}
	}

}
