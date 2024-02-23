package com.nguyenz.chap4;

public class MultiThread {
	public static void main(String[] args) {

		JavaThread javaThread = new JavaThread();
		SpringBootThead springBootThread = new SpringBootThead();
		MySqlThread mySqlThread = new MySqlThread();

		javaThread.start();
		springBootThread.start();
		mySqlThread.start();
	}

}
