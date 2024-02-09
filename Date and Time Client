import java.io.*; 
import java.net.*;
import java.io.IOException; 
public class dat1 {
	public static void main (String args[]) {
		try (Socket s = new Socket("localhost", 12440)){ // Connect to the server running on localhost at port 12440
		System.out.println("Connected to the server "); 
		try (BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()))) {  // Setup input stream to receive data from the server
		String response = input.readLine(); // Read the server's response
		System.out.println("Server date and time: " + response); // Print the received date and time from the server
		}
		}
		catch (IOException e) { // Catch IOException if any error occurs during socket operations
		e.printStackTrace(); // Print the stack trace of the exception
		}
		}
}
