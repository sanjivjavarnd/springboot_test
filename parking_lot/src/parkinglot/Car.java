package parkinglot;

public class Car extends Vehicle {
	public Car() {
		spotsNeeded = 1;
		size = VehicleSize.Compact;
	}

	public boolean canFitinSpot(ParkingSpot spot) {
		if (spot.isAvailable()) {
			return true;
		}
		return false;
	}
}