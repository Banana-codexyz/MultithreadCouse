package com.nguyenz.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadPool {
	public void startThreadPool() {
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		for (int i = 1; i < 10; i++) {
			Future future = executorService.submit(new Task(i));
			try {
				future.get(13, TimeUnit.SECONDS);
			} catch (InterruptedException | ExecutionException | TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		executorService.shutdown();

	}

	public static void main(String[] args) {
		ThreadPool threadPool = new ThreadPool();
		threadPool.startThreadPool();
	}
}
