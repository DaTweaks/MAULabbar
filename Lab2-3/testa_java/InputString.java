
import javax.swing.JOptionPane;  // eller  import javax.swing.*; Behöver inte bekymra dig över detta ännu!

public class InputString {

    public void example() { //Metod som heter example.
        String message, name; // String   lagrar ett antal tecken

        name = JOptionPane.showInputDialog( "Ange ditt namn" ); //Skriva input i ett nytt fönster och inte i terminalen.
        message = "Hej " + name + "! Vilket vackert namn!!!";
        JOptionPane.showMessageDialog( null, message ); //Visa ditt namn + message i ett nytt fönster.
    }

    public static void main(String[] args) {
    	InputString prog = new InputString(); //Behöver inte bekymra dig över detta ännu!
        prog.example(); //Anropar metoden example.
	}
}
