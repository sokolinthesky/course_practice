package ua.khpi.soklakov.Practice5.part5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Part52 {

	private static final int ITERATION_NUMBER = 3;

	private static final int READERS_NUMBER = 3;

	// shared resource (not thread-safe!!!)
	private static final StringBuilder BUFFER = new StringBuilder();

	private static final int BUFFER_LENGTH = 5;

	// speed parameter
	private static final int PAUSE = 5;

	// stop signal
	private static boolean stop;

	private static final Lock lock = new ReentrantLock();
	private static final Condition CONDITION = lock.newCondition();
	
	private static int readerCount = 0;
	private static int writerCount = 0;

	// reader
	private static class Reader extends Thread {
		public void run() {
			while (!stop) {
				try {

					// read from the buffer
					read(getName());

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// writer
	private static class Writer extends Thread {
		public void run() {
			int tact = 0;
			while (!stop) {
				try {

					// write to the buffer
					write();

				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					if (++tact == ITERATION_NUMBER) {
						stop = true;
					}
				}
			}
		}
	}

	private static void read(String threadName) throws InterruptedException {
		if (writerCount != READERS_NUMBER) {
			lock.lock();
			try {
				readerCount++;
				CONDITION.await();
				System.out.printf("Reader %s:", threadName);
				for (int j = 0; j < BUFFER_LENGTH; j++) {
					Thread.sleep(PAUSE);
					System.out.print(BUFFER.charAt(j));
				}
				System.out.println();
				if (readerCount == READERS_NUMBER) {
					readerCount = 0;
					CONDITION.signalAll();
				}
				Thread.sleep(5);
			} finally {
				lock.unlock();
			}
		}
	}

	private static void write() throws InterruptedException {
		lock.lock();
		try {
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
			writerCount++;
			
			CONDITION.signalAll();
			CONDITION.await();
			Thread.sleep(5);
		} finally {
			lock.unlock();
		}

	}

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
