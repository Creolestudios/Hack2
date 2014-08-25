package com.takeuse.hack2.keypass;

import java.util.List;

public interface KeyPassModel {

	public void onSave(KeyData data);
	
	public void onDelete(KeyData data);
	
	public List<KeyData> getkeyList();
}
