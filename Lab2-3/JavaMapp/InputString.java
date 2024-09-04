
import javax.swing.JOptionPane;  // eller  import javax.swing.*;

public class InputString {

    public void example() {
        String message, name; // String   lagrar ett antal tecken
        
        name = JOptionPane.showInputDialog( "Ange ditt namn" );
        message = "Hej " + name + "! Vilket vackert namn!!!";
        JOptionPane.showMessageDialog( null, message );
    }

    public static void main(String[] args) {
    	InputString prog = new InputString();
        prog.example();
	}
}
