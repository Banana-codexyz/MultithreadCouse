package com.nguyenz.chap6;

import com.nguyenz.chap5.CalculatorRunnable;

public class ThreadStatus {
	public static void main(String[] args) throws InterruptedException {
		CalculatorRunnable runnable = new CalculatorRunnable(30000000000L);

		Thread thread1 = new Thread(runnable);
		thread1.setName("High Priority");
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread1.start();

//		while (thread1.isAlive()) {
//			System.out.println("Thread is active");
//			Thread.sleep(100);
//		}
//
//		System.out.println("Thread is completed. ");

		// waiting for the task to complete
		thread1.join(9000);
		System.exit(0);
	}
}
