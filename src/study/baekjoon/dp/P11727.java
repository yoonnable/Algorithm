package study.baekjoon.dp;

import java.util.Scanner;

public class P11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        P11727 m = new P11727();
        System.out.println(m.solution(n));
    }
    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if(n > 1) dp[2] = 3;
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }
        return dp[n];
    }
}
