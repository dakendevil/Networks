import java.net.*;
 public class IPClassIdentifier {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String ipAddress = localHost.getHostAddress();
            System.out.println("Local IP Address: " + ipAddress);
            String[] parts = ipAddress.split("\.");
            int firstOctet = Integer.parseInt(parts[0]);
            String ipClass = "";
            if (firstOctet >= 0 && firstOctet <= 127)
                ipClass = "Class A";
            else if (firstOctet <= 191)
                ipClass = "Class B";
            else if (firstOctet <= 223)
                ipClass = "Class C";
            else if (firstOctet <= 239)
                ipClass = "Class D (Multicast)";
            else
                ipClass = "Class E (Experimental)";
            System.out.println("IP Address Class: " + ipClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 }