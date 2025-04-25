import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize components
        Scanner scanner = new Scanner(System.in);
        Flight[] flights = {
            new Flight("101", "Boeing 737", 100, 0),
            new Flight("202", "Airbus A320", 150, 0),
            new Flight("303", "Boeing 747", 200, 0)
        };

        boolean running = true;

        // Main program loop
        while (running) {
            int choice = Menu.getMenuChoice(scanner);

            switch (choice) {
                case 1: // Book a flight
                    System.out.println("Available flights:");
                    for (int i = 0; i < flights.length; i++) {
                        System.out.println((i + 1) + ". " + flights[i].getFlighNumber() +
                                " (" + flights[i].getCurrentNumSeats() + "/" + flights[i].getMaxNumSeats() + " seats booked)");
                    }
                    System.out.print("Enter the flight number to book: ");
                    int flightToBook = scanner.nextInt() - 1;
                    if (flightToBook >= 0 && flightToBook < flights.length) {
                        if (flights[flightToBook].bookSeat()) {
                            System.out.println("Flight booked successfully!");
                        } else {
                            System.out.println("No seats available on this flight.");
                        }
                    } else {
                        System.out.println("Invalid flight number.");
                    }
                    break;

                case 2: // Unbook a flight
                    System.out.println("Available flights:");
                    for (int i = 0; i < flights.length; i++) {
                        System.out.println((i + 1) + ". " + flights[i].getFlighNumber() +
                                " (" + flights[i].getCurrentNumSeats() + "/" + flights[i].getMaxNumSeats() + " seats booked)");
                    }
                    System.out.print("Enter the flight number to unbook: ");
                    int flightToUnbook = scanner.nextInt() - 1;
                    if (flightToUnbook >= 0 && flightToUnbook < flights.length) {
                        if (flights[flightToUnbook].unbookSeat()) {
                            System.out.println("Flight unbooked successfully!");
                        } else {
                            System.out.println("No bookings to cancel on this flight.");
                        }
                    } else {
                        System.out.println("Invalid flight number.");
                    }
                    break;

                case 3: // View available flights
                    System.out.println("Available flights:");
                    for (Flight flight : flights) {
                        System.out.println(flight.getFlighNumber() + " (" +
                                flight.getCurrentNumSeats() + "/" + flight.getMaxNumSeats() + " seats booked)");
                    }
                    break;

                case 4: // Quit
                    System.out.println("Thank you for using the flight booking system. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
