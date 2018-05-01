package parkinglot;

public class ParkingSpot {
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int row;
	private int spotNumber;

	public ParkingSpot(int r, int n, VehicleSize s) {
		this.row = r;
		this.spotNumber = n;
		this.spotSize = s;
	}

	public boolean isAvailable() {
		return this.vehicle == null ? true : false;
	}

	public boolean canFitVehicle(Vehicle vehicle) {
		if (vehicle.size == VehicleSize.Motorcycle) {
			return true;
		}
		if (this.spotSize == vehicle.size) {
			return true;
		}
		return false;
	}

	public boolean park(Vehicle v) {
		this.vehicle = v;
		return true;
	}

	public int getRow() {
		return this.row;
	}

	public VehicleSize getspotSize() {
		return this.spotSize;
	}

	public int getSpotNumber() {
		return this.spotNumber;
	}

	public void removeVehicle() {
		this.vehicle = null;
	}

	public Vehicle getvehicle() {
		return this.vehicle;
	}
}