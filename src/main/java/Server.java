import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final static int PORT = 8080;

    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Listening on port " + PORT);

        while (true) {
            try (Socket socket = serverSocket.accept();
                 InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                 BufferedReader in = new BufferedReader(isr);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                System.out.println("Connection accepted");

                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Server received: " + line + ". Sending to client");
                    out.println(line);

                    if (line.equals("Bye")) {
                        break;
                    }
                }
            }
        }
    }
}
