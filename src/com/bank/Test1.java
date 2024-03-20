package com.bank;

public class Test1 extends Thread {
	private Account account;

	public Test1(Account account) {
		this.account = account;
	}

	public synchronized void withdrawMoney(int money) throws InterruptedException {
		if (account.getBalance() > money) {
			Thread.sleep(1000);
			account.setBalance(account.getBalance() - money);
			System.out.println("Balance:" + account.getBalance());
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
		Account account = new Account(10000);
		Test1 test1 = new Test1(account);
		Test1 test2 = new Test1(account);

		test1.start();
		test2.start();
	}
}
