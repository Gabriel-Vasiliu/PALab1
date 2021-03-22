package media.comenzi;

import media.Catalog;
import media.Item;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Save extends Catalog implements Command{
    private String name;
    public Save(){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("C:\\Users\\Gabi\\Desktop\\item\\write.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter, 1024);
            for (Item i : itemList) {
                bufferedWriter.write(i.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            System.err.println("The file write.txt is missing!");
        } catch (IOException e) {
            System.out.println("Unexpected error writing the file!");
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.err.println("Error closing the file!");
                }
            }
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
