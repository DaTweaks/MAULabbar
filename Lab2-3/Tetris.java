import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class Tetris {

    public static void Setup(){

    }

    public static void main(String[] args) {
        
        System.out.println(" _______  _______  _______  ______    ___   _______ \r\n" + //
                        "|       ||       ||       ||    _ |  |   | |       |\r\n" + //
                        "|_     _||    ___||_     _||   | ||  |   | |  _____|\r\n" + //
                        "  |   |  |   |___   |   |  |   |_||_ |   | | |_____ \r\n" + //
                        "  |   |  |    ___|  |   |  |    __  ||   | |_____  |\r\n" + //
                        "  |   |  |   |___   |   |  |   |  | ||   |  _____| |\r\n" + //
                        "  |___|  |_______|  |___|  |___|  |_||___| |_______|\r\n" + //
                        " __   __    ____         _______                    \r\n" + //
                        "|  | |  |  |    |       |  _    |                   \r\n" + //
                        "|  |_|  |   |   |       | | |   |                   \r\n" + //
                        "|       |   |   |       | | |   |                   \r\n" + //
                        "|       |   |   |  ___  | |_|   |                   \r\n" + //
                        " |     |    |   | |   | |       |                   \r\n" + //
                        "  |___|     |___| |___| |_______|                   ");
        System.out.println("Press enter to Continue!");
        
        Scanner scanner = new Scanner(System.in);
        
        scanner.nextLine();
    
        ConsoleShortcuts.ClearConsole();
    }

    public static class ConsoleShortcuts{
        public static void ClearConsole(){
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    public class ScreenManager{
        public String[] screenBackground =  new String[] {
            "----------",
            "----------",
            "----------",
            "----------",
            "----------",
            "----------",
            "----------",
            "----------",
            "----------",
            "----------",
            "----------",
            "----------",
            "----------",
            "----------",
            "----------",
        };

        public void StartUpdate(){
            ConsoleShortcuts.ClearConsole();

            for (String string : screenBackground) {
                System.out.println(string);
            }
            System.out.println(null);
        }
    }

    public class InputManager{
        
    }

    public class Vector{

    }

    public class Object{
        public boolean isStatic;
    }
}