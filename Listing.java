import java.time.LocalTime;
import java.time.LocalDate;

public class Listing {
    
    private Flight flight; 
    private LocalDate date; 
    private LocalTime departure; 
    private LocalTime arrival; 

    Listing(Flight flight, LocalDate date, LocalTime departure, LocalTime arrival){
        this.flight = flight; 
        this.date = date; 
        this.departure = departure; 
        this.arrival = arrival;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        /* CWE-580: clone() Method Without super.clone() */
        Listing cloned = (Listing) super.clone();
        cloned.date = LocalDate.of(this.date.getYear(), this.date.getMonth().getValue(), this.date.getDayOfMonth()); // Defensive copy
        return cloned;
    }

    public Flight getFlight(){
        return this.flight; 
    }

    public LocalDate getDate(){
        return LocalDate.of(this.date.getYear(), this.date.getMonth().getValue(), this.date.getDayOfMonth());
    }

    public LocalTime getDeparture(){
        return this.departure; 
    }
    
    public LocalTime getArrival(){
        return this.arrival;
    }

}
