package parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLot {
	protected static List<ParkingSpot> parkingSpots;
	static {
		parkingSpots = addParkingSpots();
	}

	public void addParkinSpot(ParkingSpot s) {
		parkingSpots.add(s);
	}

	public void clearSpots(ParkingSpot s) {
		if (parkingSpots.get(s.getSpotNumber()) != null || parkingSpots.get(s.getSpotNumber()).getSpotNumber() != 0) {
			ParkingSpot oldParkingSpot = parkingSpots.get(s.getSpotNumber());
			oldParkingSpot = null;
		}
	}

	public Vehicle seachVehicle(String licensePlate) {
		Optional<ParkingSpot> optionalVehicle = parkingSpots.stream()
				.filter(p -> p.getvehicle().licensePlate.equalsIgnoreCase(licensePlate)).findFirst();
		if (!optionalVehicle.isPresent()) {
			return null;
		}
		return optionalVehicle.get().getvehicle();
	}

	public ParkingSpot seachSpot(String licensePlate) {
		Optional<ParkingSpot> optionalVehicle = parkingSpots.stream()
				.filter(p -> p.getvehicle().licensePlate.equalsIgnoreCase(licensePlate)).findFirst();
		if (!optionalVehicle.isPresent()) {
			return null;
		}
		return optionalVehicle.get();
	}

	public void park(Vehicle vehicle) {
		ParkingSpot newSpot = available(vehicle.size);
		newSpot.park(vehicle);
		parkingSpots.add(newSpot);
	}

	public void unpark(Vehicle vehicle) {
		Vehicle parkedVehicle = seachVehicle(vehicle.licensePlate);
		if (parkedVehicle != null) {
			ParkingSpot spot = seachSpot(vehicle.licensePlate);
			if (spot != null) {
				clearSpots(spot);
			}
		}
	}

	public ParkingSpot available(VehicleSize size) {
		// Optional<ParkingSpot> oldSpot = parkingSpots.stream().filter(p ->
		// p.getvehicle() == null).findFirst();
		Optional<ParkingSpot> oldSpot = parkingSpots.stream()
				.filter(p -> p.getspotSize() == size && p.getvehicle() == null).findFirst();
		if (oldSpot.isPresent()) {
			return oldSpot.get();
		}
		Optional<ParkingSpot> spot = parkingSpots.stream().sorted().reduce((firstSpot, secondSpot) -> secondSpot);
		ParkingSpot newSpot = new ParkingSpot(spot.get().getRow() + 1, spot.get().getSpotNumber() + 1, size);
		return newSpot;
	}

	public static List<ParkingSpot> addParkingSpots() {
		List<ParkingSpot> parking = new ArrayList<ParkingSpot>();
		parking.add(new ParkingSpot(1, 1, VehicleSize.Compact));
		parking.add(new ParkingSpot(1, 2, VehicleSize.Compact));
		parking.add(new ParkingSpot(1, 3, VehicleSize.Compact));
		parking.add(new ParkingSpot(1, 4, VehicleSize.Compact));
		parking.add(new ParkingSpot(1, 5, VehicleSize.Compact));
		parking.add(new ParkingSpot(2, 1, VehicleSize.Large));
		parking.add(new ParkingSpot(2, 2, VehicleSize.Large));
		parking.add(new ParkingSpot(2, 3, VehicleSize.Large));
		parking.add(new ParkingSpot(2, 4, VehicleSize.Large));
		parking.add(new ParkingSpot(2, 5, VehicleSize.Large));
		parking.add(new ParkingSpot(3, 1, VehicleSize.Motorcycle));
		parking.add(new ParkingSpot(3, 2, VehicleSize.Motorcycle));
		parking.add(new ParkingSpot(3, 3, VehicleSize.Motorcycle));
		parking.add(new ParkingSpot(3, 4, VehicleSize.Motorcycle));
		parking.add(new ParkingSpot(3, 5, VehicleSize.Motorcycle));
		return parking;
	}

}
