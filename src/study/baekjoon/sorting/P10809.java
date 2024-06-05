package study.baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 알파벳 찾기
public class P10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        br.close();
        int[] answer = new int[26];
        Arrays.fill(answer, -1);
        for(int i = 0; i < arr.length; i++) {
            if(answer[arr[i] - 97] != -1) continue;
            answer[arr[i] - 97] = i;
        }
        for(int i : answer) System.out.print(i + " ");
    }
}
