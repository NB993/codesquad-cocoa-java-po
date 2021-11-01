package day1.printstart;

import java.io.*;

public class PrintStarEx7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i < n; i++) {
            for (int j=0; j < n - (i+1); j++) {
                sb.append(" ");
            }

            for (int k=0; k < (i*2) + 1; k++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        for (int i=n-1; i > 0; i--) {
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
