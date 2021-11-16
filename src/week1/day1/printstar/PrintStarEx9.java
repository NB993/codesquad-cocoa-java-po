package day1.printstar;

import java.io.*;

public class PrintStarEx9 {

    public static void printStrings(StringBuilder sb, int n) {
        for (int i = 0; i < n; i++) {
            stackStrings(sb, " ", i);
            stackStrings(sb, "*", (2 * n)  - (2 * i) - 1);

            sb.append("\n");
        }

        for (int i = 1; i < n; i++) {
            stackStrings(sb, " ", n - i - 1);
            stackStrings(sb, "*", 2 * i + 1);

            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static StringBuilder stackStrings(StringBuilder sb, String str, int n) {
        return sb.append(str.repeat(n));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        printStrings(sb, n);
    }


}
