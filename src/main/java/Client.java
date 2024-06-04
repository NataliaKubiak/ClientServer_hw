import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        try (Socket clientSocket = new Socket("netology.homework", Server.PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println(in.readLine());
            out.println("Natalie");
            System.out.println(in.readLine());
            out.println("no");
            System.out.println(in.readLine());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
