package com.example.parkingsystem.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Main {
	
	private String name;
    private String email;
    private List<Booking> bookings;

    public Main(String name, String email) {
        this.name = name;
        this.email = email;
        this.bookings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}

// Class to represent a Parking Spot
class ParkingSpot {
    private String spotId;
    private String location;
    private boolean isAvailable;

    public ParkingSpot(String spotId, String location) {
        this.spotId = spotId;
        this.location = location;
        this.isAvailable = true;
    }

    public String getSpotId() {
        return spotId;
    }

    public String getLocation() {
        return location;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

// Class to represent a Booking
class Booking {
    private int bookingId;
    private String userId;
    private String spotId;
    private long bookingTime;

    public Booking(int bookingId, String userId, String spotId, long bookingTime) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.spotId = spotId;
        this.bookingTime = bookingTime;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public String getSpotId() {
        return spotId;
    }

    public long getBookingTime() {
        return bookingTime;
    }
}

// Main Parking System class
class ParkingSystem {
    private Map<String, Main> users;
    private Map<String, ParkingSpot> parkingSpots;
    private List<Booking> bookings;
    private int nextBookingId;

    public ParkingSystem() {
        users = new HashMap<>();
        parkingSpots = new HashMap<>();
        bookings = new ArrayList<>();
        nextBookingId = 1;
    }

    // Method to register a new user
    public void registerUser(String name, String email) {
        Main newUser = new Main(name, email);
        users.put(email, newUser);
    }

    // Method to add a new parking spot
    public void addParkingSpot(String spotId, String location) {
        ParkingSpot newSpot = new ParkingSpot(spotId, location);
        parkingSpots.put(spotId, newSpot);
    }

    // Method to search for available parking spots
    public List<ParkingSpot> searchAvailableSpots() {
        List<ParkingSpot> availableSpots = new ArrayList<>();
        for (ParkingSpot spot : parkingSpots.values()) {
            if (spot.isAvailable()) {
                availableSpots.add(spot);
            }
        }
        return availableSpots;
    }

    // Method to book a parking spot
    public boolean bookParkingSpot(String userEmail, String spotId, long bookingTime) {
        Main user = users.get(userEmail);
        if (user == null) {
            return false; // User not found
        }

        ParkingSpot spot = parkingSpots.get(spotId);
        if (spot == null || !spot.isAvailable()) {
            return false; // Spot not found or not available
        }

        spot.setAvailable(false);
        Booking newBooking = new Booking(nextBookingId++, userEmail, spotId, bookingTime);
        bookings.add(newBooking);
        user.getBookings().add(newBooking);
        return true;
    }

    // Method to cancel a booking
    public boolean cancelBooking(String userEmail, int bookingId) {
        Main user = users.get(userEmail);
        if (user == null) {
            return false; // User not found
        }

        Booking bookingToRemove = null;
        for (Booking booking : user.getBookings()) {
            if (booking.getBookingId() == bookingId) {
                bookingToRemove = booking;
                break;
            }
        }

        if (bookingToRemove == null) {
            return false; // Booking not found
        }

        user.getBookings().remove(bookingToRemove);
        ParkingSpot spot = parkingSpots.get(bookingToRemove.getSpotId());
        if (spot != null) {
            spot.setAvailable(true);
        }
        bookings.remove(bookingToRemove);
        return true;
    }
}

// Main class to test the Parking System
 public class Main {
    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem();

        // Register users
        parkingSystem.registerUser("Swarupa Dey", "keyaswarupa@gmail.com");
        parkingSystem.registerUser("Rajashree Adhikary", "AdhikaryRajashree@gmail.com");

        // Add parking spots
        parkingSystem.addParkingSpot("A", "Main Street");
        parkingSystem.addParkingSpot("B", "Park Avenue");
        parkingSystem.addParkingSpot("C", "Central Square");

        // Search and book available spots
        List<ParkingSpot> availableSpots = parkingSystem.searchAvailableSpots();
        if (availableSpots.isEmpty()) {
            System.out.println("No available parking spots.");
        } else {
            ParkingSpot spotToBook = availableSpots.get(0);
            boolean bookingStatus = parkingSystem.bookParkingSpot("john@example.com", spotToBook.getSpotId(), System.currentTimeMillis());
            if (bookingStatus) {
                System.out.println("Booking successful. Spot ID: " + spotToBook.getSpotId());
            } else {
                System.out.println("Booking failed.");
            }
        }
    }
}