import java.util.Scanner;
 public class SubnettingCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter IP address (e.g. 192.168.1.0): ");
        String ip = scanner.nextLine();
        System.out.print("Enter number of subnets: ");
        int numSubnets = scanner.nextInt();
        String[] parts = ip.split("\.");
        int[] ipParts = new int[4];
        for (int i = 0; i < 4; i++) ipParts[i] = Integer.parseInt(parts[i]);
        int bits = (int) Math.ceil(Math.log(numSubnets) / Math.log(2));
        int newPrefix = 24 + bits;
        int numHosts = (int) Math.pow(2, 32 - newPrefix);
        int subnetInc = numHosts;
        System.out.println("Subnet mask: /" + newPrefix);
        System.out.println("Subnet addresses:");
        for (int i = 0; i < numSubnets; i++) {
            int subnet = i * subnetInc;
            int fourthOctet = subnet % 256;
            int thirdOctet = (subnet / 256) % 256;
            System.out.println(ipParts[0] + "." + ipParts[1] + "." + (ipParts[2] +
 thirdOctet) + "." + fourthOctet);
        }
    }
 }