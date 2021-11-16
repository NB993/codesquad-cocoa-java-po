package day1.printstar;

import java.io.*;

public class PrintStarEx6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=n; i > 0; i--) {
            for (int j=0; j < n - i; j++) {
                sb.append(" ");
            }

            for (int k=0; k < (i*2) - 1; k++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
