import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    public static void main(String[] args) throws IOException {

//            ServerSocket serverSocket = new ServerSocket(8080);

//                try{
//                    Socket clientSocket = serverSocket.accept();
//
////                    System.out.println(clientSocket.getLocalAddress());
////                    System.out.println(clientSocket.getInetAddress());
////                    System.out.println(clientSocket.getLocalPort());
////
//                    FileInputStream input = new FileInputStream("D:\\Projects\\csweb\\index.html");
//                    System.out.println(input);
//
//                    OutputStream os = clientSocket.getOutputStream();
//
//                    os.write("HTTP/1.0 200 OK\r\n".getBytes());
//                    os.write("\r\n".getBytes());
//                    os.write(input.readAllBytes());
//                    os.flush();
//
////                    byte[] data = new byte[1024];
////                    int totRead = 0, numRead;
////                    while ((numRead = input.read(data)) != -1) {
////                        totRead += numRead;
////                        os.write(data, 0, numRead);
////                    }
//
//
////                    os.write(("Content-Length: " + totRead + "\r\n").getBytes());
////                    clientSocket.close();
////
//        while (true) {
            try {
                ServerSocket ss = new ServerSocket(8080);
                Socket s = ss.accept();
                System.out.println("File Transferred");
                FileInputStream input = new FileInputStream("D:\\Projects\\csweb\\index.html");
                System.out.println(input);

                OutputStream os = s.getOutputStream();

                os.write("HTTP/1.0 200 OK\r\n".getBytes());
                os.write("\r\n".getBytes());
                os.write(input.readAllBytes());
                os.flush();

                byte[] data = new byte[1024];
                int totRead = 0, numRead;
                while ((numRead = input.read(data)) != -1) {
                    totRead += numRead;
                    os.write(data, 0, numRead);
                }

            } catch (IOException ie) {
                ie.printStackTrace();
            }

        }

}







