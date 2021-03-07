package calatorie;

import java.util.HashMap;
import java.util.Map;

public abstract class Location {
    private String name;
    private String type;
    String description;
    private final Map<Location, Integer> cost = new HashMap<>();

    public void setCost(Location node, int value) {
        cost.put(node, value);
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public void setType(String t) {
        this.type = t;
    }

    public String getType() {
        return type;
    }
}
