import java.io.*;
import java.net.*;

public class FileServer {

    // Create server socket:
    ServerSocket server = null;

    // For listening to incoming requests:
    boolean listening;

    public FileServer() {
        try {
            // Open new socket:
            server = new ServerSocket(3000);
            listening = true;
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }

        System.out.println("\nG'day, the server is up and running...");

        // Accept multiple client connections:
        while (listening) {
            try {
                new Session(server.accept());
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FileServer();
    }

}

class Session implements Runnable {

    // Create new socket object:
    Socket soc;

    // Create BufferedReader object:
    BufferedReader br;

    // Create new Thread object:
    Thread runner;

    // Create input stream object:
    DataInputStream input;

    // Create new string variable:
    String line;

    // Create new BufferedWriter object:
    BufferedWriter out;

    // Create BufferedReader:
    BufferedReader reader;

    Session(Socket s) {
        soc = s;
        try {
            br = new BufferedReader(new InputStreamReader(soc.getInputStream()));

            // InputStream for user's input:
            input = new DataInputStream(soc.getInputStream());

            // Reader for user's input:
            reader = new BufferedReader(new InputStreamReader(input));

        } catch (Exception e) {
            System.err.println(e);
        }

        // Start thread:
        if (runner == null) {
            runner = new Thread(this);
            runner.start();
        }
    }

    public void run() {
        try {
            while (true) {
                line = reader.readLine();
                
                // Check user's input:
                if (line.equals("exit")) {
                    input.close();
                    out.close();
                    System.exit(1);
                }
        
                // Write text to file:
                out = new BufferedWriter(new FileWriter("client-text.txt", true));
                out.write(line + "\n");
                out.close();
        
                // Printed to server console:
                System.out.println("Client " + soc.getInetAddress() + " : " + line);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}