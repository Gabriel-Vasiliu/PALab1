package media.comenzi;

public class ListCommand implements Command{
    public void showCommand(){
        for(Command c : commandList){
            System.out.println(c.getName());
        }
    }
    @Override
    public void setName(String n) { }

    @Override
    public String getName() {
        return null;
    }
}
