package com.takeuse.hack2.DAO;

import android.database.Cursor;

public abstract class AbsCursor {

	public static int getInt(Cursor aCursor,String columnName)
	{	//1. Returns the index for the given column name
		//2. then same cursor use to get value 
		return aCursor.getInt(aCursor.getColumnIndexOrThrow(columnName));
	}
	
	public static String getString(Cursor aCursor,String columnName)
	{	
		//1. Returns the index for the given column name
		//2. then same cursor use to get value 
		return aCursor.getString(aCursor.getColumnIndexOrThrow(columnName));
	}
	
	public static long getLong(Cursor aCursor,String columnName)
	{
		return aCursor.getLong(aCursor.getColumnIndexOrThrow(columnName));
	}
	
	/**integers 0 (false) and 1 (true).
	 * It will convert 0,1 in to boolean
	 * @param value
	 * @return
	 */
	protected static boolean getBoolean(String newValue)
	{
		return newValue.equals("1") ? true : false;
	}
	
	/**integers 0 (false) and 1 (true).
	 * It will convert 0,1 in to boolean
	 * @param value
	 * @return
	 */
	protected static int getBoolean(boolean newValue)
	{
		return newValue == true ? 1 : 0;
	}
	
	protected static boolean getBoolean(int newValue)
	{
		return newValue == 1 ? true : false;
	}
}
