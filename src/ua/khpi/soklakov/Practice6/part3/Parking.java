package ua.khpi.soklakov.Practice6.part3;

public class Parking {

	/**
	 * Parking places.
	 */
	private Car[] places;

	/**
	 * Constructor sets number of places.
	 * 
	 * @param n
	 *            number of places.
	 */
	public Parking(int n) {
		places = new Car[n];
	}

	/**
	 * Method services car arrival.
	 * 
	 * @param car
	 *            specified car.
	 */
	public void getPlace(Car car) {
		for (int i = 0; i < places.length; i++) {
			System.out.println(car.getModel() + " drive to " + i + " place.");
			if (places[i] == null) {
				System.out.println("Place " + i + " free. Stop here.");
				places[i] = car;
				break;
			} else {
				System.out.println("Place reserved.");
			}
		}
	}

	/**
	 * Method services car leaving.
	 * 
	 * @param car
	 *            specified car.
	 */
	public void leavePlace(Car car) {
		for (int i = 0; i < places.length; i++) {
			if (places[i].equals(car)) {
				places[i] = null;
				System.out.println(car + "leave " + i + " place.");
				break;
			}
		}

	}

	/**
	 * Method return parking state.
	 * 
	 * @return parking state.
	 */
	public String getParkingState() {
		String result = "PARKING STATE\n";

		for (int i = 0; i < places.length; i++) {
			if (places[i] != null) {
				result = result.concat("Place" + (i + 1) + " - [ " + places[i] + " ]\n");
			} else {
				result = result.concat("Place" + (i + 1) + " - [ free ]\n");
			}
		}

		return result;
	}

}
