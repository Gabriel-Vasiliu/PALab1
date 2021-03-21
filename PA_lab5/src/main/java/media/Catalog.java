package media;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Catalog extends Component {
    private final List<Item> itemList = new LinkedList<>();

    public void add(Item i) {
        itemList.add((i));
    }

    public void list() {
        for (Item i : itemList) {
            System.out.println(i.toString());
        }
    }

    public void play(int index) {
        try {
            File u = new File(itemList.get(index).getPath());
            Desktop d = Desktop.getDesktop();
            d.open(u);
        } catch (Exception evt) {
            JOptionPane.showMessageDialog(this, evt.getMessage());
        }
    }

    public void save() {
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

    //cititm linie cu linie fisierul read.txt si convertim fiecare linie cu metoda ConvertLine
    public void load() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("C:\\Users\\Gabi\\Desktop\\item\\read.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
            String line = bufferedReader.readLine();
            while (line != null) {
                ConvertLine(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("The file read.txt is missing!");
        } catch (IOException e) {
            System.out.println("Unexpected error reading the file!");
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    System.err.println("Error closing the file!");
                }
            }
        }
    }

    //convertim linia intr-un obiect de tip book sau movie
    public void ConvertLine(String line) {
        if (line.charAt(0) == 'B') {
            Book b = new Book();
            b.setName(line.substring(6, line.indexOf(", author")));
            b.setAuthor(line.substring(line.indexOf("author: ") + 8, line.indexOf("path") - 8));
            try {
                b.setYear(Integer.parseInt(line.substring(line.indexOf(b.getAuthor()) + b.getAuthor().length() + 2, line.indexOf("path") - 2)));
            } catch (Exception e1) {
                System.out.println("Exception occurred:" + e1);
            }
            b.setPath(line.substring(line.indexOf("path") + 6));
            add(b);
        } else {
            Movie m = new Movie();
            m.setName(line.substring(7, line.indexOf(", rating") - 6));
            try {
                m.setYear(Integer.parseInt(line.substring(line.indexOf(m.getName()) + m.getName().length() + 2, line.indexOf(", rating"))));
            } catch (Exception e1) {
                System.out.println("Exception occurred:" + e1);
            }
            try {
                m.setRating(Double.parseDouble(line.substring(line.indexOf("rating: ") + 7, line.indexOf(", path"))));
            } catch (Exception e2) {
                System.out.println("Exception occurred:" + e2);
            }
            m.setPath(line.substring(line.indexOf("path") + 6));
            add(m);
        }
    }

}