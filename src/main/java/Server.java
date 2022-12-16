import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Server {

    public static void main(String[] args) throws IOException
    {
        System.out.println(Arrays.asList(args).toString());
        File file = new File(args[0]);
//        ServerSocket ss=new ServerSocket(8080);
//        Socket s=ss.accept();
//        OutputStream os = s.getOutputStream();
//        os.write("HTTP/1.0 200 OK\r\n".getBytes());
//
//        InputStream input = Files.newInputStream(Path.of("D:\\csweb\\index.html"));
//        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//        byte[] data = new byte[1024];
//        int totRead = 0,numRead;
//        while ((numRead = input.read(data)) != -1) {
//            totRead += numRead;
//            os.write(data,0, numRead);
//        }
////            os.write(("Content-Length: " + totRead + "\r\n").getBytes());
//        s.close();

        Socket socket ;
        InputStreamReader inputStreamReader ;
        OutputStreamWriter outputStreamWriter ;
        BufferedReader bufferedReader ;
        BufferedWriter bufferedWriter ;
        ServerSocket serversocket ;

        serversocket = new ServerSocket(5000);

        while (true) try {

            socket = serversocket.accept();

            OutputStream os = socket.getOutputStream();
        os.write("HTTP/1.0 200 OK\r\n".getBytes());

//        InputStream input = Files.newInputStream(Path.of("D:\\csweb\\index.html"));
            InputStream input = Files.newInputStream(Path.of(file.toURI()));
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int totRead = 0,numRead;
        while ((numRead = input.read(data)) != -1) {
            totRead += numRead;
            os.write(data,0, numRead);
        }
//            os.write(("Content-Length: " + totRead + "\r\n").getBytes());
        socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
