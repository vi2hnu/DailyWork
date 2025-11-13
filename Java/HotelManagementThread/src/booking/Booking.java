package booking;
import hotel.Hotel;
import java.util.concurrent.locks.ReentrantLock;

public class Booking extends Thread{
	String user;
    final Hotel hotel;
    ReentrantLock lock;
	
	
	public Booking(String user,Hotel hotel,ReentrantLock lock) {
		this.user = user;
		this.hotel = hotel;
		this.lock = lock;
	}
	
	public void run() {
		lock.lock();
		try {
			if(hotel.book()==true) {
				System.out.println("Hotel has been booked successfully by "+user);
			}
			else {
				System.out.println("All rooms has been booked");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally{
			lock.unlock();
		}
	}
}
