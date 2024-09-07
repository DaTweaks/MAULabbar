public class MathEx {
    public void example() {
        int nbr1 = 12, nbr2 = 6; // Genom att skriva på detta sättet kan vi deklarera och initiera två int variablar samtidigt.

        System.out.println(nbr1 + nbr2); // Gör uträkningen
    }

    public static void main(String[] args) {
        MathEx prog = new MathEx(); // behöver ej bekymra dig om detta ännu!
        prog.example(); // anropar metoden example
    }
}
