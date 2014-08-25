package com.takeuse.hack2.adapter;

import com.takeuse.hack2.R;
import com.takeuse.hack2.DAO.KeyPassDao;
import com.takeuse.hack2.keypass.KeyData;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ListViewAdapter extends CursorAdapter {

	
	private LayoutInflater mLayoutInflater;
	
	public ListViewAdapter(Context context, Cursor c, boolean autoRequery) {
		super(context, c, autoRequery);
		mLayoutInflater = LayoutInflater.from(context);
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		KeyData keyData = KeyPassDao.getConstructModel(cursor);
		
		if (keyData != null) {
			
			TextView mTitleView = (TextView)view.findViewById(R.id.textview_title);
			
			mTitleView.setText(keyData.getTitle());
			
			TextView mUserName = (TextView)view.findViewById(R.id.textview_user_name);
			
			mUserName.setText(keyData.getUserName());
			
			TextView mPassword = (TextView)view.findViewById(R.id.textview_user_password);
			
			mPassword.setText(keyData.getPassword());
			
			TextView mNotesView = (TextView)view.findViewById(R.id.textview_notes);
			
			mNotesView.setText(keyData.getNotes());
			
			
		}
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		return mLayoutInflater.inflate(R.layout.raw_listview_item,parent,false);
	}

}
