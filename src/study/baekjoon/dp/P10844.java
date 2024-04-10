package study.baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

// 쉬운 계단 수
public class P10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P10844 m = new P10844();
        int n = sc.nextInt(); // 1 <= n <= 100
        System.out.println(m.solution(n));
    }
    public int solution(int n) {
        int answer = 0;
        int[][] dp = new int[n + 1][10];
        Arrays.fill(dp[1], 1); // dp[1][0~9] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];
            for(int x = 1; x < 9; x++) {
                dp[i][x] = (dp[i - 1][x - 1] + dp[i - 1][x + 1]) % 1_000_000_000;
            }
        }
        for(int i = 1; i < 10; i++) {
            answer = (answer + dp[n][i]) % 1_000_000_000; // 더하기나 곱하기 연산은 무조건 나머지 구하는 식 해야 함(오버플로우 방지)
        }
        return answer;
    }
}
