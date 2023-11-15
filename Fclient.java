import java.net.*;
import java.io.*;

class Fclient {
    public static void main(String[] args) throws IOException{
        try {
            Socket s = new Socket("LocalHost", 1010);

            BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String fname = br2.readLine();
            System.out.println("Received file : " + fname);

            FileInputStream fis = new FileInputStream(fname + ".txt");
            BufferedInputStream bis = new BufferedInputStream(fis);

            System.out.println("Enter the new file name : ");
            fname = br1.readLine();

            FileOutputStream fos = new FileOutputStream(fname + ".txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos, 2048);
            int msg;
            while ((msg = bis.read()) != -1) fos.write((char) msg);
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
