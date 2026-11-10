import java.time.LocalDate;
import java.util.Scanner;

public class MainHotel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner input = new Scanner(System.in);

	        HotelManager hotel = new HotelManager();

	        // Create rooms
	        Room r1 = new Room(101, "Suite", 150.00, 2, 1);
	        Room r2 = new Room(202, "Deluxe", 200.00, 4, 2);
	        Room r3 = new Room(303, "Standard", 100.00, 2, 3);

	        // Create guests
	        Guest g1 = new Guest(9999, "Scarlett", "Peralta",
	                "sp@gmail.com", "7189029389");

	        Guest g2 = new Guest(1001, "John", "Smith",
	                "john@gmail.com", "5551234567");

	        // Add rooms and guests
	        hotel.addRoom(r1);
	        hotel.addRoom(r2);
	        hotel.addRoom(r3);

	        hotel.addGuest(g1);
	        hotel.addGuest(g2);

	        // Create an existing reservation
	        Reservation re1 = new Reservation(
	                670, g1, r1,
	                LocalDate.of(2026, 11, 12),
	                LocalDate.of(2026, 11, 16),
	                "Confirmed"
	        );

	        hotel.addReservation(re1);

	        int choice = 0;

	        while (choice != 5) {

	            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
	            System.out.println("1. Display Rooms");
	            System.out.println("2. Display Reservations");
	            System.out.println("3. Find a Room");
	            System.out.println("4. Check Room Availability");
	            System.out.println("5. Exit");
	            System.out.println("6. Make a Reservation");
	            System.out.println("7. Cancel a Reservation");

	            System.out.print("Enter your choice: ");

	            choice = readInt(input);

	            switch (choice) {

	                case 1:

	                    hotel.displayRooms();
	                    break;

	                case 2:

	                    hotel.displayReservations();
	                    break;

	                case 3:

	                    System.out.print("Enter room number: ");
	                    int roomNumber = readInt(input);

	                    Room room = hotel.findRoom(roomNumber);

	                    if (room != null) {
	                        System.out.println(room);
	                    } else {
	                        System.out.println("Room not found.");
	                    }

	                    break;

	                case 4:

	                    System.out.print("Enter room number: ");
	                    int searchRoom = readInt(input);

	                    System.out.print("Enter check-in date (YYYY-MM-DD): ");
	                    LocalDate checkIn = readDate(input);

	                    System.out.print("Enter check-out date (YYYY-MM-DD): ");
	                    LocalDate checkOut = readDate(input);

	                    if (!checkOut.isAfter(checkIn)
	                            || checkIn.isBefore(LocalDate.now())) {

	                        System.out.println("Invalid reservation dates.");

	                    } else {

	                        boolean available = hotel.isRoomAvailable(
	                                searchRoom, checkIn, checkOut);

	                        if (available) {
	                            System.out.println("Room is available!");
	                        } else {
	                            System.out.println("Room is unavailable.");
	                        }
	                    }

	                    break;

	                case 5:

	                    System.out.println("Thank you for using our hotel system!");
	                    break;

	                case 6:

	                    System.out.print("Enter Guest ID: ");
	                    int guestID = readInt(input);

	                    System.out.print("Enter Room Number: ");
	                    int newRoomNumber = readInt(input);

	                    Guest guest = hotel.findGuest(guestID);
	                    Room selectedRoom = hotel.findRoom(newRoomNumber);

	                    if (guest == null) {
	                        System.out.println("Guest not found.");
	                        break;
	                    }

	                    if (selectedRoom == null) {
	                        System.out.println("Room not found.");
	                        break;
	                    }

	                    System.out.print("Enter Check-In Date (YYYY-MM-DD): ");
	                    LocalDate newCheckIn = readDate(input);

	                    System.out.print("Enter Check-Out Date (YYYY-MM-DD): ");
	                    LocalDate newCheckOut = readDate(input);

	                    if (newCheckIn.isBefore(LocalDate.now())
	                            || !newCheckOut.isAfter(newCheckIn)) {

	                        System.out.println("Invalid reservation dates.");
	                        break;
	                    }

	                    Reservation newReservation = new Reservation(
	                            672, guest, selectedRoom,
	                            newCheckIn, newCheckOut, "Confirmed"
	                    );

	                    boolean success = hotel.makeReservation(newReservation);

	                    if (success) {
	                        System.out.println("Reservation successful!");
	                    } else {
	                        System.out.println("Room is unavailable.");
	                    }

	                    break;

	                case 7:

	                    System.out.print("Enter Reservation ID: ");
	                    int reservationID = readInt(input);

	                    boolean cancelled = hotel.cancelReservation(reservationID);

	                    if (cancelled) {
	                        System.out.println("Reservation cancelled successfully!");
	                    } else {
	                        System.out.println("Reservation not found.");
	                    }

	                    break;

	                default:

	                    System.out.println("Invalid choice. Try again.");
	            }
	        }

	        input.close();
	    }

	    // Method for validating integer input
	    public static int readInt(Scanner input) {

	        while (true) {

	            try {
	                return Integer.parseInt(input.nextLine());

	            } catch (NumberFormatException e) {

	                System.out.print("Invalid input. Enter a number: ");
	            }
	        }
	    }

	    // Method for validating date input
	    public static LocalDate readDate(Scanner input) {

	        while (true) {
	            try {
	                return LocalDate.parse(input.nextLine());
	            } catch (Exception e) {
	               System.out.print("Invalid date. Enter YYYY-MM-DD: ");
	            }
	        }
		
	}

}
