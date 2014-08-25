package com.takeuse.hack2.keypass.view;

import com.takeuse.hack2.DAO.KeyPassDao;

public class ListViewModelImpl implements IListeViewModel{

	private ListViewModelObserver modelObserver;
	private KeyPassDao mKeyPassDao;
	
	public ListViewModelImpl(ListViewModelObserver viewModelObservers){
		this.modelObserver = viewModelObservers;
		this.mKeyPassDao = new KeyPassDao();
	}

	@Override
	public void fetchRawData() {
		modelObserver.loadListView(mKeyPassDao.fetchRawData());
	}
	
	
}
