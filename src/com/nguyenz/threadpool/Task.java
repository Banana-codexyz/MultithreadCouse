package com.nguyenz.threadpool;

public class Task extends Thread {
	private int id;

	public Task(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Task started id:" + id);
		try {
			if (id == 3) {
				sleep(15000);
			} else {
				sleep(2000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Time out task id:" + id);
		}
		System.out.println("Task finished id:" + id);
	}
}
