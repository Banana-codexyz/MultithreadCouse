package com.nguyenz.chap4;

public class JavaThread extends Thread {

	public JavaThread() {
		setName("Java Thread");
	}

	@Override
	public void run() {
		System.out.println("Starting Thread Name: " + Thread.currentThread().getName());
		for (int i = 0; i < 10; i++) {
			System.out.println("Java");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Thread completed: " + Thread.currentThread().getName());
	}

}
