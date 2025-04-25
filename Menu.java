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

        int choice; //this will capture the userinput (so long it's a valid integer)

        //loop until we get a valid integer (one that is between 1 and menuItems.length (inclusive))
        while(true){

            String input = keyboard.nextLine();



            try{
                choice = Integer.parseInt(input);

                if(choice > 0 && choice <= menuItems.length){
                    break;
                } else {
                    System.out.println("Your input was a valid integer, however it is not a valid choice given the range 1 - " + menuItems.length);
                }
            }catch(NumberFormatException e){
                System.out.println("Your input was not a valid integer. Please enter an integer between 1 and " + menuItems.length);
            }

        }

        //close keyboard for security reasons
        keyboard.close(); 

        return choice; 

    }

}
