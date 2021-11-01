package day1.printstart;

import java.util.*;

public class PrintStarEx2 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        String s = "";

        for (int i=0; i < n; i++) {
            for (int j=0; j <= i; j++) {
                s += "*";
            }

            String str = String.format("%" + n + "s%n", s);
            System.out.printf(str);

            s = "";
        }
    }
}
