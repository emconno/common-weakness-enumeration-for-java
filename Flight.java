public class Flight {

    //instantiate basic members; 
    private String flightNumber; 
    private String aircraftModel; 
    private int maxNumSeats; 
    private int currentNumSeats = 0;
    private String destination;

    
    public Flight(String flightNumber, String aircraftModel, int maxNumSeats, int currentNumSeats, String destination){
        this.flightNumber = flightNumber; 
        this.aircraftModel = aircraftModel; 
        this.maxNumSeats = maxNumSeats; 
        this.currentNumSeats = currentNumSeats;
        this.destination = destination;
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

    public String getDestination() {
        return this.destination;
    }
        // CWE-486: Proper class comparison
    public boolean isAircraftModelCompatible(Flight otherFlight) {
        if (otherFlight == null) return false;
        if (this.getClass() != otherFlight.getClass()) {
            return false;
        }
        return this.aircraftModel.equals(otherFlight.aircraftModel);
    }

    public boolean bookSeat() {
        if (currentNumSeats < maxNumSeats) {
            currentNumSeats++;
            return true;
        }
        return false;
    }
    
    public boolean unbookSeat() {
        if (currentNumSeats > 0) {
            currentNumSeats--;
            return true;
        }
        return false;
    }

}
