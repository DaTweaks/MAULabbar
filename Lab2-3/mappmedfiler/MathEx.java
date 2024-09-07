public class MathEx {
    public void example() {
        int nbr1 = 13, nbr2 = -5;
        double value = 9;
        
        System.out.println(value + "*" + value + "=" + Math.pow(value,2));
        System.out.println(value + "*" + value + "*" + value + "=" + Math.pow(value,3));
        System.out.println("kvadratroten av " + value + " är " + Math.sqrt(value));
        System.out.println("Störst av " + nbr1 + " och " + nbr2 + " är " + Math.max(nbr1,nbr2));
    }
    
    public static void main(String[] args) {
        MathEx prog = new MathEx();
        prog.example();
    }
}
