package ua.khpi.soklakov.Practice5.part3;

public class Part3 {

	private int firstCount;
	private int secondCount;

	public static void main(String[] args) {
		
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
		if (this.firstCount == this.secondCount) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method compare two counts and print result.
	 */
	public void part3() {
		System.out.println(compareAndPrint());
		incremFirstCount();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		incremSecondCount();
	}

	/**
	 * Synchronized method compare two counts and print result.
	 */
	public synchronized void part3sync() {
		System.out.println(compareAndPrint());
		incremFirstCount();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		incremSecondCount();
	}

}
