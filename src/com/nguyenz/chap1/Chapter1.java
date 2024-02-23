package com.nguyenz.chap1;

public class Chapter1 {
	public static void main(String[] args) throws InterruptedException {
		Thread th = Thread.currentThread();

		System.out.println("Current Thread: " + th.getName());

		th.setName("NguyenThread");
		System.out.println(th.getName());

		Thread.sleep(10000);
	}
}
