package citeste;

import java.util.Scanner;

public class ReadArgument {
    private String read = " ";

    public ReadArgument() {
        Scanner console = new Scanner(System.in);
        System.out.println("Argument: ");
        read = console.next();
    }

    public String getRead() {
        return read;
    }
}
