package parkinglot;

public class Bus extends Vehicle {
	public Bus() {
		spotsNeeded = 5;
		size = VehicleSize.Large;
	}

	public boolean canFitinSpot(ParkingSpot spot) {
		if (spot.isAvailable()) {
			return true;
		}
		return false;
	}

}