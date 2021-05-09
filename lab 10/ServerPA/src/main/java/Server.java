import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server {
    public static int PORT=8100;
    public List<Client> clients = new LinkedList<>();
    public Server() throws IOException{
        Client client1 = new Client("gabi");
        clients.add(client1);
        Client client2 = new Client("daniel");
        clients.add(client2);
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(PORT);
            serverSocket.setReuseAddress(true);
            while(true){
                System.out.println("waiting..");
                Socket socket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(socket, clients);
                new Thread(clientThread).start();
            }
        } catch (IOException e){
            System.err.println("error..." + e);
        }finally {
            if(serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}