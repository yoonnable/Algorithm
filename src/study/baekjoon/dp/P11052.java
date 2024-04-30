package study.baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

// 카드 구매하기
public class P11052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n + 1];
        for (int i = 1; i < n+1; i++) p[i] = sc.nextInt();
        P11052 m = new P11052();
        System.out.println(m.solution(n, p));
    }
    public long solution(int n, int[] p) {
        long[] dp = new long[n + 1];
        for(int i = 1; i < n + 1; i++) { // 먼저 1장 카드팩으로만 구매했을 때 금액을 dp[i] 에 넣는다.
            dp[i] = p[1] * i;
        }
        for(int i = 2; i < n + 1; i++) { // 2장 카드팩부터 N장 카드팩을 구매했을 때 금액 탐색
            if(dp[i] < p[i]) { // 기존에 들어가있는 구매금액보다 현재 탐색하고 있는 카드팩으로 구매했을 때가 더 비싸면,, 탐색하기
                for(int j = i; j < n + 1; j++) {
//                    dp[j] = dp[j-i] + p[i]; // 기존 금액에서 현재 탐색중인 카드팩 장수만큼 뺀 카드를 구매한 가격에 현재 탐색중인 금액 더해서 대입하기 -> 최댓값 갱신
                    if(dp[j] < dp[j-i]+p[i]) dp[j] = dp[j-i] + p[i]; // 카드팩 금액이 커도 총합 금액은 작은 경우가 있으니 한번 더 최댓값 확인 후 대입
                }
            }
        }
        return dp[n];
    }
}
