package com.takeuse.hack2.keypass;

import java.util.List;

import com.takeuse.hack2.DAO.KeyPassDao;

public class KeyPassModelImpl implements KeyPassModel {
	
	private KeyPassModelObserver modelObserver;
	
	private KeyPassDao mPassDao;
	
	public KeyPassModelImpl(KeyPassModelObserver modelObserver){
		this.modelObserver = modelObserver;
		this.mPassDao = new KeyPassDao();
	}

	@Override
	public void onSave(KeyData rawData) {
		mPassDao.saveData(rawData);
		modelObserver.onCompleteAction("SAVED");
	}

	@Override
	public void onDelete(KeyData data) {
		modelObserver.onCompleteAction("DELETED");
	}

	@Override
	public List<KeyData> getkeyList() {
		return null;
	}
	
}
