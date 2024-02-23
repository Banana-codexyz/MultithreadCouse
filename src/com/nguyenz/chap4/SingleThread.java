package com.nguyenz.chap4;

public class SingleThread {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			System.out.println("Java");
			Thread.sleep(200);
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("Spring Boot");
			Thread.sleep(200);
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("MySQL");
			Thread.sleep(200);
		}
	}
}
