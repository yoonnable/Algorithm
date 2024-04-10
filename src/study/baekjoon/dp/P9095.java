package study.baekjoon.dp;

import java.util.Scanner;

// 1,2,3 더하기
public class P9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P9095 m = new P9095();
        int T = sc.nextInt();
        int arr[] = new int[T];
        for(int i = 0; i < T; i++) arr[i] = sc.nextInt();
        for(int i = 0; i < T; i++) System.out.println(m.solution(arr[i]));
    }
    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1; // 1
        if(n > 1) dp[2] = 2; // 1+1, 2
        if(n > 2) dp[3] = 4; // 1+1+1, 1+2, 2+1, 3
        for(int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
