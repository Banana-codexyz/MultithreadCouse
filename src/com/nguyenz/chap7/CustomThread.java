package com.nguyenz.chap7;

public class CustomThread extends Thread {

	private boolean shouldExit = false;

	public void setShouldExit(boolean shouldExit) {
		this.shouldExit = shouldExit;
	}

	@Override
	public void run() {

		try {
			for (int i = 0; i < 30; i++) {
				if (shouldExit) {
					break;
				}

				System.out.println("Thread is running!");
				Thread.sleep(200);
			}
			System.out.println("Thread is complete");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
