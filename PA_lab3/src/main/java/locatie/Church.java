package locatie;

import calatorie.Location;
import locatie.tip.Visitable;

import java.time.LocalTime;

public class Church extends Location implements Visitable {
    private LocalTime openingTime, closingTime;

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

    public String toString() {
        return getName() + ", " + getOpeningTime() + " - " + getClosingTime();
    }
}
