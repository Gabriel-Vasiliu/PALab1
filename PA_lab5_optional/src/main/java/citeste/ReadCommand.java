package citeste;

import exception.InvalidCommand;
import media.comenzi.processing.CommandProcessing;

import java.util.Scanner;
//citim comenzi si le validam pana cand dam "exit"
public class ReadCommand {
    public void readUntilExit() {
        Scanner console = new Scanner(System.in);
        String read = " ";
        while (!read.equals("exit")) {
            try {
                System.out.println("Command: ");
                read = console.next();
                validateCommand(read);
                CommandProcessing commandProcessing = new CommandProcessing();
                commandProcessing.setCommand(read);
                commandProcessing.Type();
            } catch (Exception e3) {
                System.out.println("Exception occurred:" + e3);
            }
        }

    }

    public void validateCommand(String read) throws InvalidCommand {
        if (!read.equals("Load") && !read.equals("Save") && !read.equals("Add") &&
                !read.equals("Play") && !read.equals("Lista") && !read.equals("exit")) {
            throw new InvalidCommand("Invalid command");
        }
    }
}
