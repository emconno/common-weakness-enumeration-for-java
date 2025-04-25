public class Flight {

    //instantiate basic members; 
    private String flightNumber; 
    private String aircraftModel; 
    private int maxNumSeats; 
    private int currentNumSeats = 0; 

    
    public Flight(String flightNumber, String aircraftModel, int maxNumSeats, int currentNumSeats){
        this.flightNumber = flightNumber; 
        this.aircraftModel = aircraftModel; 
        this.maxNumSeats = maxNumSeats; 
        this.currentNumSeats = currentNumSeats;
    }

    public String getFlighNumber(){
        return this.flightNumber;
    }

    public String getAircraftModel(){
        return this.aircraftModel;
    }

    public int getMaxNumSeats(){
        return this.maxNumSeats;
    }

    public int getCurrentNumSeats(){
        return this.currentNumSeats;
    }

}
