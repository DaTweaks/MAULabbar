import java.util.Scanner;
public class AskName{
  public static void main(String[] args) {
    String name; //en variabel att lagra en sträng i
    int lengthOfName; //en variabel att lagra ett heltal i för hur långt namnet är

    Scanner input = new Scanner(System.in);  //create scanner for input

    System.out.println("Ange ditt namn? ");
    name = input.nextLine(); //vi läser in en indata som en sträng med tecken
    lengthOfName = name.length(); //ta reda på hur lång strängen i variabeln name är och lagra svaret i variabeln lengthOfName

    //här ska du skriva din kod för vad vi nu ska göra

  }
}
