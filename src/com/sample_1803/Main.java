package com.sample_1803;

public class Main {
	private static int number = 0;

	public static void main(String[] args) {
//		NguyenService service = new NguyenService();
//		service.doTasks();

		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int j = 0; j < 10000; j++) {
						ince();
					}
				}
			});
			thread.start();
		}
	}

	public synchronized static void ince() {
		number++;
	}
}
