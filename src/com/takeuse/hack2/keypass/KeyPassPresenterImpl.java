package com.takeuse.hack2.keypass;

import com.takeuse.hack2.keypass.view.keyPassView;

public class KeyPassPresenterImpl implements KeyPassPresenter,KeyPassModelObserver{
	
	private keyPassView mKeyPassView;
	
	private KeyPassModel mPassModel;
	
	public KeyPassPresenterImpl(keyPassView keyPassView){
		this.mKeyPassView = keyPassView;
		this.mPassModel = new KeyPassModelImpl(this);
	}

	@Override
	public void saveKeyValue(KeyData data) {
		mPassModel.onSave(data);
	}

	@Override
	public void onCompleteAction(String action) {
		mKeyPassView.savingState(action);
	}

}
