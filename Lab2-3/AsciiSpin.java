import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.RecursiveTask;

public class AsciiSpin {
 
   public static void main(String[] args) {
      CompletableFuture<Void> future = CompletableFuture.runAsync(() -> SpinningLine(200));

      Scanner scanner = new Scanner(System.in);

      scanner.nextLine();  

      System.out.println("Exiting!");
   }

   public static boolean isSpinning = true;

   public static final String ansiReset = "\u001B[0m";

   public static String[] ansiColors = new String[]{
      "\u001B[31m",
      "\u001B[32m",
      "\u001B[33m",
      "\u001B[34m",
      "\u001B[35m",
      "\u001B[36m",
      "\u001B[37m"
   };
   public static char[] spinAscii = new char[]{'/', '-', '\\', '|'};
 
   public static void SpinningLine(long frameduration)
   {
      for(int i = 0; isSpinning; ++i){
         if (i >= ansiColors.length) {
            i = 0;
         }
         for(int j = 0; j < spinAscii.length; ++j) {

            System.out.print("\033[H\033[2J");
            System.out.flush();
   
            System.out.println(ansiColors[i]+spinAscii[j]+"\nPress enter to exit."+ansiReset);
   
            try {
               Thread.sleep(frameduration);
            } catch (Exception e) {
            }
         }
      }
   }

   public void StopSpinning() {
   }
}
