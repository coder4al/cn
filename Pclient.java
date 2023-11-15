import java.io.*;
import java.net.*;

class Pclient {
    public static void main(String[] args) throws IOException {
        try {
            Socket s = new Socket("LocalHost", 1111);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter print = new PrintWriter(s.getOutputStream());
            System.out.println("Enter IP Address : ");
            String str = br.readLine();
            System.out.println("Pinging " + str + " with 32 bytes of data");
            print.println(str);
            print.flush();
            s.close();
            br.close();
            print.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
