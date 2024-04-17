package study.baekjoon.dp;

import java.util.Scanner;

// 제곱수의 합
public class P1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P1699 m = new P1699();
        int n = sc.nextInt();
        System.out.println(m.solution(n));
    }
    public int solution(int n) {
        int[] dp = new int[n + 1];
        // 먼저, 1제곱근으로만 구성된 항의 갯수 대입
        for(int i = 0; i < n+1; i++) dp[i] = i;
        // 이제 x제곱근을 포함하는게 가능한 숫자들한테 x제곱근이 포함된 항의 갯수 대입하기
        int x = 2;
        // x제곱근보다 커야함.
        while (n >= x * x) {
            int y = x * x;
            System.out.println(x + "의 제곱근 : " + y);
            // x의 제곱근부터 n까지 x제곱근을 포함했을 때 갯수 구하기
            for(int i = y; i <= n; i++) {
                int temp = i - y;
                int count = 1; // x제곱근 항 하나 증가
                while(temp > y) { // x제곱근을 뺀게 x제곱근보다 크다면 작아질 때까지 빼기
                    count++; // x제곱근으로 채워지는 항 하나씩 증가시키기
                    temp = temp - y;
                }
                dp[i] = Math.min(dp[i], count + dp[temp]);
                // x제곱근보다 작게 남은 temp의 최소 항을 더한다.
                // 기존 dp[i]에 담긴 값과 크기 비교 후 작은 걸 넣어야 한다.

                System.out.println(i + "  : " + dp[i]);
            }
            x++;
        }
        return dp[n];
    }
}


// 반례: 18
// 정답 : 2(3^2 + 3^2)
