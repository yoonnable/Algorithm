package study.baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

// 가장 긴 감소하는 부분 수열
public class P11722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P11722 m = new P11722();
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(m.solution(n, a));
    }
    public int solution(int n, int[] a) {
        int answer = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // 갯수니까 하나만 있으면 무조건 1로 시작하니 1로 초기화
        for(int i = 1; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(a[i] < a[j] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
            }
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}
