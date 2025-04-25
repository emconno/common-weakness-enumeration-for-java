import java.util.Scanner; 

public class Menu {

    //CWE-582: Array Declared Public, Final, and Static
    private static String[] menuItems = {"Book a Flight", "Unbook a Flight", "View Available Flights", "Quit"};

    public static int getMenuChoice(){

        //print menu
        for(int i = 0; i < menuItems.length; i++){
            System.out.println((i + 1) + " - " + menuItems[i]);
        }

        //instantiate a Scanner
        Scanner keyboard = new Scanner(System.in);

        //store user choice depending on value in Scanner
        int choice; 

        //if we have an integer in the Scanner, 
        if(keyboard.hasNextInt()){
            choice = keyboard.nextInt();

            if(choice < 0 || choice >= menuItems.length){
                choice = 1; //automatically quit
            }


        } else {
            choice = 1; //automatically quit 
        } 

        //close keyboard for security reasons
        keyboard.close(); 

        return choice; 

    }

}
