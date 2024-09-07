import java.util.concurrent.CompletableFuture;
import java.util.Scanner;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;



public class RagChew {
    public static final String ansiReset = "\u001B[0m";

    public static final String ansiRecieved = "\u001B[36m"; // Cyan

    public static final String ansiSent = "\u001B[31m"; // Red

    public static String userName;

    public static DatagramSocket clientSocket;

    public static int port = 6500;

    public static InetAddress IPAddress;

    public static void main(String[] args) {
        try{
            clientSocket = new DatagramSocket();
            clientSocket.setBroadcast(true); // Enable broadcasting

            userName = InetAddress.getLocalHost().getHostName();

            // Get the IP address of the server
            IPAddress = InetAddress.getByName("255.255.255.255");
        }
        catch(Exception e){

        }



        System.out.println("Welcome to Ragchew! (Do not overuse this pls)");
        Printhelp();

        CompletableFuture<Void> userListener = CompletableFuture.runAsync(() -> UserListener());
        CompletableFuture.runAsync(() -> ServerPrinter());

        userListener.join();
    }

    public static void Printhelp(){
        System.out.println(ansiRecieved+"MessageRecieved Color"+ansiReset);
        System.out.println(ansiSent+"MessageSent Color"+ansiReset);
        System.out.println("ESC     :-  Exit");
        System.out.println("HELP    :-  Open this help line");
    }

    public static void UserListener(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            String userInput =  scanner.nextLine().trim();

            if(userInput.equalsIgnoreCase("ESC")){
                System.out.println("Exiting!");
                break;
            }

            if(userInput.contains("</SENDER:")){
                System.out.println("Cannot contain this statement!");
                continue;
            }

            if(userInput.equalsIgnoreCase("HELP")){
                Printhelp();
                continue;
            }

            if(userInput.length() == 0)
                continue;

            SendData("</SENDER:"+userName+"/> : "+userInput);
        }
    }

    public static void ServerPrinter(){
try{
		// Step 1 : Create a socket to listen at port 1234 
		DatagramSocket ds = new DatagramSocket(port); 
		byte[] receive = new byte[65535]; 

		DatagramPacket DpReceive = null; 
		while (true) 
		{ 
			// Step 2 : create a DatgramPacket to receive the data. 
			DpReceive = new DatagramPacket(receive, receive.length); 

			// Step 3 : revieve the data in byte buffer. 
			ds.receive(DpReceive); 

            String data = data(receive).toString();

            if(data.contains("</SENDER:"+userName+"/>")){
                continue;
            }
            

			System.out.println(ansiRecieved+data+ansiReset); 

			// Clear the buffer after every message. 
			receive = new byte[65535]; 
		} 
}
catch(Exception e){

}


    }

    	// A utility method to convert the byte array 
	// data into a string representation. 
	public static StringBuilder data(byte[] a) 
	{ 
		if (a == null) 
			return null; 
		StringBuilder ret = new StringBuilder(); 
		int i = 0; 
		while (a[i] != 0) 
		{ 
			ret.append((char) a[i]); 
			i++; 
		} 
		return ret; 
	} 

    public static void SendData(String data){
        try{
  

            // convert the String input into the byte array. 
            var buf = data.getBytes(); 
  
            // Step 2 : Create the datagramPacket for sending 
            // the data. 
            DatagramPacket DpSend = 
                  new DatagramPacket(buf, buf.length, IPAddress, 6500); 
  
                  

            // Step 3 : invoke the send call to actually send 
            // the data. 
            clientSocket.send(DpSend); 

            System.out.println(ansiSent+data+ansiReset);
        }
        catch(Exception e)
        {

        }

    }
}