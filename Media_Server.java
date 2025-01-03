import java.io.*;
import java.net.*; 
import java.util.*; 
public class MediaServer {
public static byte[] convert(DataPacket PACKET) throws IOException {
    ByteArrayOutputStream bs = new ByteArrayOutputStream(6600); // Create a ByteArrayOutputStream object named bs with a size of 6600 bytes
        ObjectOutputStream output_stream = new ObjectOutputStream(new BufferedOutputStream(bs)); // Create an ObjectOutputStream object named output_stream with a BufferedOutputStream object that writes to bs
        output_stream.flush(); // Flush the output stream
        output_stream.writeObject(PACKET); // Write the PACKET object to the output stream
        output_stream.flush(); // Flush the output stream again
        return bs.toByteArray(); // Return the byte array representation of bs
      }
      public static void main(String args[]) throws IOException {
        DatagramSocket Socket = new DatagramSocket(6600); // Create a DatagramSocket object named Socket that listens on port 6600
        int sequence = 1; // Initialize the sequence variable to 1
        byte[] buffer = new byte[1000]; // Create a byte array named buffer with a size of 1000 bytes
        byte[] data = new byte[500]; // Create a byte array named data with a size of 500 bytes
        System.out.println("Server started!\n"); // Print a message indicating that the server has started
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length); // Create a DatagramPacket object named packet to receive data
        Socket.receive(packet); // Receive a packet
        System.out.println("Request received!\n"); // Print a message indicating that a request has been received
        InetAddress a = packet.getAddress(); // Get the IP address of the sender
        int port = packet.getPort(); // Get the port number of the sender
        int res = 0; // Initialize the res variable to 0
    while (sequence < 100000) { // Loop until the sequence reaches 100000
        DataPacket p = new DataPacket(++sequence, data, System.currentTimeMillis()); // Create a DataPacket object named p with the current sequence number, the data array, and the current time
        buffer = convert(p); // Convert the DataPacket object to a byte array
        packet = new DatagramPacket(buffer, buffer.length, a, port); // Create a new DatagramPacket object named packet with the byte array, the IP address, and the port number
        Socket.send(packet); // Send the packet
    }
  Socket.close(); // Close the socket
  }
}
