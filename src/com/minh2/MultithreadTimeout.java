package com.minh2;

import java.util.Timer;
import java.util.TimerTask;

class TimeOutTask extends TimerTask {
	private Thread thread;
	private Timer timer;

	public TimeOutTask(Thread thread, Timer timer) {
		this.thread = thread;
		this.timer = timer;
	}

	@Override
	public void run() {
		if (thread != null && thread.isAlive()) {
			thread.interrupt();
			timer.cancel();
		}
	}
}

//Java code for thread creation by extending
//the Thread class
class MultithreadingDemo extends Thread {
	int localThreadID;

	// to stop the thread
	private boolean exit;

	public MultithreadingDemo(int ID) {
		localThreadID = ID;
		exit = false;
	}

	@Override
	public void run() {
		try {
			// Displaying the thread that is running
//	         System.out.println(
//	             "Thread " + Thread.currentThread().getId()
//	             + " started");

			System.out.println("Thread " + localThreadID + " started");

			int maxTime = 5;
			int i = 0;
			int totalTime = 0;

			int maxSeconds = 10;
			int minSeconds = 1;

			String status = "";

			while (true) {
				int randomSeconds = (int) Math.floor(Math.random() * (maxSeconds - minSeconds + 1) + minSeconds);
//	        	 System.out.println(
//	                     "Thread " + Thread.currentThread().getId()
//	                     + " sleeps for " + randomSeconds + " seconds...");

				System.out.println("Thread " + localThreadID + " sleeps for " + randomSeconds + " seconds at second "
						+ totalTime + " (" + status + ") ");

				sleep(randomSeconds * 1000);
				totalTime += randomSeconds;
				status += randomSeconds + "+";

				i++;
				if (i > maxTime)
					break;
				if (exit)
					break;
			}

//	         System.out.println(
//	                 "Thread " + Thread.currentThread().getId()
//	                 + " stops.");

			System.out.println("Thread " + localThreadID + " stops.");
		} catch (Exception e) {
			// Throwing an exception
			System.out.println("Thread " + localThreadID + ": Exception is caught");
		}
	}
}

//Main Class
public class MultithreadTimeout {
	public static void main(String[] args) {
		int n = 8; // Number of threads
		MultithreadingDemo[] listThread = new MultithreadingDemo[n];

		for (int i = 0; i < n; i++) {
			MultithreadingDemo object = new MultithreadingDemo(i);
			listThread[i] = object;

			Thread thread = new Thread(object);
			thread.start();

			Timer timer = new Timer();
			TimeOutTask timeOutTask = new TimeOutTask(thread, timer);
			timer.schedule(timeOutTask, 30000); // Set timeout to 30 seconds
		}
	}
}
