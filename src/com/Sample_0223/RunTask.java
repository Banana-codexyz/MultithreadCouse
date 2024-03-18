package com.Sample_0223;

class RunTask extends Thread {
	int localThreadID;

	// to stop the thread
	private boolean exit;

	public RunTask(int ID) {
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

			System.out.println("Sub thread " + localThreadID + " started");

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

				System.out.println("Sub thread " + localThreadID + " sleeps for " + randomSeconds
						+ " seconds at second " + totalTime + " (" + status + ") ");

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
//	                 "Sub thread " + Thread.currentThread().getId()
//	                 + " stops.");

			System.out.println("Sub thread " + localThreadID + " stops.");
		} catch (Exception e) {
			// Throwing an exception
			e.printStackTrace();
			System.out.println("Sub thread " + localThreadID + ": Exception is caught");
		}
	}
}
