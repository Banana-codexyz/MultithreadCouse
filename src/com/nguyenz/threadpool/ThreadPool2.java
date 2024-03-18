package com.nguyenz.threadpool;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool2 {
	public void startThreadPool() {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		for (int i : list) {
			Future future = executor.submit(new Task(i));
			Runnable cancelTask = () -> future.cancel(true);

			executor.schedule(cancelTask, 10, TimeUnit.SECONDS);
		}

		executor.shutdown();
	}

	public static void main(String[] args) {
		ThreadPool2 threadPool2 = new ThreadPool2();
		threadPool2.startThreadPool();
	}
}
