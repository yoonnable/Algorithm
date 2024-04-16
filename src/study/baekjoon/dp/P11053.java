package study.baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

// 가장 긴 증가하는 부분수열 : LIS 최장증가수열
public class P11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P11053 m = new P11053();
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = sc.nextInt();
        System.out.println(m.solution(a, n));
    }
    public int solution(int[] a, int n) {
        int answer = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                // [주의] ++dp[i]와 dp[i]+1의 차이는 ++dp[i]를 하면 dp[i]+1이 dp[i]에 대입까지 해버린다.
                if(a[i] > a[j] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
            }
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}
