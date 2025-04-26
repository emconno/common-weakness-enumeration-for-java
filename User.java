public class User {
    private String name;
    private int age;
    private String password; 
    private Listing[] listings;

    public User(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password; 
        this.listings = new Listing[10];
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return this.age;
    }

    public String getPassword() {
        return new String(this.password);
    }

    public Listing[] getListings() {
        // CWE-375: Returning a Mutable Object to an Untrusted Caller
        // CWE-767: Access to Critical Private Variable via Public Method
        // Using .clone() to avoid the above CWEs
        return listings.clone(); 
    }

    public void addListing(Listing listing){

        try{
            System.out.println("Listing added: " + listing.getFlight().getAircraftModel() + ", " + listing.getFlight().getMaxNumSeats() + ", " + listing.getFlight().getFlightNumber());
        }catch(NullPointerException e){ //CWE-396: Declaration of Catch for Generic Exception: achieved by catching specific exception instead of generic exception.
            System.out.println("Error in loading flight information.");
        }

        for(int i = 0; i < 10; i++){
            if(listings[i] == null){
                listings[i] = listing;
                break;
            }
        }
    }

    public void removeListing(Listing listing){
        for(int i = 0; i < 10; i++){
            if(listings[i].getFlight().getFlightNumber().equals(listing.getFlight().getFlightNumber())){
                listings[i] = null;
            }
        }
    }

}
