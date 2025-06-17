 
import java.io.*;
 import java.net.*;
 public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 7000);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new
 InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        String line;
        while (!(line = userInput.readLine()).equalsIgnoreCase("exit")) {
            out.println(line);
            System.out.println(in.readLine());
        }
        socket.close();
    }
 }