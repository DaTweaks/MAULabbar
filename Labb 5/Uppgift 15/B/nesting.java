public class nesting{
    public static void main(String[] args){
        HurJagSkulleGjortDet();
        VadDeVill();
    }

    public static void HurJagSkulleGjortDet(){
        int i = 1;
        String s = "s";

        System.out.println("Hur Jag skulle gjort det:");

        if((s == "r" || s == "s") && i >= 2 && i >= 0){
            System.out.println(i);
        }

        System.out.println("3");
    }

    public static void VadDeVill(){
        int i = 1;
        String s = "s";

        System.out.println("Vad De vill jag ska göra");

        if(s == "r" || s == "s"){
            switch (i) { // ASFULT SÄTT ATT GÖRA DET VILL DÖ
                case 0:
                    System.out.println("0");
                    break;
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                default:
                    System.out.println("3");
            }
        }
        else{
            System.out.println("3");
        }
    }
}