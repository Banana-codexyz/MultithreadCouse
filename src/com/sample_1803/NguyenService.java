package com.sample_1803;

public class NguyenService {

	private final int numTheads = 4;

	ShareData shareData = new ShareData();

	public void doTasks() {
		shareData.addTaskid(1);
		for (int i = 0; i < numTheads; i++) {
			new Task(i + 1, shareData).start();
		}
	}
}
