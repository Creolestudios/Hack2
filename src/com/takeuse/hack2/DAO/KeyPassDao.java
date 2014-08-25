package com.takeuse.hack2.DAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.takeuse.hack2.keypass.KeyData;


public class KeyPassDao extends AbsBaseDAO{
	
	private final String TAG = KeyPassDao.class.getCanonicalName();
	
	public KeyPassDao(){
		// default constructor 
		super();
	}
	
	public KeyPassDao(SQLiteDatabase database){
		super(database);
	}
	
	
	public void saveData(KeyData rawData) {
		
		executeSingleSQL(TAG,getDataBase(),String.format("INSERT INTO KeyPass(Title,UserName,Password,Url,Notes) VALUES ('%s','%s','%s','%s','%s')",
				rawData.getTitle(),rawData.getUserName(),rawData.getPassword(),rawData.getStringUrl(),rawData.getNotes()));
		
	}
	
	public Cursor fetchRawData(){
		return geRawQuery(TAG,getDataBase(),"SELECT * From KeyPass",null);
	}

	@Override
	protected void executeCreateTable() {
		getDataBase().execSQL("CREATE TABLE KeyPass(_id INTEGER PRIMARY KEY AUTOINCREMENT, Title TEXT, UserName TEXT,Password TEXT,Url TEXT,Notes TEXT)");		
	}

	
	public static KeyData getConstructModel(Cursor cursor){
		KeyData modelData = new KeyData();
		modelData.setTitle(getString(cursor, "Title"));
		modelData.setUserName(getString(cursor,"UserName"));
		modelData.setPassword(getString(cursor,"Password"));
		modelData.setStringUrl(getString(cursor,"Url"));
		modelData.setNotes(getString(cursor, "Notes"));
		return modelData;
	}
}
