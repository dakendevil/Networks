import java.io.*;
 import java.net.*;
 public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7000);
        Socket socket = serverSocket.accept();
        BufferedReader in = new BufferedReader(new
 InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        String input;
        while ((input = in.readLine()) != null) {
            System.out.println("Client: " + input);
            out.println("Echo: " + input);
    }
        }
        socket.close();
        serverSocket.close();
 }