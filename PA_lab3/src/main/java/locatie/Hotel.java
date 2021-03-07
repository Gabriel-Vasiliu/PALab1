package locatie;

import locatie.tip.Classifiable;
import calatorie.Location;

public class Hotel extends Location implements Classifiable {
    private int rank;

    public int getRank() {
        return rank;
    }

    public void setRank(int n) {
        this.rank = n;
    }

    public String toString() {
        return getName() + ", rank: " + getRank();
    }
}
