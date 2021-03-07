package locatie;

import calatorie.Location;
import locatie.tip.Payable;
import locatie.tip.Visitable;

import java.time.Duration;
import java.time.LocalTime;

public class Museum extends Location implements Visitable, Payable {
    private LocalTime openingTime, closingTime;
    private double ticketPrice;

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double price) {
        this.ticketPrice = price;
    }

    public String toString() {
        return getName() + ", " + getOpeningTime() + " - " + getClosingTime() + ", price: " + getTicketPrice();
    }
    // public long showDuration(LocalTime t1, LocalTime t2){
    //   Duration d = getVisitingDuration(t1, t2);
    //}

}
