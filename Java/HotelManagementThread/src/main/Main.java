package main;
import java.util.concurrent.locks.ReentrantLock;

import booking.Booking;
import hotel.Hotel;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hotel hotel = new Hotel();
		ReentrantLock lock = new ReentrantLock();
		Booking user1 = new Booking("User1",hotel,lock);
		Booking user2 = new Booking("User2",hotel,lock);
		Booking user3 = new Booking("User3",hotel,lock);
		
		user1.run();
		user2.run();
		user3.run();
	}

}
