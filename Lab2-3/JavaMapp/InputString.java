
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;  // eller  import javax.swing.*;

public class InputString {

    static ArrayList<Integer> yes = new ArrayList<>();

    static int[] arr = { 5, -2, 23, 7, 87, -42, 509 };

    public static void main(String[] args) {

        Arrays.sort(arr);

        for (int i : arr) {
            yes.add(i);   
            System.out.println(i+" List length: "+yes.size());
        }
	}
}
