import java.net.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.io.IOException; 
import java.io.PrintWriter;
import java.util.Date; 
public class dat {
	public static void main(String args[]) {
	try (ServerSocket ss = new ServerSocket(12440)) { // Create a ServerSocket object to listen on port 12440
	System.out.println("Server listening on port 12440...");
	while (true) { // Server runs indefinitely
	Socket cs = ss.accept(); // Wait for a client to connect; when a connection is accepted, returns a Socket object for communication
	System.out.println("Client connected: " + cs.getInetAddress()); // Print the IP address of the connected client  
	SimpleDateFormat formatted = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); // Create a SimpleDateFormat object to format the date
	String fdat = formatted.format(new Date()); // Format the current date and time
	try (PrintWriter out = new PrintWriter(cs.getOutputStream(), true)) { // Send the formatted date to the client
    out.println(fdat); // Write the formatted date to the client's output stream
                }
	}
	cs.close(); // Close the connection with the client
	}
	} catch (IOException e) {
		e.printStackTrace(); // Print any exceptions that occur
	}
}
 
