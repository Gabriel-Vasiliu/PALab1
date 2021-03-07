package calatorie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import locatie.Church;
import locatie.Museum;
import locatie.Restaurant;

public class City {
    private final List<Location> nodes = new ArrayList<>();

    public void addLocation(Location node) {
        nodes.add(node);
    }
   /* public void showLocation(){
        int index;
        List<Location> l = new ArrayList<>();
        for(index=0; index< nodes.size(); index++) {
            if (nodes.get(index).getType().equals("Church") || nodes.get(index).getType().equals("Restaurant")){
                l.add(nodes.get(index));
            }
            else {
                if (nodes.get(index).getType().equals("Museum")){
                    Museum m = (Museum) nodes.get(index);
                    if (m.getTicketPrice()==0){
                        l.add(nodes.get(index));
                    }
                }
            }
        }
        int i, j;
        for (i=0; i<l.size()-1; i++) {
            Church c1 = (Church) l.get(i);
            for (j = i+1; j < l.size(); j++) {
                Church c2 = (Church) l.get(j);
                if (c1.getOpeningTime().isAfter(c2.getOpeningTime())){
                    l.set(i, c2);
                    l.set(j, c1);
                }
            }
        }
        for (i=0; i<l.size(); i++){
            System.out.println(l.get(i).getName());
        }
    }*/

}
