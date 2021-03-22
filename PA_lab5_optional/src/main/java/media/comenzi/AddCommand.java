package media.comenzi;

public class AddCommand implements Command{
    public void addCommand(Command c){
        commandList.add(c);
    }
    @Override
    public void setName(String n) { }

    @Override
    public String getName() {
        return null;
    }
}
