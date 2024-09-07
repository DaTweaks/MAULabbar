
public class LocalVariable {	// Exempel på lokala variabler:
    public void example() {		// number, real, bigNbr
   	    int number=100000;      // number initieras till 100000
    	double real;   	        // real har inget värde
    	long bigNbr;     		// bigNbr har inget värde
    
    	real = 13.25;
    	bigNbr = -37222654987L;

    	System.out.println( "int: " + number );
    	System.out.println( "double: " + real );
    	System.out.println( "long: " + bigNbr );
    }

    public static void main( String[] args ) {
        LocalVariable lv = new LocalVariable();	// lv är en lokal variabel
        lv.example();
    }
}
