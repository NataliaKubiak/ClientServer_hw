import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8040;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("[INFO] Сервер стартовал");
            while (true) {
                try (Socket clientSocket = serverSocket.accept(); //waiting client to connect
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    System.out.println("[INFO] New connection accepted");
                    out.println("Write your name");
                    final String name = in.readLine();

                    out.println("Are you a child?");
                    final String isChild = in.readLine();

                    if ("no".equals(isChild)) {
                        out.printf("Welcome to the adult zone, %s! Have a good rest, or a good work day!", name);
                    } else if ("yes".equals(isChild)) {
                        out.printf("Welcome to the kids area, %s! Let's play!", name);
                    } else {
                        out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
