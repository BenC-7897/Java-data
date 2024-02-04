// Importing necessary classes for input/output operations and networking
import java.net.SocketException; 
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException; 
public class datagram_socket_1 {
    public static void main(String[] args) {
    	DatagramSocket s; 
    	System.out.println("Opening client: "); // Print a message indicating that the UDP client is being opened
        try { // Try block: Attempt to execute the following code
            s = new DatagramSocket(); // Create a DatagramSocket (client socket)
            System.out.println("Client socket opened: "); // Print a message indicating that the client socket is opened
        } catch (IOException e) { // Catch block: If an IOException occurs during the execution of the try block
        System.out.println("Error:\nServer socket failed to intialise"); // catch the exception, print an error message, print the stack trace and return from the method
        e.printStackTrace(); 
        return; 
        }
        // Create byte arrays to store received and to-be-sent data
        byte[] receivedata = new byte[1024]; 
        byte[] senddata = new byte[1024]; 
        InetAddress serverAddress; 
        try { // Try block: Attempt to get the InetAddress of the server (localhost in this case)
        serverAddress = InetAddress.getLocalHost(); 
        } catch (UnknownHostException e)  { // Catch block: If an UnknownHostException occurs during the execution of the try block
        System.out.println("Server address not found"); // catch the exception, print an error message, print the stack trace and return from the method
        e.printStackTrace();
        return; 
        } 
        DatagramPacket sendPacket = new DatagramPacket(senddata, senddata.length,serverAddress, 9776); // Create a DatagramPacket to send data to the server
        try {
        s.send(sendPacket); // Try block: Attempt to send data to the server using the client socket
        System.out.println("Packet sent:"); // Print a message indicating that the packet is sent
        } catch (IOException e) { // Catch block: If an IOException occurs during the execution of the try block
        System.out.println("Packet failed to send:"); // catch the exception, print an error message, print the stack trace and return from the method
        e.printStackTrace(); 
        }
        DatagramPacket receivePacket = new DatagramPacket(receivedata, receivedata.length); // Create a DatagramPacket to receive data from the server
        try { 
        s.receive(receivePacket); // Try block: Attempt to receive data from the server using the client socket
        System.out.println("Packet received:"); // Print a message indicating that the packet is received
        } catch (IOException e) { // Catch block: If an IOException occurs during the execution of the try block
        System.out.println("Failed to get response:"); // catch the exception, print an error message, print the stack trace and return from the method
        e.printStackTrace(); 
        }
        System.out.println("Client response: "); // Print a message indicating the client's response
        System.out.println("Packet received:\nIP: " + receivePacket.getAddress() + receivePacket.getPort()); // Print information about the received packet (server's IP address and port)
        s.close(); // Close the client socket
    }
}
