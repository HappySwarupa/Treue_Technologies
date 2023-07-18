import java.util.ArrayList;
import java.util.List;

// User class
class User {
    private String username;
    private String email;
    private boolean isServiceProvider;

    // Constructor, getters, setters, etc.
}

// Appointment class
class Appointment {
    private User customer;
    private User serviceProvider;
    private String date;
    private String time;

    // Constructor, getters, setters, etc.
}

// AppointmentScheduler class
class AppointmentScheduler {
    private List<Appointment> appointments;

    public AppointmentScheduler() {
        appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment) {
        // Add appointment to the list
    }

    public List<Appointment> getAppointmentsForUser(User user) {
		return appointments;
        // Return appointments for a specific user (service provider or customer)
    }

    public List<Appointment> getAvailableAppointments() {
		return appointments;
        // Return available appointments from the list
    }

    // Other methods for managing appointments
}

// EmailService class
class EmailService {
    public void sendConfirmationEmail(User user, Appointment appointment) {
        // Send confirmation email to the user with appointment details
    }
}

// Main class (for demonstration purposes)
public class AppointmentSchedulingSystem {
    public static void main(String[] args) {
        // Create some users (service providers and customers)
        User serviceProvider1 = new User("service_provider1", "provider1@example.com", true);
        User customer1 = new User("customer1", "customer1@example.com", false);

        // Create an appointment scheduler
        AppointmentScheduler scheduler = new AppointmentScheduler();

        // Create and add some appointments
        Appointment appointment1 = new Appointment(customer1, serviceProvider1, "2023-07-18", "10:00 AM");
        scheduler.addAppointment(appointment1);

        // Retrieve available appointments and appointments for specific users
        List<Appointment> availableAppointments = scheduler.getAvailableAppointments();
        List<Appointment> serviceProvider1Appointments = scheduler.getAppointmentsForUser(serviceProvider1);

        // Perform other operations like user registration, email notifications, etc.

        // Send confirmation email for the appointment
        EmailService emailService = new EmailService();
        emailService.sendConfirmationEmail(customer1, appointment1);
    }
}