package study.baekjoon.dp;

import java.util.Scanner;

// 가장 큰 증가하는 부분수열
public class P11055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P11055 m = new P11055();
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(m.solution(n, a));
    }
    public int solution(int n, int[] a) {
        int answer = a[0];
        int[] dp = a.clone(); // dp를 a로 초기화 해두지 않으면,
        // 이중for문 안에 있는 if문에 해당이 안될경우(예: 본인 앞에 본인보다 작은 수가 없는 경우!)
        // dp[i]엔 아무 숫자도 들어가지 않으므로 답이 틀릴 수 있는 경우가 있다.
        for(int i = 1; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(a[i] > a[j] && dp[i] < dp[j] + a[i]) dp[i] = dp[j] + a[i];
            }
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}
