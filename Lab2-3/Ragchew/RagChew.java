import java.util.concurrent.CompletableFuture;
import java.util.Scanner;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.PrintStream;

public class RagChew {
    public static final String ansiReset = "\u001B[0m";

    public static final String ansiRecieved = "\u001B[36m"; // Cyan

    public static final String ansiSent = "\u001B[31m"; // Red

    public static final String ansiERR = "\u001B[35m";

    public static String userName;

    public static DatagramSocket clientSocket;

    public static int port = 6500;

    public static InetAddress IPAddress;

    private static CompletableFuture serverListener;

    private static DatagramSocket listenerDatagramSocket;

    public static void main(String[] args) {
        try{
            clientSocket = new DatagramSocket();
            clientSocket.setBroadcast(true);

            userName = InetAddress.getLocalHost().getHostName();

            IPAddress = InetAddress.getByName("255.255.255.255");

            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        }
        catch(Exception e){
            SendError(e.toString());
        }

        System.out.println("Welcome to Ragchew! (Do not overuse this pls)");
        Printhelp();

        serverListener = CompletableFuture.runAsync(() -> ServerPrinter());
        CompletableFuture.runAsync(() -> UserListener()).join();
    }

    public static void Printhelp(){
        System.out.println(ansiRecieved+"MessageRecieved Color"+ansiReset);
        System.out.println(ansiSent+"MessageSent Color"+ansiReset);
        System.out.println(ansiERR+"Error Color"+ansiReset);
        System.out.println("ESC     :-  Exit");
        System.out.println("RES     :-  Reset Server listener");
        System.out.println("HELP    :-  Open this help line");
    }

    public static void SendError(String errorString){
        System.out.println(ansiERR+errorString+ansiReset);
    }

    public static void UserListener(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            String userInput =  scanner.nextLine().trim();

            if(userInput.equalsIgnoreCase("ESC")){
                CloseServerListener();
                scanner.close();
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

            if(userInput.equalsIgnoreCase("RES")){
                CloseServerListener();
                serverListener = CompletableFuture.runAsync(() -> ServerPrinter());
                continue;
            }

            if(userInput.length() == 0)
                continue;

            SendData("</SENDER:"+userName+"/> : "+userInput);
        }
    }

    public static void ServerPrinter(){
        try{
		    listenerDatagramSocket = new DatagramSocket(port); 
		    byte[] receive = new byte[65535]; 

		    DatagramPacket DpReceive = null; 
	    	while (true) 
    		{ 
			    DpReceive = new DatagramPacket(receive, receive.length); 

			    listenerDatagramSocket.receive(DpReceive); 

                String data = data(receive).toString();

                if(data.contains("</SENDER:"+userName+"/>")){ // If i sent it, skip
                    continue;
                }
            

    			System.out.println(ansiRecieved+data+ansiReset); 
                
			    receive = new byte[65535]; 
		    } 
        }
        catch(Exception e){
            SendError(e.toString());
        }
    }

    public static void CloseServerListener(){
        if(!serverListener.isDone())
            serverListener.cancel(true);

        if(listenerDatagramSocket != null)
            listenerDatagramSocket.close();
    }

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
            var buf = data.getBytes(); 

            DatagramPacket DpSend = new DatagramPacket(buf, buf.length, IPAddress, port); 

            clientSocket.send(DpSend); 

            System.out.println(ansiSent+data+ansiReset);
        }
        catch(Exception e)
        {
            SendError(e.toString());
        }
    }
}