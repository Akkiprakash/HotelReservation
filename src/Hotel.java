import java.util.ArrayList;

public class Hotel {
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();

//    public Hotel() {
//        rooms = new ArrayList<>();
//        bookings = new ArrayList<>();
//    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void showAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    public Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public void bookRoom(String customerName, int roomNumber) {
        Room room = findRoomByNumber(roomNumber);
        if (room != null && room.isAvailable()) {
            Booking booking = new Booking(customerName, roomNumber);
            bookings.add(booking);
            room.setAvailable(false);
            System.out.println("Room " + roomNumber + " booked successfully for " + customerName);
        } else {
            System.out.println("Room " + roomNumber + " is not available.");
        }
    }

    public void cancelBooking(int roomNumber) {
        Booking bookingToRemove = null;
        for (Booking booking : bookings) {
            if (booking.getRoomNumber() == roomNumber) {
                bookingToRemove = booking;
                break;
            }
        }
        if (bookingToRemove != null) {
            bookings.remove(bookingToRemove);
            Room room = findRoomByNumber(roomNumber);
            if (room != null) {
                room.setAvailable(true);
            }
            System.out.println("Booking for room " + roomNumber + " cancelled.");
        } else {
            System.out.println("No booking found for room " + roomNumber);
        }
    }

    public void showAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }
        System.out.println("Current Bookings:");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}
