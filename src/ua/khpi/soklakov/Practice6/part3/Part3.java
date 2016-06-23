package ua.khpi.soklakov.Practice6.part3;

public class Part3 {

	/**
	 * Main method. Test parking.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Parking parking = new Parking(10);
		Car car1 = new Car("Opel", "1232282348");
		Car car2 = new Car("Nissan", "1232282348");
		Car car3 = new Car("Porche", "2282312348");
		Car car4 = new Car("Aston", "2282132348");
		Car car5 = new Car("Toyota", "222321348");

		parking.getPlace(car1);
		parking.getPlace(car2);
		parking.getPlace(car3);
		parking.getPlace(car4);
		parking.getPlace(car5);

		parking.leavePlace(car3);

		System.out.println(parking.getParkingState());
	}

}
