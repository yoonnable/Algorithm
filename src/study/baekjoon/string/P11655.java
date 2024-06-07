package study.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ROT13
public class P11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        for(char c : arr) {
            if(c >= 'A' && c <= 'Z') {
                char temp = (char) (c + 13);
                if(temp > 'Z') temp = (char) (temp - 'Z' + 'A' - 1);
                c = temp;
            } else if (c >= 'a' && c <= 'z') {
                char temp = (char) (c + 13);
                if(temp > 'z') temp = (char)(temp - 'z' + 'a' - 1);
                c = temp;
            }
            System.out.print(c);
        }

    }
}
