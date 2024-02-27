package com.demo1;

public class CrawlerTask implements Runnable {

	private long createdTime;
	private String taskName;

	public CrawlerTask(String taskName) {
		this.createdTime = System.currentTimeMillis();
		this.taskName = taskName;
	}

	@Override
	public void run() {
		try {
			System.out.println("Doing the task:" + taskName);
			Thread.sleep(1000);
			System.out.println("Fisnished:" + taskName);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
