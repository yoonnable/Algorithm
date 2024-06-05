package study.baekjoon.sorting;

import java.util.Scanner;

// 알파벳 갯수
public class P10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] answer = new int[26];
        char[] arr = s.toCharArray();
        for(char c : arr) {
            answer[c - 97]++;
        }
        for(int i : answer) System.out.print(i + " ");
    }
}
