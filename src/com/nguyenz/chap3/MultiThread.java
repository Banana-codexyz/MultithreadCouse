package com.nguyenz.chap3;

public class MultiThread {
	public static void main(String[] args) {
		Thread javaThread = new Thread(new JavaThread());
		javaThread.setName("Java_Thread");

		Thread springBootThread = new Thread(new SpringBootThead());
		springBootThread.setName("SpringBoot_Thread");

		Thread mySqlThread = new Thread(new MySqlThread());
		mySqlThread.setName("MySql_Thread");

		javaThread.start();
		springBootThread.start();
		mySqlThread.start();
	}

}
