package locatie.tip;

import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {
    LocalTime getOpeningTime();

    LocalTime getClosingTime();
   /* static Duration getVisitingDuration(LocalTime t1, LocalTime t2){
        //long dif = java.time.Duration.between(t1, t2).toHours();
        return Duration.between(t1, t2);
    }
    long showDuration(LocalTime t1, LocalTime t2);*/
}
