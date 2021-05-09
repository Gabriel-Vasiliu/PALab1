import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

class ClientThread implements Runnable {
    private final Socket socket;
    public List<Client> clients;
    public ClientThread (Socket socket, List<Client> clients)
    {
        this.socket = socket;
        this.clients = clients;
    }
    public void run () {
        String request;
        String response;
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                boolean login = false;
                request = in.readLine();
                Client client = null;
                while (!request.equals("exit") && !login ) {
                    if(request.equals("register")){
                        response = "name: ";
                        out.println(response);
                        out.flush();
                        String registerName = in.readLine();
                        Register(registerName);
                        response = "the name has been registered";
                    }
                    else{
                        if (request.equals("login")){
                            response = "name: ";
                            out.println(response);
                            out.flush();
                            String loginName = in.readLine();
                            login = Login(loginName);
                            if (login){
                                response = "you are logged; friend/send/read";
                                client = getClient(loginName);
                            }
                            else {
                                response = "incorrect name";
                            }
                        }
                        else{
                            response = "Incorrect command";
                        }
                    }
                    out.println(response);
                    out.flush();
                    request = in.readLine();
                }
                while(!request.equals("exit")){
                    if(request.equals("friend")){
                        response = "name: ";
                        out.println(response);
                        out.flush();
                        String friendName = in.readLine();
                        boolean friend = Friend(friendName, client);
                        if (friend){
                            response = "you are a new friend";

                        }
                        else {
                            response = "incorrect name";
                        }
                    }
                    else{
                        if (request.equals("send")){
                            response = "message for your friends: ";
                            out.println(response);
                            out.flush();
                            String message = in.readLine();
                            for (Client friend: client.friends){
                                friend.mail.add(message);
                            }
                            response = "the message was sent";
                        }
                        else {
                            if (request.equals("read")){
                                String message = "";
                                for (String msg: client.mail) {
                                    message = msg + "; " + message;
                                }
                                response = message;
                            }
                            else{
                                response = "Incorrect command";
                            }
                        }
                    }
                    out.println(response);
                    out.flush();
                    request = in.readLine();
                }
                response = "Server stopped";
                out.println(response);
                out.flush();
            }
            catch(IOException e){
                System.err.println("Communication error... " + e);
            }
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("error: " + e);
        }

    }
    public void Register(String name){
        Client client = new Client(name);
        clients.add(client);
    }
    public boolean Login(String name){
        for (Client client: clients) {
            if(client.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    public Client getClient(String name){
        for (Client client: clients) {
            if(client.getName().equals(name)){
                return client;
            }
        }
        return null;
    }
    public boolean Friend(String name, Client friend){
        for (Client client: clients) {
            if(client.getName().equals(name)){
                client.friends.add(friend);
                friend.friends.add(client);
                return true;
            }
        }
        return false;
    }
}