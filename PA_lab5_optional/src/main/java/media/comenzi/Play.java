package media.comenzi;

import media.Item;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

public class Play extends Component implements Command {
    private String name;

    public Play(int index, List<Item> itemList) {
        try {
            File u = new File(itemList.get(index).getPath());
            Desktop d = Desktop.getDesktop();
            d.open(u);
        } catch (Exception evt) {
            //JOptionPane.showMessageDialog(this, evt.getMessage());
            System.out.println(evt.getMessage());
        }
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
