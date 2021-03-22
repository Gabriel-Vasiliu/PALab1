package media.comenzi.processing;

import citeste.ReadArgument;
import media.Catalog;
import media.comenzi.*;

public class CommandProcessing extends Catalog {
    private String command;

    public void setCommand(String c) {
        this.command = c;
    }

    public String getCommand() {
        return command;
    }

    public void Type() {
        AddCommand c = new AddCommand();
        if (command.equals("Lista")) {
            Lista l = new Lista();
            l.setName("Lista");
            c.addCommand(l);
        } else if (command.equals("Save")) {
            Save s = new Save();
            s.setName("Save");
            c.addCommand(s);
        } else if (command.equals("Load")) {
            Load l = new Load();
            l.setName("Load");
            c.addCommand(l);
        } else if (command.equals("Play")) {
            ReadArgument readArgument = new ReadArgument();
            String argument = readArgument.getRead();
            Play p = new Play(Integer.parseInt(argument), itemList);
            p.setName("Play");
            c.addCommand(p);
        }
    }
}
