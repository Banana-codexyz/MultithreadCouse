package com.sample_1803;

import java.util.Random;

public class Task extends Thread {
	int id;
	ShareData shareData;

	public Task(int id, ShareData shareData) {
		this.id = id;
		this.shareData = shareData;
	}

	@Override
	public void run() {
		while (true) {
			if (!shareData.getIdList().isEmpty()) {
				int taskId = shareData.getElement();
				System.out.println("Thread " + id + " do task id:" + taskId);

				Random rd = new Random();
				int a = rd.nextInt(10) + 1;
				shareData.addTaskid(a);

				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
