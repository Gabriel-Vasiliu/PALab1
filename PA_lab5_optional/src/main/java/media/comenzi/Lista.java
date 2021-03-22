package media.comenzi;

import media.Catalog;
import media.Item;

public class Lista extends Catalog implements Command{
    private String name;
    public Lista(){
        for (Item i : itemList) {
            System.out.println(i.toString());
        }
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
