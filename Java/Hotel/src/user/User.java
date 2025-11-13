package user;

public class User {
	String name;
	String destination;
	
	public User(String name,String destination){
		this.name = name;
		this.destination = destination;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setNewDestination(String newDestination) {
		destination = newDestination;
	}
}
