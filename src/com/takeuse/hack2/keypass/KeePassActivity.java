package com.takeuse.hack2.keypass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.takeuse.hack2.R;
import com.takeuse.hack2.keypass.view.keyPassView;

/**
 * @author Bhavdip
 *
 */
public class KeePassActivity extends Activity implements keyPassView {
	
	private KeyPassPresenterImpl keyPassPresenterImpl;
	
	private EditText mEdittextTitle, mEdittextUserName, mEditTextPassword,
			mEditTextUrl, mEditTextNotes;
	
	private ViewGroup mView_progressbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		keyPassPresenterImpl = new KeyPassPresenterImpl(this);
		
		mEdittextTitle = (EditText)findViewById(R.id.edittext_title);
		
		mEdittextUserName = (EditText)findViewById(R.id.edittext_user_name);
		
		mEditTextPassword = (EditText)findViewById(R.id.editext_user_password);
		
		mEditTextUrl = (EditText)findViewById(R.id.edittext_url);
		
		mEditTextNotes = (EditText)findViewById(R.id.edittext_notes);
		
		mView_progressbar = (ViewGroup)findViewById(R.id.view_progressbar);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.keypass_main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_save: {
			keyPassPresenterImpl.saveKeyValue(getRawData());
			break;
		}
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public KeyData getRawData(){
		return new KeyData().setTitle(mEdittextTitle.getText().toString())
				.setUserName(mEdittextUserName.getText().toString())
				.setPassword(mEditTextPassword.getText().toString())
				.setStringUrl(mEditTextUrl.getText().toString())
				.setNotes(mEditTextNotes.getText().toString());
	}

	@Override
	public void showProgressView() {
		if(mView_progressbar != null)
		mView_progressbar.setVisibility(View.VISIBLE);
	}

	@Override
	public void validationError(String error) {
		
	}

	@Override
	public void savingState(String message) {
		if(mView_progressbar != null)
		mView_progressbar.setVisibility(View.INVISIBLE);
		startActivity(new Intent(this,KeyPassListView.class));
	}
}
