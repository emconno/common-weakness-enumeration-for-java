import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    // CWE-493: Critical Public Variable Without Final Modifier
    // CWE-500: Public Static Field Not Marked Final 
    public static final Flight[] flights = {
        new Flight("101", "Boeing 737", 100, 0, "Chicago"),
        new Flight("202", "Airbus A320", 150, 0, "Mexico City"),
        new Flight("303", "Boeing 747", 200, 0, "Paris")
    };

    public static String readCleanLine(Scanner scanner){
        if(scanner.hasNextLine()){
            return scanner.nextLine().trim();
        } else {
            return "";
        }
    }

    public static int readCleanInteger(Scanner scanner){
        int result; 

        while(true){
            if(scanner.hasNextInt()){
                result = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer");
                scanner.nextLine();
            }
        }

        return result;
    }

    public static void handleUserSelection(Flight[] flights, Scanner scanner, int index) {
        try {  // CWE-537: Start of try block
            boolean running = true;
        while (running) {
            int choice = Menu.getMenuChoice(scanner, Menu.getFlightMenu());

            switch (choice) {
                case 1: // Book a flight
                    System.out.println("Available flights:");
                    for (int i = 0; i < flights.length; i++) {
                        System.out.println((i + 1) + ". " + flights[i].getFlighNumber() +
                                " (" + flights[i].getCurrentNumSeats() + "/" + flights[i].getMaxNumSeats() + " seats booked) to " + flights[i].getDestination());
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
                                " (" + flights[i].getCurrentNumSeats() + "/" + flights[i].getMaxNumSeats() + " seats booked) to " + flights[i].getDestination());
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
                            flight.getCurrentNumSeats() + "/" + flight.getMaxNumSeats() + " seats booked) to " + flight.getDestination());
                    }
    
                    // CWE-486: Add compatibility check
                    if (flights.length >= 2) {
                        boolean compatible = flights[0].isAircraftModelCompatible(flights[1]);
                        System.out.println("\nCompatibility Check:");
                        System.out.println(flights[0].getFlighNumber() + " and " + flights[1].getFlighNumber() + " are " + (compatible ? "compatible" : "not compatible"));
                    }
                    break;    

                case 4: // Book by Destination
                    System.out.println("Enter your desired destination:");
                    String desiredDest = scanner.next();

                    ArrayList<Flight> searchResults = new ArrayList<>();
                    for (Flight f : flights) {
                        // CWE-595: Comparison of Object References Instead of Object Contents
                        // Acieved through the use of .equals() to compare String object contents
                        if (desiredDest.toUpperCase().equals(f.getDestination().toUpperCase())) {
                            searchResults.add(f);
                        }
                    }
                    if (searchResults.size() == 0) {
                        System.out.println("No flights to \"" + desiredDest + "\" are available");
                        break;
                    } else {
                        System.out.println("Available flights:");
                        for (int i = 0; i < searchResults.size(); i++) {
                            System.out.println((i + 1) + ". " + flights[i].getFlighNumber() +
                                    " (" + searchResults.get(i).getCurrentNumSeats() + "/" + searchResults.get(i).getMaxNumSeats() + " seats booked) to " + searchResults.get(i).getDestination());
                        }

                        System.out.print("Enter the flight number to book: ");
                        flightToBook = scanner.nextInt() - 1;
                        if (flightToBook >= 0 && flightToBook < searchResults.size()) {
                            if (searchResults.get(flightToBook).bookSeat()) {
                                System.out.println("Flight booked successfully!");
                            } else {
                                System.out.println("No seats available on this flight.");
                            }
                        } else {
                            System.out.println("Invalid flight number.");
                        }
                        break;
                    }
                    
                case 5: // Sign out
                    System.out.println("Signing out");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    } catch (Exception e) {  // CWE-537: Generic error handling
        System.out.println("An error occurred while processing your request.");
    }
}


    public static void main(String[] args) {
    try {  // CWE-537: Start of try block
        // Initialize components
        Scanner scanner = new Scanner(System.in);

        
        boolean outerLoopRunning = true;



        User[] currentUsers = new User[20];

        // Main program loop

        while(outerLoopRunning){
            int choice = Menu.getMenuChoice(scanner, Menu.getUserMenuItems());

            switch(choice){
                case 1:

                    //run code for create an account
                    System.out.println("Enter your name: ");
                    String name = readCleanLine(scanner);

                    System.out.println("name entered: " + name);
                    System.out.println("Enter your age");
                    int age = Menu.getIntegerInput(scanner);
                    System.out.println("Enter password");
                    
                    String password = readCleanLine(scanner);

                    boolean maxUsersReached = (currentUsers[currentUsers.length - 1] != null);
                    int index = currentUsers.length;
                    if(!maxUsersReached){
                        for(int i = 0; i < currentUsers.length; i++){
                            if(currentUsers[i] == null){
                                currentUsers[i] = new User(name, age, password);
                                break;
                            } 
    
                        }
                    } else {
                        System.out.println("Max number of users reached.");
                    }

                    break;

                case 2: 
                    //run code for sign into account

                    System.out.println("Enter your name: ");
                    String userName = readCleanLine(scanner);
                    System.out.println("Enter your age");
                    int userAge = Menu.getIntegerInput(scanner);

                    
                    boolean userFound = false; 
                    for(int i = 0; i < currentUsers.length; i++){
                        if(currentUsers[i] != null){//CWE-476: NULL Pointer Dereference: achieved by checking if null before trying to access it
                            if(currentUsers[i].getName().equals(userName) && currentUsers[i].getAge() == userAge){
                                index = i; 
                                //get the user's password
                                userFound = true; 
                                System.out.println("Enter password");
                                String userPassword = scanner.nextLine();

                                if(userPassword.equals(currentUsers[i].getPassword())){
                                    //run code for what the user wants to do in their account
                                    handleUserSelection(flights, scanner, index);
                                    break;
                                } else {
                                    System.out.println("Invalid Password");
                                    break;
                                }

                            }
                        }
                    }
                    if(!userFound){
                        System.out.println("We could not find a user with the name: " + userName + " and age " + userAge);
                    }

                    break;
                case 3: 
                    //run code for quitting
                    outerLoopRunning = false;
                    break;
            }
        }   

        scanner.close(); //close scanner. CWE-382: J2EE Bad Practices: Use of System.exit(). Don't use System.exit()
     } catch (Exception e) {  // CWE-537: Generic error handling
        System.out.println("An error occurred. Please try again.");
    }
}
