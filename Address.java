import java.net.*;

class Address {
    Address() {
    }

    public static void main(String[] stringArray) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("\nIp address is : " + String.valueOf(inetAddress));
        String string = inetAddress.getHostName();
        System.out.println("\nSystem number is : " + string);
        InetAddress inetAddress2 = InetAddress.getByName("sys24");
        System.out.println("\nName of the other system is : " + String.valueOf(inetAddress2));
    }
}
