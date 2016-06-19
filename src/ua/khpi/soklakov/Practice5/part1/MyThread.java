package ua.khpi.soklakov.Practice5.part1;

public class MyThread extends Thread {

	public void run() {
		try {
			int count = 0;
			while (count <= 10) {
				count++;
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();

		}

	}
}
