package com.takeuse.hack2;

import com.takeuse.hack2.DAO.KeyPassLiteHelper;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.database.sqlite.SQLiteDatabase;

public class KeyPassApplication extends Application {

	private static KeyPassApplication mKeyPassApplication;
	
	private static SQLiteDatabase mSqLiteDatabase;
	
	private boolean debugMode;
	
	public static KeyPassApplication getInstance() {
		return mKeyPassApplication;
	}
	
	public SQLiteDatabase getDataBaseHelper(){
		return mSqLiteDatabase;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		if(mKeyPassApplication == null){
			mKeyPassApplication = this;
		}
		
		//update the debug mode 
		setDebugMode(((getApplicationInfo().flags &= ApplicationInfo.FLAG_DEBUGGABLE) != 0));
		
		// initialize the database 
		setUpDataBase();
	}
	
	private void setUpDataBase(){
		
		KeyPassLiteHelper liteDatabase = new KeyPassLiteHelper(getApplicationContext());
		
		mSqLiteDatabase = liteDatabase.getWritableDatabase();
		
	}
	
	private void setDebugMode(boolean debugMode){
		this.debugMode = debugMode;
	}
	
	public boolean isInDebugMode(){
		return debugMode;
	}
	
	
	
}
