import java.io.*;
 import java.net.*;
 import java.util.Date;
 public class DateTimeServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is running...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                Date currentDate = new Date();
                out.println("Current Date and Time: " + currentDate.toString());
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 }