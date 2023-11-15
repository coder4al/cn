import java.io.*;
import java.net.*;

class Eclient {
    public static void main(String[] args) throws IOException {
        try {
            Socket s = new Socket("LocalHost", 8000);

            BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter print = new PrintWriter(s.getOutputStream());
            String str;

            while (true) {
                System.out.println("\nMessage to be send : ");
                str = br1.readLine();
                print.println(str);
                print.flush();
                str = br2.readLine();
                if (str.equals("END"))
                    break;
                System.out.println("\nMessage received from server : " + str);
            }

            s.close();
            br1.close();
            br2.close();
        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
