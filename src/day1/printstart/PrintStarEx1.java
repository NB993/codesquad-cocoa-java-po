package day1.printstart;

import java.util.*;

public class PrintStarEx1 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        for (int i=1; i <= n; i++) {
            for (int j=0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
