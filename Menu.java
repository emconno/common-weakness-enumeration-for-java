import java.util.Scanner; 
import java.util.Arrays; 


public class Menu {

    //CWE-582: Array Declared Public, Final, and Static
    //CWE-766: Critical Data Element Declared Public

    // CWE-495: Private Data Structure Returned From A Public Method
    // Achieved through the absence of a getMenuItems method
    // CWE-496: Public Data Assigned to Private Array-Typed Field 
    // Acheived by hard-coding menuItem strings
    private static String[] menuItems = {"Book a Flight", "Unbook a Flight", "View Available Flights", "Book By Destination", "Sign out of Account"};
    private static String[] userMenuItems = {"Create Account", "Sign into Account", "Quit"};
    public static int getMenuChoice(Scanner keyboard, String[] menu) {
        // Print menu
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + " - " + menu[i]);
        }

        // Store user choice depending on value in Scanner
        int choice;

        // If we have an integer in the Scanner,
        if (keyboard.hasNextInt()) {
            choice = keyboard.nextInt();
            keyboard.nextLine();
            if (choice < 1 || choice > menu.length) {
                /* CWE-481: Assigning instead of comparing */
                choice = menu.length; // Automatically quit
            }
        } else {
            choice = menu.length; // Automatically quit
            keyboard.nextLine(); // Clear invalid input
        }

        return choice;
    }

    public static int getIntegerInput(Scanner scanner){
        int num; 

        if(scanner.hasNextInt()){
            num = scanner.nextInt();

            // CWE-191: Integer underflow protection
            if (num == Integer.MIN_VALUE) {
                num = Integer.MAX_VALUE;
            } else if(num < 0){
                num *= -1; 
            } else if (num == 0){
                num = 3; 
            }
            scanner.nextLine();
        } else {
            num = 3; 
            scanner.nextLine();
        }

        return num;
    }

    public static String[] getFlightMenu(){
        String[] menuItemsCopy = Arrays.copyOf(menuItems, menuItems.length);
        return menuItemsCopy;
    }

    public static String[] getUserMenuItems(){
        String[] userMenuItemsCopy = Arrays.copyOf(userMenuItems, userMenuItems.length);
        return userMenuItemsCopy;
    }

}
