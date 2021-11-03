package day1.printstar;

import java.io.*;

public class PrintStarEx8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i < n; i++) {
            for (int j=0; j <= i; j++) {
                sb.append("*");
            }
            for (int k=0; k < 2*n - 2*(i+1); k++) {
                sb.append(" ");
            }
            for (int j=0; j <= i; j++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        for (int i=n-1; i > 0; i--) {
            for (int j=i; j > 0; j--) {
                sb.append("*");
            }
            for (int k=0; k < 2*n - 2*i; k++) {
                sb.append(" ");
            }
            for (int j=i; j > 0; j--) {
                sb.append("*");
            }

            sb.append("\n");
        }

        

        System.out.print(sb);
    }
}
