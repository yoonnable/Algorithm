package study.baekjoon.dp;

import java.util.Scanner;

// 연속합
public class P1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if(i == 0) {
                max = arr[i];
                continue;
            }
            // '이전 최대합 + 자기자신' 보다 '자기자신'이 크면 자기 자신으로!
            if(arr[i] < arr[i] + arr[i - 1]) arr[i] += arr[i - 1];
            max = Math.max(max, arr[i]);
        }
        System.out.println(max);
    }
}
