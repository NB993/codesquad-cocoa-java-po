package day1.loop;

import java.io.*;

public class LoopEx2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("");
        int sum = 0;

        for (int i=0; i < count; i++) {
            sum += Integer.parseInt(arr[i]);
        }

        System.out.println(sum);
    }
}
