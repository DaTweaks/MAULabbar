// Source code is decompiled from a .class file using FernFlower decompiler.

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.RecursiveTask;

public class AsciiSpin {
 
    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> SpinningLine(0, 0, 200));

        var scanner = new Scanner(System.in);

        scanner.nextLine();

        System.out.println("Exiting!");
    }

    public static boolean isSpinning = true;
    public static char[] spinascii = new char[]{'/', '-', '\\', '|', '/', '-', '\\', '|'};
 
    public static void SpinningLine(int x, int y, long frameduration)
    {
       for(int i = 0; isSpinning; ++i) {
          if (i >= spinascii.length) {
             i = 0;
          }
 
          System.out.print("\033[H\033[2J");
          System.out.flush();

          System.out.print(spinascii[i]);

          // TODO: Wait for the frameduration before continuing

          try {
            Thread.sleep(frameduration);
          } catch (Exception e) {
            // TODO: handle exception
          }
       }
 
    }

    public void StopSpinning() {
       this.isSpinning = false;
    }

 }
