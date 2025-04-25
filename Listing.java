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

    public Flight getFlight(){
        return this.flight; 
    }

    public Date getDate(){
        return new Date(this.date.getDate());
    }

    public LocalTime getDeparture(){
        return this.departure; 
    }
    
    public LocalTime getArrival(){
        return this.arrival;
    }

}
