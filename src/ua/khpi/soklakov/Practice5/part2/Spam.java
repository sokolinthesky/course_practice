package ua.khpi.soklakov.Practice5.part2;

import java.io.IOException;

class Spam extends Thread {
	static private String[] messages;
	static private int[] intervals;

	public Spam() {
	}

	/**
	 * Constructor that fills fields in this class.
	 * 
	 * @param messages
	 *            specified messages.
	 * @param intervals
	 *            specified intervals.
	 */
	public Spam(String[] messages, int[] intervals) {
		Spam.messages = messages;
		Spam.intervals = intervals;
	}

	/**
	 * Start this thread.
	 */
	public void run() {
		while (true) {
			getSpam();
		}
	}

	/**
	 * Main method.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Spam t = new Spam();
		t.setDaemon(true);
		t.start();
		new Thread() {
			public void run() {
				byte[] buffer = new byte[10];
				int count;
				try {
					do {
						while ((count = System.in.read(buffer)) == -1)
							;
					} while (!System.lineSeparator().equals(new String(buffer, 0, count)));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				System.out.println("ENTER has been obtained");
			}
		}.start();
	}

	/**
	 * Method prints spam in the console over time.
	 */
	public static void getSpam() {
		for (int i = 0; i < messages.length; i++) {
			System.out.println(messages[i]);
			try {
				Thread.sleep(intervals[i]);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}