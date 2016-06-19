package ua.khpi.soklakov.Practice5.part1;

public class MySecondThread implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
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
