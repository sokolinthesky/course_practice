package ua.khpi.soklakov.Practice5.part5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Note!!! Without synchronization this application not work properly!! Most
 * likely a runtime exception will be thrown..
 * 
 */
public class Part51 {

	private static final int READERS_NUM = 3;
	
	private static final int ITERATION_NUMBER = 3;

	// shared resource (not thread-safe!!!)
	private static final StringBuilder BUFFER = new StringBuilder();

	private static final Object WRITER_M = new Object();

	private static final Object READER_M = new Object();
	
	private static boolean bStop;

	private static boolean isRead = false;

	private static boolean bIsWrite = false;

	private static final int BUFFER_LENGTH = 5;

	// speed parameter
	private static final int PAUSE = 5;

	// writer
	private static class Writer extends Thread {
		public void run() {
			int count = 0;
			while (!bStop) {
				try {
					synchronized (READER_M) {
						write();
						bIsWrite = true;
						READER_M.notifyAll();
					}
					synchronized (WRITER_M) {
						while (!isRead) {
							WRITER_M.wait();
						}

					}
					sleep(5);

				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				} finally {
					synchronized (READER_M) {
						count++;
						if (count == ITERATION_NUMBER) {
							bStop = true;
							READER_M.notifyAll();
						}
					}
				}
			}
		}
	}

	// reader
	private static class Reader extends Thread {

		public void run() {
			while (!bStop) {
				synchronized (READER_M) {
					try {
						// read from the buffer
						if (bIsWrite) {
							read(getName());
						}
						READER_M.wait();
						synchronized (WRITER_M) {
							WRITER_M.notify();
							isRead = true;
						}
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
			}

		}
	}

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
		for (int j = 0; j < READERS_NUM; j++) {
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

	/**
	 * Reading method.
	 * 
	 * @param threadName
	 *            specified thread.
	 * @throws InterruptedException
	 */
	private static void read(String threadName) throws InterruptedException {
		System.out.printf("Reader %s:", threadName);
		for (int j = 0; j < BUFFER_LENGTH; j++) {
			Thread.sleep(PAUSE);
			System.out.print(BUFFER.charAt(j));
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
		BUFFER.setLength(0);

		// write to buffer
		System.err.print("Writer writes:");

		Random random = new Random();
		for (int j = 0; j < BUFFER_LENGTH; j++) {
			Thread.sleep(PAUSE);
			char ch = (char) ('A' + random.nextInt(26));
			System.err.print(ch);
			BUFFER.append(ch);
		}
		System.err.println();
		Thread.sleep(5);
	}
}