import java.io.*;
import java.net.*;

class Pserver {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket ss = new ServerSocket(1111);
            Socket s = ss.accept();
            System.out.println("Ping server");
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String str = br.readLine();
            if (str != null)
                System.out.println("Pinged by client");
            br.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}