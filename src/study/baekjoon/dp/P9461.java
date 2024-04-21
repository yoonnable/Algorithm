package study.baekjoon.dp;

import java.util.Scanner;

// 파도반 수열
public class P9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] q = new int[T];
        int n = 0;
        for(int i = 0; i < T; i++) {
            q[i] = sc.nextInt();
            n = Math.max(n, q[i]);
        }
        long[] arr = new long[n+1];
        arr[1] = 1;
        if(n > 1) arr[2] = 1;
        if(n > 2) arr[3] = 1;
        for(int j = 4; j <= n; j++) {
            arr[j] = arr[j-3] + arr[j-2];
        }
        for(int i = 0; i < T; i++) {
            System.out.println(arr[q[i]]);
        }
    }
}
