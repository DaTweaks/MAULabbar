import java.util.Scanner;
public class VIPManager{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the store! ");
        System.out.println("Please input the amount of items you want to buy. more than 10 items and you get a discount!");
        
        int items = scanner.nextInt();

        boolean isVIP = false;
        
        if(items > 10){
            System.out.println("Are you a VIP? 1 for Yes and any other number for No.");
            int userinput = scanner.nextInt();
            isVIP = userinput == 1;
        }

        scanner.close(); // "ReSoUrCe LeAk"

        PrintReciept(items, isVIP);
    }

    public static void PrintReciept(int items, boolean isVIP){  
        
        int cost;

        if(items > 10){
            cost = items * 9;
            System.out.println("Items are more than 10. You only pay for 9kr per item!");
        }
        else{
            cost = items * 10;
            System.out.println("Items are not more than 10. You pay 10kr per item!");
        }

        if(isVIP){
            System.out.println("You are VIP therefore you get a 10% discount!");
            cost = (int)(cost*0.9);
        }
        else{
            System.out.println("You are not VIP therefore you don't get a 10% discount.");
        }

        System.out.println("The final cost is: "+cost+"kr");
    }
}