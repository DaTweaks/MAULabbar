import java.io.IOException;
import java.net.*;

public class Receiver {

    public static void main(String[] args) {
      try{
        send();
      }
      catch(Exception e){

      }

    }

    public void run(int port) {    
      try {
        DatagramSocket serverSocket = new DatagramSocket(port);
        byte[] receiveData = new byte[8];
        String sendString = "polo";
        byte[] sendData = sendString.getBytes("UTF-8");

        System.out.printf("Listening on udp:%s:%d%n",
                "255.255.255.255", port);     
        DatagramPacket receivePacket = new DatagramPacket(receiveData,
                           receiveData.length);

        while(true)
        {
              serverSocket.receive(receivePacket);
              String sentence = new String( receivePacket.getData(), 0,
                                 receivePacket.getLength() );
              System.out.println("RECEIVED: " + sentence);
              // now send acknowledgement packet back to sender     
              DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                   receivePacket.getAddress(), receivePacket.getPort());
              serverSocket.send(sendPacket);
        }
      } catch (IOException e) {
              System.out.println(e);
      }
      // should close serverSocket in finally block
    }

    public static void send() throws IOException {
      // Discovery request command
      byte[] data = "__DISCOVERY_REQUEST__".getBytes();
      DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 6500);
      var sendSocket = new DatagramSocket(6500, InetAddress.getLocalHost());
      sendSocket.setBroadcast(true);
      sendSocket.send(packet);
      System.out.println("Discovery package sent!" + packet.getAddress() + ":" + packet.getPort());
  
      // Discovery response command
      byte[] response = new byte["__DISCOVERY_RESPONSE__".length()];
      DatagramPacket responsePacket = new DatagramPacket(response, response.length);
      sendSocket = new DatagramSocket(6500, InetAddress.getLocalHost());
      sendSocket.setBroadcast(true);
      sendSocket.receive(responsePacket);
      System.out.println("Discovery response received!" + responsePacket.getAddress() + ":" + responsePacket.getPort());
      String responseData = new String(responsePacket.getData()).trim();
      if (responseData.equals("__DISCOVERY_RESPONSE__")) { // Check valid command
          System.out.println("Found buddy!" + responsePacket.getAddress() + ":" + responsePacket.getPort());
      }
  }
}