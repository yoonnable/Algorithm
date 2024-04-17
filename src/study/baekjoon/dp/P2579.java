package study.baekjoon.dp;

import java.util.Scanner;

// 계단오르기
public class P2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P2579 m = new P2579();
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(m.solution(n, a));
    }
    public int solution(int n, int[] a) {
        int[] dp = new int[n+1];
        dp[1] = a[1];
        if(n > 1) dp[2] = a[1] + a[2];
        for(int i = 3; i <= n; i++) {
            // 이전 계단 밟고 마지막 계단 밟기 vs 이전 계단 안밟고 마지막 계단 밟기 (vs 이전 연속 2계단 안밟고 마지막 계단 밟기) -> 세번째 경우는 첫번째 경우보다 무조건 작으므로 비교할 필요 없음
            dp[i] = Math.max(dp[i-3] + a[i-1] + a[i], dp[i - 2] + a[i]);
        }
        // 마지막 계단 밟는게 필수이니까
        return dp[n];
    }
}
