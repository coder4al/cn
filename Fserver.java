import java.net.*;
import java.io.*;

class Fserver {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1010);
        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintStream ps = new PrintStream(s.getOutputStream());

        System.out.println("Enter the file name : ");
        String fname = br.readLine();

        FileOutputStream fos = new FileOutputStream(fname + ".txt", true);
        BufferedOutputStream bos = new BufferedOutputStream(fos, 2048);
        char msg;
        while ((msg = (char) br.read()) != '@') {
            fos.write(msg);
        }

        ps.print(fname);
        
        fos.close();
        bos.close();
        ps.close();
        s.close();
        ss.close();
    }
}