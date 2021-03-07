package locatie;

import locatie.tip.Classifiable;
import calatorie.Location;
import locatie.tip.Visitable;

import java.time.LocalTime;

public class Restaurant extends Location implements Classifiable, Visitable {
    private LocalTime openingTime, closingTime;
    private int rank;

    public int getRank() {
        return rank;
    }

    public void setRank(int n) {
        this.rank = n;
    }

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
        return getName() + ", rank: " + getRank() + ", " + getOpeningTime() + " - " + getClosingTime();
    }

}
