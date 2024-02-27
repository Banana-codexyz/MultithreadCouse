package com.Sample_0223;

import java.util.List;
import java.util.Timer;

class ExecuteJob extends Thread {
	// to stop the thread
	List<JobInfo> listJobs;

	public ExecuteJob(List<JobInfo> listJobs) {
		this.listJobs = listJobs;
	}

	@Override
	public void run() {
		try {
			while (true) {
				int waitSeconds = 2;

				if (listJobs.size() > 0) {
					JobInfo tempJob = listJobs.get(1);
					listJobs.remove(1);
					System.out.println("Execute a new job; num job = " + listJobs.size());

					RunTask object = new RunTask(tempJob.jobID);

					Thread thread = new Thread(object);
					thread.start();

					Timer timer = new Timer();
					TimeOutTask timeOutTask = new TimeOutTask(thread, timer);
					timer.schedule(timeOutTask, 10000);
				}

				sleep(waitSeconds * 1000);
			}
		} catch (Exception e) {
			// Throwing an exception
			System.out.println("Thread execute job" + ": Exception is caught");
		}
	}
}
