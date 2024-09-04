
public class LocalVariable {	// Exempel på lokala variabler:
    public void example() {		// number, real, bigNbr
   	  int number=100000;      // number initieras till 100000
    	double real;   	        // real har inget värde
    	long bigNbr;     		// bigNbr har inget värde

    	real = 13.25;
    	bigNbr = -37222654987L;

    	System.out.println( "int: " + number ); // skriver ut "int: " + number i kommandotolken
    	System.out.println( "double: " + real ); // skriver ut "double: " + real i kommandotolken
    	System.out.println( "long: " + bigNbr ); // skriver ut "long: " + bigNbr i kommandotolken
    }

    public static void main( String[] args ) {
        LocalVariable lv = new LocalVariable();	// lv är en lokal variabel, behöver inte bekymra dig för detta ännu!
        lv.example(); // anropar metoden example.
    }
}
