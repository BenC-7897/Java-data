import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
public class MACA {
    public static void main(String[] args) {
        try {
            InetAddress host = InetAddress.getLocalHost(); // Get the local host
            NetworkInterface ni = NetworkInterface.getByInetAddress(host); // Get the network interface of the local host
            byte[] mabytes = ni.getHardwareAddress(); // Get the MAC address
            if (mabytes != null) { // Display the MAC address
                StringBuilder macAddress = new StringBuilder();
                for (byte b : mabytes) { // Iterate through each byte in the MAC address
                    macAddress.append(String.format("%02X:", b)); // Convert the byte to a hexadecimal string and append it to the address
                }
                System.out.println("MAC Address: " + macAddress.substring(0, macAddress.length() - 1)); // Print the formatted MAC address (remove the trailing colon)
            } else {
                System.out.println("MAC Address not found."); // If the MAC address is not found, print a message
            }
        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace(); // Handle exceptions, such as unknown host or socket issues
        }
    }
} 
