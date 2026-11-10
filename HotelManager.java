import java.time.LocalDate;
import java.util.ArrayList;

public class HotelManager {
	
	private ArrayList<Room> rooms; 
	private ArrayList<Guest> guests; 
	private ArrayList<Reservation> reservations; 
	
	public HotelManager() {
		rooms = new ArrayList();
		guests = new ArrayList();
		reservations = new ArrayList();
	}
	
	public void addRoom(Room room) {
		rooms.add(room);
	}
	public void addGuest(Guest guest) {
		guests.add(guest);
	}
	public void addReservation(Reservation reservation) {
		reservations.add(reservation);
	}
	
	public void displayRooms() {
		if(rooms.isEmpty()) {
			System.out.println("No rooms available");
		}
		else {
			System.out.println("==== HOTEl ROOMS ====");
			for(Room room: rooms) {
				 System.out.println(room);
		            System.out.println("--------------------");
			}
		}
		
	}
	public void displayReservations() {
		if(reservations.isEmpty()) {
			System.out.println("No reservations found");
		}
		else {
			System.out.println("==== HOTEl RESERVATIONS ====");
			for(Reservation reservation: reservations) {
				System.out.println(reservations);
	            System.out.println("--------------------");
			}
		}
		
	}
	public boolean makeReservation(Reservation reservation) {

	    int roomNumber = reservation.getRoom().getRoomNumber();

	    boolean available = isRoomAvailable(
	            roomNumber,
	            reservation.getCheckIn(),
	            reservation.getCheckOut()
	    );

	    if (available) {
	        reservations.add(reservation);
	        return true;
	    } else {
	        return false;
	    }
	}
	
	public Room findRoom(int roomNumber) {
		for(Room room: rooms) {
			if(room.getRoomNumber()==roomNumber) {
				return room; 
			}
			
		}
		
		return null; 
	}
	public Boolean isRoomAvailable(int roomNumber,LocalDate checkIn, LocalDate checkOut) {
		Room room = findRoom(roomNumber);
		if(room==null) {
			return false; 
		}
		for(Reservation reservation: reservations) {
			if(reservation.getRoom().getRoomNumber()==roomNumber) {
				if(reservation.getStatus().equals("Confirmed")) {
					if(checkIn.isBefore(reservation.getCheckOut())
							&& checkOut.isAfter(reservation.getCheckIn())) {
						
						return false; 
						
					}
				}
			}
		
		}
		return true; 
		
	}
	public boolean cancelReservation(int reservationID) {

	    for (Reservation reservation : reservations) {
	        if (reservation.getReservationId() == reservationID) {
	           reservation.setStatus("Cancelled");
	            return true;
	        }
	    }
	    return false;
	}
	public Guest findGuest(int guestID) {
	    for (Guest guest : guests) {
	        if (guest.getGuestId() == guestID) {
	            return guest;
	        }
	    }
	    return null;
	}


}
