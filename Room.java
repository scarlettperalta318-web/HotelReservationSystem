
public class Room {

	private int roomNumber, capacity, floor; 
	private String roomType; 
	private double nightlyRate; 
	
	public Room(int roomNumber,String roomType,double nightlyRate,int capacity, int floor) {
		this.roomNumber = roomNumber; 
		this.roomType = roomType; 
		this.nightlyRate = nightlyRate; 
		this.capacity = capacity; 
		this.floor = floor; 
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getNightlyRate() {
		return nightlyRate;
	}

	public void setNightlyRate(double nightlyRate) {
		this.nightlyRate = nightlyRate;
	}

	@Override
	public String toString() {
		return "roomNumber: " + roomNumber
				+ "\ncapacity: " + capacity + 
				"\nfloor: " + floor +
				"\nroomType: "+ roomType + 
				"\nNightlyRate: " + nightlyRate;
	}
	
}
