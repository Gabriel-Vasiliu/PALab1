import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main (String[] args) {
        String serverAddress = "127.0.0.1";
        int PORT = 8100;
        String request = " ";
        Scanner scanner = new Scanner(System.in);
        try(Socket socket = new Socket(serverAddress, PORT)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Hello, register/login");
            while (!request.equals("exit")) {
                request = scanner.next();
                out.println(request);
                String response = in.readLine();
                System.out.println(response);
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println("No server listening... " + e);
        }
    }
}