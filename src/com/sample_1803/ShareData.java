package com.sample_1803;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShareData {
	List<Integer> idList;

	public ShareData() {
		idList = Collections.synchronizedList(new ArrayList<Integer>());
	}

	public synchronized int getElement() {
		int id = idList.get(0);
		idList.remove(0);
		return id;
	}

	public void addTaskid(int id) {
		idList.add(id);
	}

	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}

}
