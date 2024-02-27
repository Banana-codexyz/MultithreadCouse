package com.Sample_0223;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class ThreadPool {
	public static void main(String[] args) {
		List<JobInfo> listJobs = new ArrayList<JobInfo>();

//		List<JobInfo> listJobs = Arrays.asList(new JobInfo(1), new JobInfo(2), new JobInfo(3));
		GenerateJob genJob = new GenerateJob(listJobs);

		ExecuteJob execJob = new ExecuteJob(listJobs);

		Thread thread = new Thread(genJob);
		thread.start();

		Thread thread2 = new Thread(execJob);
		thread2.start();

		Timer timer = new Timer();
		TimeOutTask timeOutTask = new TimeOutTask(thread, timer);
		timer.schedule(timeOutTask, 10000);

		Timer timer2 = new Timer();
		TimeOutTask timeOutTask2 = new TimeOutTask(thread2, timer2);
		timer2.schedule(timeOutTask2, 10000);

	}
}
