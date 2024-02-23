package com.nguyenz.chap4;

public class SpringBootThead extends Thread {

	public SpringBootThead() {
		setName("SpringBoot_Thread");
	}

	@Override
	public void run() {
		System.out.println("Starting Thread Name: " + Thread.currentThread().getName());
		for (int i = 0; i < 10; i++) {
			System.out.println("Spring Boot");
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
