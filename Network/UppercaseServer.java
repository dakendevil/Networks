import java.io.*;
 import java.net.*;
 public class UppercaseServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5001);
        Socket clientSocket = serverSocket.accept();
        BufferedReader in = new BufferedReader(new
 InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        String input = in.readLine();
        String output = input.toUpperCase();
        out.println(output);
        clientSocket.close();
        serverSocket.close();
    }
 }