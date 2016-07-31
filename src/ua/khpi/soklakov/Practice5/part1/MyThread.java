package ua.khpi.soklakov.Practice5.part1;

/**
 * First thread.
 * 
 * @author O.Soklakov
 *
 */
public class MyThread extends Thread {

	@Override
	public void run() {
		try {
			int count = 0;
			while (count <= 10) {
				count++;
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("InterruptedException in run");

		}

	}
}
