// Importing necessary classes for input/output operations and networking
import java.io.*; 
import java.net.*; 
public class echo_client {
	public static void main (String args[]) {
	try { // Try block: Attempt to execute the following code
	Socket socket = new Socket("localhost", 9008); // Create a socket and connect to the server on localhost (127.0.0.1) and port 9008
	BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in)); // Create BufferedReader to read user input from the console
	PrintWriter clientWriter = new PrintWriter(socket.getOutputStream(), true); // Create PrintWriter to send user input to the server
	System.out.print("Enter message: "); // Print a message prompting the user to enter a message
	clientWriter.println(userInput.readLine()); // Read a line of user input and send it to the server
	BufferedReader serverReader = new BufferedReader(new InputStreamReader (socket.getInputStream())); // Create BufferedReader to read the server's response
	String response = serverReader.readLine(); // Read the response from the server
	System.out.println("Server response: " + response); // Print the server's response
  // Close BufferedReader, PrintWriter, socket and user input stream
	userInput.close(); 
	serverReader.close(); 
	socket.close(); 
	clientWriter.close(); 
	} 
	catch (IOException e) { // Catch block: If an IOException occurs during the execution of the try block
		e.printStackTrace(); // catch the exception, print the stack trace and handle it
	}
}
}
