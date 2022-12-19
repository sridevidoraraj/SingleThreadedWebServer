import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Server {

    public static void main(String[] args) throws IOException {
//        System.out.println(Arrays.asList(args).toString());
//        for(int i=0;i<args.length;i++)
//            System.out.println(args[i]);
        System.out.println("Argument count: " + args.length);
        for (int i = 0; i < args.length; i++)
            System.out.println("Argument " + i + " : " + args[i]);
        if(args.length>0){
        String firstFile = args[0];
        File file = new File(firstFile);


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

            Socket socket;
            InputStreamReader inputStreamReader;
            OutputStreamWriter outputStreamWriter;
            BufferedReader bufferedReader;
            BufferedWriter bufferedWriter;
            ServerSocket serversocket;

            serversocket = new ServerSocket(8080);

             try {

                socket = serversocket.accept();

                OutputStream os = socket.getOutputStream();
                os.write("HTTP/1.0 200 OK\r\n".getBytes());

//        InputStream input = Files.newInputStream(Path.of("D:\\csweb\\index.html"));
                InputStream input = Files.newInputStream(file.toPath());
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                byte[] data = new byte[1024];
                int totRead = 0, numRead;
                while ((numRead = input.read(data)) != -1) {
                    totRead += numRead;
                    os.write(data, 0, numRead);
                }
//            os.write(("Content-Length: " + totRead + "\r\n").getBytes());
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
