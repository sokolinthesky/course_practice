package ua.khpi.soklakov.Practice5.part5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Note!!! Without synchronization this application not work properly!! Most
 * likely a runtime exception will be thrown..
 * 
 */
public class Part52 {

	private static final int ITERATION_NUMBER = 3;

	private static final int READERS_NUMBER = 3;

	// shared resource (not thread-safe!!!)
	private static final StringBuilder BUFFER = new StringBuilder();
	
	static final Lock WRITER_LOCK = new ReentrantLock();
	static final Condition WRITER_CONDITION = WRITER_LOCK.newCondition();

	static final Lock READER_LOCK = new ReentrantLock();
	static final Condition READER_CONDITION = READER_LOCK.newCondition();

	private static boolean isWriter = false;
	
	private static boolean isReader = false;

	private static final int BUFFER_LENGTH = 5;

	// speed parameter
	private static final int PAUSE = 5;

	private static boolean flag;

	// reader
	private static class Reader extends Thread {

		public void run() {
			while (!flag) {
				try {
					READER_LOCK.lock();
					// read from the buffer
					if (isWriter) {
						read(getName());
					}
					READER_CONDITION.await();

					WRITER_LOCK.lock();
					WRITER_CONDITION.signal();
					isReader = true;
					WRITER_LOCK.unlock();
					READER_LOCK.unlock();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	private static class Writer extends Thread {
		public void run() {
			int count = 0;
			while (!flag) {
				try {
					READER_LOCK.lock();
					write();
					isWriter = true;
					READER_CONDITION.signalAll();
					READER_LOCK.unlock();

					WRITER_LOCK.lock();
					while (!isReader) {
						WRITER_CONDITION.await();
					}
					WRITER_LOCK.unlock();
					sleep(5);

				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				} finally {
					READER_LOCK.lock();
					count++;
					if (count == ITERATION_NUMBER) {
						flag = true;
						READER_CONDITION.signalAll();
					}
					READER_LOCK.unlock();
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

	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// create writer
		Writer writer = new Writer();

		// create readers
		List<Thread> readers = new ArrayList<>();
		for (int j = 0; j < READERS_NUMBER; j++) {
			readers.add(new Reader());
		}

		// start readers
		Thread.sleep(10);
		for (Thread reader : readers) {
			reader.start();
		}

		// start writer
		Thread.sleep(10);
		writer.start();

		// main thread is waiting for the child threads
		writer.join();
		for (Thread reader : readers) {
			reader.join();
		}
	}

}
