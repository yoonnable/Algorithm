package study.baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

// 오르막 수
// 나머지 구하는거 때문에 빼기는 쓰지 말 것..!
public class P11057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P11057 m = new P11057();
        int n = sc.nextInt(); // 1 <= n <= 1000
        System.out.println(m.solution(n));
    }
    public int solution(int n) {
        int answer = 0;
        int[][] dp = new int[n + 1][10];
        Arrays.fill(dp[1], 1);
        for(int i = 2; i <= n; i++) {
            for(int x = 0; x < 10; x++) {
                for(int y = x; y < 10; y++) {
                    dp[i][x] += dp[i - 1][y];
                    dp[i][x] %= 10007;
                }
            }
        }
        for(int i = 0; i < 10; i++) {
            answer = (answer + dp[n][i]) % 10007;
        }
        return answer;
    }
}
