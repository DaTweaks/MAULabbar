import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RagChew2 {
    public static String myIpAddress;
    public static Map<String, String> identifiers = new HashMap<>();
    public static int myPort = 6500;
    private static DatagramSocket udpSocket;

    public static void main(String[] args) {
        initializeIPManager();
    }

    public static void initializeIPManager() {
        myIpAddress = getIPAddress();
        try {
            udpSocket = new DatagramSocket(myPort);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            try {
                UDPListener();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        sendIdentification(System.getProperty("user.name"));
        sendRecognition();
        inputListener();
    }

    public static void inputListener() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String textInput = scanner.nextLine().trim();
            if (textInput.length() == 0)
                continue;

            if (textInput.equalsIgnoreCase("esc")) {
                System.out.println("Exiting!");
                return;
            }

            sendData(textInput);
        }
    }

    public static String getIPAddress() {
        try (DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            return socket.getLocalAddress().getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void initializeNewPort(int port) {
        myPort = port;
        udpSocket.close();
        try {
            udpSocket = new DatagramSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            try {
                UDPListener();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void sendData(String data, String ip = "255.255.255.255") {
        try {
            InetAddress address = InetAddress.getByName(ip);
            System.out.println(InetAddress.getByName(ip).getHostName());
            DatagramPacket packet = new DatagramPacket(data.getBytes(), data.length(), address, myPort);
            udpSocket.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendData(String data) {
        sendData(data, "255.255.255.255");
    }

    public static void sendIdentification(String name) {
        sendData("4*0*0*1*0*4: " + name);
    }

    public static void sendRecognition() {
        sendData("4*0*0*1*0*3");
    }

    public static void sendPoke(String ipAddress) {
        sendData("4*0*0*1*0*5: " + ipAddress, ipAddress);
    }

    public static void UDPListener() {
        byte[] receiveData = new byte[1024];
        while (true) {
            try {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                udpSocket.receive(receivePacket);
                String receivedString = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("RECEIVED: " + receivedString);

                if (receivedString.startsWith("4*0*0*1*0*3")) {
                    if (identifiers.containsKey(myIpAddress) && !myIpAddress.equals(receivePacket.getAddress().getHostAddress())) {
                        sendIdentification(identifiers.get(myIpAddress));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
