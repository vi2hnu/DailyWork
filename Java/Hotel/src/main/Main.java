package main;
import java.util.*;
import hotel.Hotel;
import user.User;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		//NOTE: hardcoded hotel values which needs to be replaced by database
		
		Hotel chennaiHotel1 = new Hotel("Taj Chennai", "Chennai", 20);
        Hotel chennaiHotel2 = new Hotel("ITC Grand Chennai", "Chennai", 20);
        Hotel bangaloreHotel1 = new Hotel("Leela Bangalore", "Bangalore", 20);
        
        Map<String, Hotel[]> cityHotels = new HashMap<>();
        cityHotels.put("chennai", new Hotel[]{chennaiHotel1, chennaiHotel2});
        cityHotels.put("bangalore", new Hotel[]{bangaloreHotel1});
        
        // ----
        
        System.out.println("Enter your name and destination");
        String name = input.next();
        String destination = input.next();
        
        User user = new User(name,destination);
        boolean exit = false;
        while(!exit) {
        	System.out.println("1)book rooms\n2)Change destination\n3)exit");
        	int choice = input.nextInt();
        	switch(choice) {
        	case 2:
        		System.out.println("Enter your new destination:");
        		String newDestination = input.next();
        		user.setNewDestination(newDestination);
        	case 1:
        		if(!cityHotels.containsKey(user.getDestination())) {
                	System.out.println("No hotels in destination, kindly change destination");
                	continue;
                }
        		System.out.println("Select a hotel and number of rooms needed:");
            	for(int i=0;i<cityHotels.get(user.getDestination()).length;i++) {
            		System.out.println((int)i+1+") "+cityHotels.get(user.getDestination())[i].getName()+", Rooms: "+cityHotels.get(user.getDestination())[i].getAvailableRooms());
            	}
            	int userChoice = input.nextInt();
            	int userRooms = input.nextInt();
            	if(cityHotels.get(user.getDestination())[userChoice-1].bookRoom(userRooms)) {
            		System.out.println("Booking Success");
            	}
            	else {
            		System.out.println("There is not enough rooms in the selected hotel to accomidate your request, kindly select a different hotel or different destination");
            	}
            	break;
        	case 3:
        		exit = true;
        		break;
        	}
        		
        }
        input.close();
	}
}
