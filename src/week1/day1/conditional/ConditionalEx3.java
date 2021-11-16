package day1.conditional;

import java.util.*;

public class ConditionalEx3 {
    public static void main(String[] args) {
        int a = new Scanner(System.in).nextInt();

        if ((a % 4 == 0) && (a % 100 != 0) || (a % 400 == 0)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
