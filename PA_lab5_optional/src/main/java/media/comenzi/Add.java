package media.comenzi;

import media.Catalog;
import media.Item;

public class Add extends Catalog implements Command {
    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Add(Item i) {
        itemList.add((i));
    }
}
