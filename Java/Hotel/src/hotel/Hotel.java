package hotel;

public class Hotel {
	String hotelName;
	String destination;
	int availableRooms;
	
	public Hotel(String hotelName,String destination,int availableRooms){
		this.hotelName = hotelName;
		this.destination = destination;
		this.availableRooms = availableRooms;
	}
	
	public String getName() {
		return hotelName;
	}
	
	public int getAvailableRooms() {
		return availableRooms;
	}
	
	public boolean bookRoom(int roomsNeeded) {
		if(availableRooms-roomsNeeded<0) {
			return false;
		}
		availableRooms-=roomsNeeded;
		return true;
	}
}
