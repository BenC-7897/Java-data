// Importing necessary classes for input/output operations and networking
import java.net.SocketException; 
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class datagram_socket {
    public static void main(String args[]) {
    	DatagramSocket server_socket; 
    	System.out.println("Opening UDP Server"); // Print a message indicating that the UDP server is being opened
        try { // Try block: Attempt to execute the following code
        server_socket = new DatagramSocket(9776); // Create a DatagramSocket on port 9776 
        System.out.println("Server socket opened"); // Print a message indicating that the server socket is opened
        } catch (SocketException e) { // Catch block: If a SocketException occurs during the execution of the try block
        System.out.println("Error"); 
        e.printStackTrace(); // catch the exception, print an error message, print the stack trace and return from the method
        return; 
        }
        byte[] receiveData = new byte[1024]; // Create a byte array to store received data
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); // Create a DatagramPacket to receive data
        try { // Try block: Attempt to receive data using the server socket
        server_socket.receive(receivePacket);
        System.out.println("Received"); // Print a message indicating that data is received
        } catch (IOException e) { // Catch block: If an IOException occurs during the execution of the try block
        System.out.println("Failed to get response"); 
        e.printStackTrace(); // catch the exception, print an error message, print the stack trace and return from the method
        }
        InetAddress clientAddress = receivePacket.getAddress(); // Get client address and port from the received packet
        int clientPort = receivePacket.getPort();
        byte[] sendData = new byte[1024]; // Create a byte array to store data to be sent
        System.out.println("Server Response:"); // Print a message indicating the server response
        System.out.println("Packet received: " + clientPort + " "); // Print the information about the received packet (client's address and port)
        DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, clientAddress, clientPort); // Create a DatagramPacket to send data to the client
        try { // Try block: Attempt to send data to the client using the server socket
        server_socket.send(sendPacket);	
        System.out.println("Packet sent"); // Print a message indicating that the packet is sent
        }
        catch (IOException e) { // Catch block: If an IOException occurs during the execution of the try block
        System.out.println("Packet failed to send"); 
        e.printStackTrace(); // catch the exception, print an error message, print the stack trace and return from the method
        return; 
        } finally { 
        server_socket.close(); // Close the server socket in a finally block to ensure it is closed regardless of exceptions
        }
    }
}
