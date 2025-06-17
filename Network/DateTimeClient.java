import java.io.*;
 import java.net.*;
 public class DateTimeClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            BufferedReader in = new BufferedReader(new
 InputStreamReader(socket.getInputStream()));
            String serverResponse = in.readLine();
            System.out.println("Server says: " + serverResponse);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 }