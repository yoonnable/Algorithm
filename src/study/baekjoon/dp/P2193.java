package study.baekjoon.dp;

import java.util.Scanner;

// 이친수
public class P2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P2193 m = new P2193();
        int n = sc.nextInt(); // 1 <= n <= 90
        System.out.println(m.solution(n));
    }
    public long solution(int n) {
//        int [] dp = new int[n + 1]; // 정수형 초과함...
        // int : 2의 32승, -21억~21억 범위의 숫자만 저장 가능.
        // n = 90일 때 dp[90] = 2,880,067,194,370,816,120 임..
        // long : 2의 64승, 즉 약 -9,223,372,036,854,775,808 부터 9,223,372,036,854,775,807 까지의 정수를 표현함.
        long[] dp = new long[n + 1];
        // 0으로 시작할 수 없음.
        // 1이 연속으로 들어갈 수 없음.
        // 즉, 세자리 이상의 이진수가 있을 때, 왼쪽부터 첫번째 1, 두번째 0은 고정!
        // 세 번째부터의 경우의 수를 모두 더하면 된다.
        // 규칙을 보면,
        // n = 1 -> 1 => 1개
        // n = 2 -> 10 => 1개
        // n = 3 -> 100, 101 => 2개
        // n = 4 -> 1000, 1001, 1010 => 3개
        // 여기까지 보면, n = 4일때, 왼쪽부터 첫째, 둘째 자리는 10으로 통일이고,
        // 그 옆 셋째, 넷째 자리는 (n = 3 일때의 셋째, 넷째 자리패턴) + (n = 2 일때의 둘째, 셋째 자리패턴) 과 동일하다.
        // 즉, n개의 경우의 수는 n - 1 경우의 수와 n - 2 경우의 수의 합이다.
        // 더 증명하기 위해 n = 5도 알아보자.
        // n = 5 -> 10000, 10001, 10010(여기까지 n = 4 경우의 수), 10100, 10101(여기까지 n = 3 경우의 수)
        dp[1] = 1;
        if(n > 1) dp[2] = 1;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
