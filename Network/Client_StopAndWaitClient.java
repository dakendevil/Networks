import java.io.*;
 import java.net.*;
 public class StopAndWaitClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6000);
        BufferedReader in = new BufferedReader(new
 InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        for (int i = 0; i < 5; i++) {
            System.out.println("Sending frame: " + i % 2);
            out.println(i % 2);
            String ack = in.readLine();
            System.out.println("Received: " + ack);
        }
        socket.close();
}
}