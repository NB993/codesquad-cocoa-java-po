package day1.gugudan;

import java.util.*;

public class Gugudan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startNum = sc.nextInt();
        int endNum = sc.nextInt();


        for (int i = startNum; i <= endNum; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + " * " + j + " = " + i*j);
            }
        }
    }
}
