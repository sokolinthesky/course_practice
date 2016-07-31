package ua.khpi.soklakov.Practice5.part2;

/**
 * Spam class
 * @author Soklakov O.
 *
 */
public class Spam implements Runnable {

	private int index;
	static final String[] SPAM_MESSAGES = { "Spam1", "Spam2", "Spam3", "Spam4" };
	static final int[] SPAM_TIMES = { 500, 500, 400, 200 };

	public Spam(int index) {
		this.index = index;
	}

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < SPAM_TIMES.length; i++) {
			Thread thread = new Thread(new Spam(i));
			thread.setDaemon(true);
			thread.start();
		}

	}

	public void run() {
		while (true) {
			System.out.println(SPAM_MESSAGES[index] + " sleep: " + SPAM_TIMES[index]);
			try {
				Thread.sleep(SPAM_TIMES[index]);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}