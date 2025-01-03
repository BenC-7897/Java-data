import java.io.*;
import java.net.*; 
import java.util.*; 
public class MediaClient {
// Declare private static variables to store various network metrics
private static long stime; // Start time
private static long tbr; // Total bytes received
private static int tpr; // Total packets received
private static long lptime; // Last packet time
private static long delay; // Total delay
private static long jitter; // Jitter
public static DataPacket convert(byte[] buffer) throws Exception { // Define a method named convert that takes a byte array and returns a DataPacket object
    ByteArrayInputStream bs = new ByteArrayInputStream(buffer); // Create a ByteArrayInputStream object named bs with the byte array
    ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(bs)); // Create an ObjectInputStream object named is with a BufferedInputStream object that reads from bs
    DataPacket packet = (DataPacket)is.readObject(); // Read a DataPacket object from the input stream
    is.close(); // Close the input stream
    return packet; // Return the DataPacket object
  } 
  public static void main (String args[]) throws Exception { // Define the main method
    DatagramSocket s = new DatagramSocket(); // Create a DatagramSocket object named s
    int current_sequence_number = 0; // Initialize the current_sequence_number variable to 0
    byte[] buffer = new byte[1000]; // Create a byte array named buffer with a size of 1000 bytes
    InetAddress a = InetAddress.getByName("localhost"); // Get the IP address of the server
    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, a, 6600); // Create a DatagramPacket object named packet to send data to the server
    s.send(packet); // Send the packet
    long interval = 1000; // Set the interval variable to 1000 milliseconds
    long ltime = System.currentTimeMillis(); // Get the current time
    stime = System.currentTimeMillis(); // Set the start time variable to the current time
    lptime = stime; // Set the last packet time variable to the start time
    // Initialize the total bytes received, total packets received, total delay, and jitter variables to 0
    tbr = 0; 
    tpr = 0; 
    delay = 0; 
    jitter = 0; 
    while (current_sequence_number < 100000) { // Loop until the current sequence number reaches 100000
      packet = new DatagramPacket(buffer, buffer.length); // Create a new DatagramPacket object named packet to receive data from the server
      s.receive(packet); // Receive a packet
      DataPacket Pac = convert(packet.getData()); // Convert the received data to a DataPacket object
      current_sequence_number = Pac.sequence; // Update the current sequence number
      long ctime = System.currentTimeMillis(); // Get the current time
      compute_network(ctime, Pac); // Compute the network metrics
      if (ctime >= ltime + interval) { // If the current time is greater than or equal to the last time plus the interval
      calculate_network(); // Calculate the network metrics
      reset(ctime); // Reset the network metrics
      ltime = ctime; // Update the last time
      }
    }
  s.close(); // Close the socket
}
private static void compute_network(long current_time, DataPacket Pac) { // Define a method named compute_network that takes the current time and a DataPacket object
    long pdelay = current_time-Pac.time; // Calculate the packet delay
      tbr += Pac.data.length; // Update the total bytes received and total packets received
      tpr++; 
      delay += pdelay; // Update the total delay
      if (tpr>1) { // If there is more than one packet received
      long pjitter = Math.abs(current_time-lptime-pdelay); // Calculate the jitter
      jitter = Math.max(jitter, pjitter); 
    }
  lptime = current_time; // Update the last packet time
} 
private static void calculate_network() { // Define a method named calculate_network
    long elapse = System.currentTimeMillis(); // Get the current time
    // Calculate the throughput, loss rate, average delay, and jitter
    double throughput = (double) tbr*8/elapse; 
    double lossr = (double) tpr/(elapse/1000); 
    double adelay = (double) delay/tpr; 
    // Print the network metrics
    System.out.println("Throughput: " + throughput + " bps"); 
    System.out.println("Loss Rate: " + lossr + " bps"); 
    System.out.println("Average Delay: " + adelay + " ms"); 
    System.out.println("Jitter: " + jitter + " ms"); 
}
private static void reset(long currentt) { // Define a method named reset that takes the current time
    // Reset the start time, last packet time, total bytes received, total packets received, total delay, and jitter
    stime = currentt; 
    lptime = currentt; 
    tbr = 0; 
    tpr = 0; 
    delay = 0; 
    jitter = 0; 
  }
}
