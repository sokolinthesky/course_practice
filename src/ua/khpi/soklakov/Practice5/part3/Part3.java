package ua.khpi.soklakov.Practice5.part3;

/**
 * Part3.
 * 
 * @author O.Soklakov
 *
 */
public class Part3 {

	private int firstCount;
	private int secondCount;

	/**
	 * Maint method. Test.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final Part3 p3 = new Part3();

		System.out.println("Sync method input: ");
		for (int i = 0; i < 5; i++) {
			new Thread() {
				public void run() {
					try {
						p3.synchronizedPart3();
					} catch (InterruptedException e) {
						System.out.println("InterruptedException in main");
					}
				}
			}.start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Thread exception");
		}
		System.out.println("No synchronized method input: ");
		for (int i = 0; i < 5; i++) {
			new Thread() {
				public void run() {
					p3.noSyncPart3();

				}
			}.start();
		}

	}

	/**
	 * Increment firstCount field.
	 */
	public void incremFirstCount() {
		this.firstCount++;
	}

	/**
	 * Increment secondCount field.
	 */
	public void incremSecondCount() {
		this.secondCount++;
	}

	/**
	 * Method compare two counts and return result.
	 * 
	 * @return true if counts equals, else false.
	 */
	public boolean compareAndPrint() {
		return (this.firstCount == this.secondCount);
	}

	/**
	 * Method compare two counts and print result.
	 */
	public void noSyncPart3() {
		System.out.println(compareAndPrint());
		incremFirstCount();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			System.out.println("InterruptedException in noSyncPart3");
		}
		incremSecondCount();
	}

	/**
	 * Synchronized method compare two counts and print result.
	 * 
	 * @throws InterruptedException
	 */
	public synchronized void synchronizedPart3() throws InterruptedException {
		System.out.println(compareAndPrint());
		incremFirstCount();
		Thread.sleep(10);
		incremSecondCount();
	}

}
