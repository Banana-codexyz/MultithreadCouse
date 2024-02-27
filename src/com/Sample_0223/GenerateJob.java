package com.Sample_0223;

import java.util.List;

class GenerateJob extends Thread {
	// to stop the thread
	List<JobInfo> listJobs;

	public GenerateJob(List<JobInfo> listJobs) {
		this.listJobs = listJobs;
	}

	@Override
	public void run() {
		int count = 0;
		int maxJob = 5;
		try {
			while (true) {
				int waitSeconds = 1;

				if (listJobs.size() < maxJob) {
					JobInfo job = new JobInfo(count);
					listJobs.add(job);
					count++;
					System.out.println("Add a new job; num job = " + listJobs.size());
				} else {
					System.out.println("Num of jobs reaches limit; num job = " + listJobs.size());
				}

				sleep(waitSeconds * 1000);
			}
		} catch (Exception e) {
			// Throwing an exception
			System.out.println("Thread generate job" + ": Exception is caught");
		}
	}
}
