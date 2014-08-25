package com.takeuse.hack2.DAO;

import com.takeuse.hack2.KeyPassApplication;
import com.takeuse.hack2.util.Constants;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class KeyPassLiteHelper extends SQLiteOpenHelper {

	private final static int DATABASE_VERSION = 1;
	
	private final static String DATABASE_NAME = "keep_pass.db";
	
	private final static String DATABASE_PATH = getDataBasePath();
	
	
	public KeyPassLiteHelper(Context context) {
		super(context,DATABASE_PATH,null, DATABASE_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		new KeyPassDao(db).executeCreateTable();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	
	private static String getDataBasePath(){
		if(KeyPassApplication.getInstance().isInDebugMode()){
			return new StringBuilder(Constants.getAppHomeDirectory()).append(DATABASE_NAME).toString();
		}
		else{
			return new StringBuilder().append("/data/data/").append(KeyPassApplication.getInstance().getPackageName())
					.append("/database/").append(DATABASE_NAME).toString();	
		}
	}

}
