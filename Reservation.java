import java.time.LocalDate;
import java.util.*;
public class Reservation {
	
	private int reservationId; 
	private Guest guest; 
	private Room room; 
	private LocalDate checkIn;  
	private LocalDate checkOut; 
	private String status; 
	
	public Reservation(int reservationId,Guest guest,Room room,LocalDate checkIn,
			LocalDate checkOut,String status) {
		
		this.reservationId = reservationId; 
		this.guest = guest; 
		this.room = room; 
		this.checkIn = checkIn; 
		this.checkOut = checkOut; 
		this.status = status; 
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		  return "\n==== RESERVATION INFORMATION ====" +
		           "\nReservation ID: " + reservationId +
		           "\nGuest: " + guest.getfName() + " " + guest.getlName() +
		           "\nRoom Number: " + room.getRoomNumber() +
		           "\nCheck In: " + checkIn +
		           "\nCheck Out: " + checkOut +
		           "\nStatus: " + status;
	}
	


}
