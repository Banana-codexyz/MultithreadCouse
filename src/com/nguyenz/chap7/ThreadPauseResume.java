package com.nguyenz.chap7;

public class ThreadPauseResume {

	public static void main(String[] args) throws InterruptedException {
		CustomThread customThread = new CustomThread();
		customThread.start();

		Thread.sleep(3000);
		customThread.join();

		Thread.sleep(3000);
		if (customThread.isAlive()) {
			customThread.setShouldExit(true);
			customThread.join();
		}

		System.exit(0);
	}

}
