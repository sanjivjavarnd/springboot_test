package parkinglot;

public class ParkVehicleTest {
	public static void main(String[] args) {
		//Vehicle vehicle = new Bus();
		//Vehicle vehicle =new Motorcycle();
		Vehicle vehicle =new Car();
		ParkingLot parkingLot = new ParkingLot();
		ParkingSpot parkingSpot = parkingLot.available(vehicle.size);
		boolean flag = parkingSpot.canFitVehicle(vehicle);
		if (flag) {
			parkingSpot.park(vehicle);
			parkingLot.addParkinSpot(parkingSpot);
			System.out.println("Vehicle parked successfully : " + vehicle);
		} else {
			System.out.println("Unable to parked you vehicle : ");
		}
	}
}
