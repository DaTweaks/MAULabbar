import java.util.Scanner;

/* This class represents a small program that asks the user for his or her name
   and prints it out. The input to the program is given in the console through Scanner.
*/

public class Nameprogram{

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println(Hej, anka ditt namn!");
        String name = scanner.nextLine();
        System.out.println("Ditt namn är " + name + "!!!");
    }

}