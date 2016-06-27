package ua.khpi.soklakov.Practice5.part2;

class Spam extends Thread {

	private String[] messages = { "spam1", "spam2", "spam3" };
	private int[] intervals = { 100, 400, 300 };
	private boolean flag = true;

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String[] getMessages() {
		return messages;
	}

	public void setMessages(String[] messages) {
		this.messages = messages.clone();
	}

	public int[] getIntervals() {
		return intervals;
	}

	public void setIntervals(int[] intervals) {
		this.intervals = intervals.clone();
	}

	public Spam() {
	}

	/**
	 * Start this thread.
	 */
	public void run() {
		while (flag) {
			getSpam();
		}
	}

	/**
	 * Method prints spam in the console over time.
	 */
	public void getSpam() {
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