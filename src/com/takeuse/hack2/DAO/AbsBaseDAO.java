package com.takeuse.hack2.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.takeuse.hack2.KeyPassApplication;

public abstract class AbsBaseDAO extends AbsCursor{
	
	private final String TAG = AbsBaseDAO.class.getCanonicalName();

	private SQLiteDatabase mDatabase;
	
	protected KeyPassApplication mKeyPassApplication;
	
	public AbsBaseDAO(){
		initializeDataBase();
	}
	
	private void initializeDataBase(){
	
		if(KeyPassApplication.getInstance() != null)
			mKeyPassApplication = KeyPassApplication.getInstance();
			mDatabase = mKeyPassApplication.getDataBaseHelper();
	}
	
	public AbsBaseDAO(SQLiteDatabase database){
		if (mDatabase == null && database != null)
		mDatabase = database;
	}
	
	public SQLiteDatabase getDataBase(){
		return mDatabase;
	}
	
	private boolean canDataBaseAccess(){
		if(getDataBase() == null){
			initializeDataBase();
		}
		return true;
	}
	
	/**
	 * each derived class has at least one create table query
	 */
	protected abstract void executeCreateTable();
	
	
	/**
	 * Execute a single SQL statement that is NOT a SELECT or any other SQL statement that returns data. 
	 * @param aTag
	 * @param mDataBase
	 * @param aPeformQuery
	 */
	protected boolean executeSingleSQL(String aTag,SQLiteDatabase mDataBase,String aPeformQuery){
		boolean returnValue = false;
		try
		{
			Log.i(TAG,String.format("%2s : Query: %3s",aTag,aPeformQuery));
			mDataBase.execSQL(aPeformQuery);
			returnValue = true;
			
		}catch(Exception e)
		{
			returnValue = false;
		}
		
		return returnValue;
	}
	
	/**
	 * Runs the provided SQL and returns a Cursor over the result set.
	 * @return Cursor
	 */
	protected synchronized Cursor geRawQuery(String aTag,SQLiteDatabase mSQLiteDatabase,String aQuery,String[] selectionArgs)
	{	
		final Cursor returnCursor = null;
		if(canDataBaseAccess())
		{
			Log.i(TAG,String.format("%2s : Query: %3s",aTag,aQuery));
			return mSQLiteDatabase.rawQuery(aQuery,selectionArgs);
		}
		return returnCursor;
	}
	
	protected synchronized int updateQuery(SQLiteDatabase mSQLiteDatabase,String tableName,ContentValues setValues,String whereCluse,String[] whereArgs)
	{
		return mSQLiteDatabase.update(tableName,setValues,whereCluse,whereArgs);
	}
}
