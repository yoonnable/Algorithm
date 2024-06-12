package study.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 접미사 배열
public class P11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = new String[str.length()];
        arr[0] = str;
        for(int i = 1; i < str.length(); i++) {
            arr[i] = arr[i - 1].substring(1);
        }
        Arrays.sort(arr);
        for(String s : arr) System.out.println(s);
    }
}
