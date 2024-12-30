import java.net.InetAddress; // Import the InetAddress class from the package 
public class socketprogramming { // Define the main class for socketprogramming 
public static void main (String args[]) {
  try { // Try block: Attempt to execute the following code
  // Get the local host name using InetAddress class
    String name = InetAddress.getLocalHost().getHostName(); // Obtain the local host name using InetAddress class 
    System.out.println("System Name: " + name); // Print the console system name 
  } 
    catch (Exception e) { // Catch block: If an exception occurs during the execution of the try block, Catch It
    System.err.println(e.getMessage()); // Print any exception messages to the error stream if an exception occurs
    } 
  }
} 
