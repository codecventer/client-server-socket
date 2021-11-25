import java.io.*;
import java.net.*;

public class FileClient {
    
    public static void main(String[] args) {

        // Create new socket:
        Socket clientSocket = null;

        // Create new PrintWriter:
        PrintWriter out = null;

        // Create new BufferedReader:
        BufferedReader in = null;

        try {
            // Open new socket:
            clientSocket = new Socket("127.0.0.1", 3000);

            // Pass user's input to server:
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            System.out.println("\nWelcome to the client! Enter your text below:");

        } catch (Exception e) {
            System.err.println(e);
        }

        // Get user's input:
        BufferedReader stdln = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        try {
            // Read user's input:
            while((userInput = stdln.readLine()) != null) {

                // Close application and sockets if 'exit' is entered:
                if (userInput.equals("exit")) {
                    clientSocket.close();
                    stdln.close();
                    System.exit(1);
                }

                // Update user's input to server:
                out.println(userInput);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

}
