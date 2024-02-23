package com.minh;

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
			System.out.println("Exception is caught");
		}
	}
}

//Main Class
public class Multithread {
	public static void main(String[] args) {
		int n = 8; // Number of threads
		MultithreadingDemo[] listThread = new MultithreadingDemo[n];
		;
		for (int i = 0; i < n; i++) {
			MultithreadingDemo object = new MultithreadingDemo(i);
			listThread[i] = object;
			object.start();
		}

		int mainSleep = 60;
		try {
			Thread.sleep(mainSleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < n; i++) {
//	        listThread[i].stop();
		}

	}
}
