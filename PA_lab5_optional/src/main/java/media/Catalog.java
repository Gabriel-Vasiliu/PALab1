package media;

import media.comenzi.AddCommand;
import media.comenzi.Play;

import java.util.LinkedList;
import java.util.List;

public class Catalog {
    public static List<Item> itemList = new LinkedList<>();

    public void play(int index, AddCommand c) {
        Play p = new Play(index, itemList);
        p.setName("Play");
        c.addCommand(p);
    }
}