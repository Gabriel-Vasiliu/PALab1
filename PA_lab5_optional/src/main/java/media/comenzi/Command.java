package media.comenzi;

import java.util.LinkedList;
import java.util.List;

public interface Command {
    List<Command> commandList = new LinkedList<>();

    void setName(String n);

    String getName();
}
