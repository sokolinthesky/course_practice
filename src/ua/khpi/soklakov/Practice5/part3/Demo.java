package ua.khpi.soklakov.Practice5.part3;

public class Demo {
	
	public static void main(String[] args) {
		Part3 part3 = new Part3();
		
		System.out.println("Sync method.");
		for (int i = 0; i < 5;  i++) {
			new Thread() {
				public void run() {
					part3.part3sync();
				}
			}.start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Not sync method.");
		for (int i = 0; i < 5;  i++) {
			new Thread() {
				public void run() {
					part3.part3();
					
				}
			}.start();
		}
	}

}
