import java.io.*; 
public class DataPacket implements Serializable { // Define a class named DataPacket that implements the Serializable interface
public DataPacket (int sequence, byte[] data, long time) { // Constructor to initialize the instance variables
this.sequence = sequence; // Initialize sequence with the provided sequence number
this.data = data; // Initialize data with the provided byte array
this.time = time; // Initialize time with the provided time
}
// Define a class named DataPacket that implements the Serializable interface.
int sequence; // Integer to store the sequence number
byte[] data; // Byte array to store data
long time; // Long to store time information
}
