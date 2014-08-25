package com.takeuse.hack2.util;

import android.os.Environment;

public class Constants {

	public static String getAppHomeDirectory(){
	
		return String.format(Environment.getExternalStorageDirectory().getPath()+ "/KeyPass/");
	}
}
