package study.baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

// 합분해
public class P2225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        P2225 m = new P2225();
        System.out.println(m.solution(n, k));
    }
    public int solution(int n, int k) {
        // k = 1, dp[n] = 1
        // k = 2, dp[n] = n + 1
        // k >= 2, dp[n] = (k = k - 1) dp[0] + ... + dp[n]

        // dp는 2차 배열로 dp[k][n]
        int[][] dp = new int[k+1][n+1];

        // k = 1, dp[1][n] = 1
        Arrays.fill(dp[1], 1);
        for(int j = 2; j <= k; j++) {
            dp[j][0] = 1;
            for(int i = 1; i <= n; i++) {
                dp[j][i] = (dp[j][i-1] + dp[j-1][i]) % 1_000_000_000;
            }
        }
        return dp[k][n];
    }
}
