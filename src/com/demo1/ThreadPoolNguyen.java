package com.demo1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolNguyen {
	public static void main(String[] args) {
		ThreadPoolNguyen threadPoolNguyen = new ThreadPoolNguyen();
		threadPoolNguyen.startThreadPoolExample();
	}

	private void startThreadPoolExample() {
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		List<String> listTaskList = Arrays.asList("Task1", "Task2", "Task3", "Task4", "Task5", "Task6");
		for (String task : listTaskList) {
			CrawlerTask crawlerTask = new CrawlerTask(task);
			Future future = executorService.submit(crawlerTask);

		}

		executorService.shutdown();
	}
}
