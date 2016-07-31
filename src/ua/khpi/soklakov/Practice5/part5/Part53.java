package ua.khpi.soklakov.Practice5.part5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Note!!! Without synchronization this application not work properly!! Most
 * likely a runtime exception will be thrown..
 * 
 */
public class Part53 {

	static final Lock MONITOR = new ReentrantLock(true);
	
	private static final int ITERATION_NUMBER = 3;

	private static final int READERS = 3;

	// shared resource (not thread-safe!!!)
	private static final StringBuilder MY_BUFFER = new StringBuilder();
	
	private static boolean bIsWrite = false;

	private static boolean bStop;
	
	// speed parameter
	private static final int I_PAUSE = 5;

	private static final int LENGTH_BUFFER = 5;
	
	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// create writer
		Writer wWriter = new Writer();

		// create readers
		List<Thread> lReaders = new ArrayList<>();
		for (int i = 0; i < READERS; i++) {
			lReaders.add(new Reader());
		}

		// start readers
		Thread.sleep(10);
		for (Thread rReader : lReaders) {
			rReader.start();
		}

		// start writer
		Thread.sleep(10);
		wWriter.start();

		// main thread is waiting for the child threads
		wWriter.join();
		for (Thread rReader : lReaders) {
			rReader.join();
		}
	}

	// reader
	private static class Reader extends Thread {

		public void run() {
			while (!bStop) {
				try {
					MONITOR.lock();
					// read from the buffer
					if (bIsWrite) {
						read(getName());
					}

				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				} finally {
					MONITOR.unlock();
				}
			}
		}
	}

	// writer
	private static class Writer extends Thread {
		public void run() {
			int iCount = 0;
			while (!bStop) {
				try {
					MONITOR.lock();
					write();
					bIsWrite = true;
					sleep(5);

				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				} finally {
					iCount++;
					if (iCount == ITERATION_NUMBER) {
						bStop = true;
					}
					MONITOR.unlock();

				}
			}
		}
	}

	/**
	 * Reading method.
	 * 
	 * @param threadName
	 *            specified thread.
	 * @throws InterruptedException
	 */
	private static void read(String threadName) throws InterruptedException {
		System.out.printf("Reader %s:", threadName);
		for (int i = 0; i < LENGTH_BUFFER; i++) {
			Thread.sleep(I_PAUSE);
			System.out.print(MY_BUFFER.charAt(i));
		}
		System.out.println();
		Thread.sleep(5);
	}

	/**
	 * Writing method.
	 * 
	 * @throws InterruptedException
	 */
	private static void write() throws InterruptedException {
		// clear buffer
		MY_BUFFER.setLength(0);

		// write to buffer
		System.err.print("Writer writes:");

		Random rRandom = new Random();
		for (int i = 0; i < LENGTH_BUFFER; i++) {
			Thread.sleep(I_PAUSE);
			char ch = (char) ('A' + rRandom.nextInt(26));
			System.err.print(ch);
			MY_BUFFER.append(ch);
		}
		System.err.println();
		Thread.sleep(5);
	}
}
