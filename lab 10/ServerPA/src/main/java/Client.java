import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    public List<Client> friends = new ArrayList<>();
    public List<String> mail = new ArrayList<>();
    Client(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
