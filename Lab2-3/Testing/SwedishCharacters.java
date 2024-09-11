import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class SwedishCharacters {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
            String swedishChars = "ÅÄÖ";
            System.out.println("Swedish characters: " + swedishChars);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

