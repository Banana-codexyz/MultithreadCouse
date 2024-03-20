package com.bank;

public class TestThread implements Runnable {
	private int balance;

	public TestThread(int balance) {
		this.balance = balance;
	}

	public synchronized void withdrawMoney(int money) throws InterruptedException {
		if (balance > money) {
			Thread.sleep(1000);
			balance = balance - money;
			System.out.println("Balance:" + balance);
		} else {
			System.out.println("Money > Balance");
		}
	}

	@Override
	public void run() {
		try {
			withdrawMoney(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestThread t = new TestThread(10000);

		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);

		t1.start();
		t2.start();

	}
}
