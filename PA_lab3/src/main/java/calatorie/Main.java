package calatorie;

import locatie.Church;
import locatie.Hotel;
import locatie.Museum;
import locatie.Restaurant;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Hotel v1 = new Hotel();
        v1.setName("Hotel");
        v1.setRank(4);
        v1.setType("Hotel");
        Museum v2 = new Museum();
        v2.setName("Museum A");
        v2.setOpeningTime(LocalTime.of(9, 30));
        v2.setClosingTime(LocalTime.of(17, 10));
        v2.setTicketPrice(20);
        v2.setType("Museum");
        Museum v3 = new Museum();
        v3.setName("Museum B");
        v3.setOpeningTime(LocalTime.of(9, 10));
        v3.setClosingTime(LocalTime.of(18, 30));
        v3.setTicketPrice(18);
        v3.setType("Museum");
        Church v4 = new Church();
        v4.setName("Church A");
        v4.setOpeningTime(LocalTime.of(7, 10));
        v4.setClosingTime(LocalTime.of(19, 30));
        v4.setType("Church");
        Church v5 = new Church();
        v5.setName("Church B");
        v5.setOpeningTime(LocalTime.of(6, 30));
        v5.setClosingTime(LocalTime.of(18, 40));
        v5.setType("Church");
        Restaurant v6 = new Restaurant();
        v6.setName("Restaurant");
        v6.setOpeningTime(LocalTime.of(9, 15));
        v6.setClosingTime(LocalTime.of(20, 30));
        v6.setRank(3);
        v6.setType("Restaurant");

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v4);
        System.out.println(v6);

        City oras = new City();
        oras.addLocation(v1);
        oras.addLocation(v2);
        oras.addLocation(v3);
        oras.addLocation(v4);
        oras.addLocation(v5);
        oras.addLocation(v6);
        v1.setCost(v2, 10);
        v1.setCost(v3, 50);
        v2.setCost(v3, 20);
        v2.setCost(v4, 20);
        v2.setCost(v5, 10);
        v3.setCost(v2, 20);
        v3.setCost(v4, 20);
        v4.setCost(v5, 30);
        v4.setCost(v6, 10);
        v5.setCost(v4, 30);
        v5.setCost(v6, 20);
        //oras.showLocation();

    }
}
