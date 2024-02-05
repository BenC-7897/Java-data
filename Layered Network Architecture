public class LNA {
    public static void main(String[] args) {
        // Example sizes (in bytes)
        int iph = 20; // IPv4 header size
        int tcph = 20; // TCP header size
        int ehs = 14; // Ethernet header size
        int osm = 1000; // Size of the original message
        int ths = iph + tcph + ehs; // Calculate total header size
        double overheadPercentage = calculateOverheadPercentage(ths, osm); // Calculate overhead percentage
        System.out.println("Overhead Percentage: " + overheadPercentage + "%"); // Print the result
    }
    private static double calculateOverheadPercentage(int totalHeaderSize, int originalMessageSize) {
        return ((double) totalHeaderSize/originalMessageSize) * 100;
    }
} 
