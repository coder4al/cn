import java.io.*;
import java.net.*;

class Eserver {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket ss = new ServerSocket(8000);
            Socket s = ss.accept();
            System.out.println(s);

            BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter print = new PrintWriter(s.getOutputStream());
            String str;

            while (true) {
                str = br2.readLine();
                if (str.equals("END"))
                    break;
                System.out.println("\nMessage received from client : " + str);
                System.out.println("\nMessage to be send : ");
                str = br1.readLine();
                print.println(str);
                print.flush();
            }
            ss.close();
            br1.close();
            br2.close();
        } catch (IOException e) {
            System.out.print(e);
        }
    }
}