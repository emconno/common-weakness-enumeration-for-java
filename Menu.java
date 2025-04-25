import java.util.Scanner; 

public class Menu {

    //CWE-582: Array Declared Public, Final, and Static
    //CWE-766: Critical Data Element Declared Public
    private static String[] menuItems = {"Book a Flight", "Unbook a Flight", "View Available Flights", "Book By Destination", "Quit"};

    public static int getMenuChoice(Scanner keyboard) {
        // Print menu
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i + 1) + " - " + menuItems[i]);
        }

        // Store user choice depending on value in Scanner
        int choice;

        // If we have an integer in the Scanner,
        if (keyboard.hasNextInt()) {
            choice = keyboard.nextInt();

            if (choice < 1 || choice > menuItems.length) {
                /* CWE-481: Assigning instead of comparing */
                choice = menuItems.length; // Automatically quit
            }
        } else {
            choice = menuItems.length; // Automatically quit
            keyboard.next(); // Clear invalid input
        }

        return choice;
    }

}
