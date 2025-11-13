package hotel;

public class Hotel {
	int rooms;
	public Hotel() {
		this.rooms = 1; // just for this session demonstration i am using only 1 room
	}
	
	public boolean book() {
		if(rooms==1) {
			rooms--;
			return true;
		}
		return false;
	}
}
