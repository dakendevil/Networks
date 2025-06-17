import java.io.*;
 import java.net.*;
 public class StopAndWaitServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        Socket client = server.accept();
        BufferedReader in = new BufferedReader(new
 InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        String data;
        int expected = 0;
        while ((data = in.readLine()) != null) {
            int frame = Integer.parseInt(data);
            if (frame == expected) {
                System.out.println("Received frame: " + frame);
                out.println("ACK " + expected);
                expected = (expected + 1) % 2;
            } else {
                System.out.println("Duplicate frame: " + frame);
                out.println("ACK " + ((expected + 1) % 2));
            }
        }
        client.close();
        server.close();
    }
 }