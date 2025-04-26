import java.time.LocalTime;
import java.util.Date;

public class Listing {
    
    private Flight flight; 
    private Date date; 
    private LocalTime departure; 
    private LocalTime arrival; 

    Listing(Flight flight, Date date, LocalTime departure, LocalTime arrival){
        this.flight = flight; 
        this.date = date; 
        this.departure = departure; 
        this.arrival = arrival;
    }

    @Override
    // CWE-397: Specific CloneNotSupportedException
    protected Object clone() throws CloneNotSupportedException {
        /* CWE-580: clone() Method Without super.clone() */
        Listing cloned = (Listing) super.clone();
        cloned.date = new Date(this.date.getTime()); // Defensive copy
        return cloned;
    }

    public Flight getFlight(){
        return this.flight; 
    }

    public Date getDate(){
        return new Date(this.date.getTime());
    }

    public LocalTime getDeparture(){
        return this.departure; 
    }
    
    public LocalTime getArrival(){
        return this.arrival;
    }

}
