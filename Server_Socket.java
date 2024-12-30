import java.io.IOException; // Importing IOException from the java.io package  
import java.net.*; // Importing all classes from the java.net package 
public class basic_socket_programming {
 public static void main (String args[]) { 
  try {
    ServerSocket newSocket = new ServerSocket(9004); // Create a ServerSocket on port 9004
    System.out.println("Server socket open. Waiting for client to connect"); // Print a message indicating that the server socket is open and waiting for a client to connect 
    Socket newClient = newSocket.accept(); // Accept a connection from a client, blocking until a connection is made
    System.out.println("Client accepted through the port number: " + newSocket.getInetAddress()); // Print the information about the accepted client
    newClient.close(); // Close the socket connected to the client
    System.out.println("Client server closed"); // Print a message indicating that the client server is closed 
    newSocket.close(); // Close the server socket
    System.out.println("Server socket closed"); // Print a message indicating that the server socket is closed
  }
   catch (Exception e) { // Catch block: If an exception occurs during the execution of the try block
   e.printStackTrace(); // catch the exception, print the stack trace and handle it
   }
  }
}
 
