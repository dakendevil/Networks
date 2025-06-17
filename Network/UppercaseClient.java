import java.io.*;
 import java.net.*;
 public class UppercaseClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5001);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new
 InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        System.out.print("Enter string: ");
        String input = userInput.readLine();
        out.println(input);
        String response = in.readLine();
        System.out.println("Server returned: " + response);
        socket.close();
    }
 }