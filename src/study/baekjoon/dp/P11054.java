package study.baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

// 가장 긴 바이토닉 부분 수열
public class P11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P11054 m = new P11054();
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(m.solution(n, a));
    }
    public int solution(int n, int[] a) {
        int answer = 1;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        // i가 0부터 시작해서 n-1까지 각 수의 LIS를 구해서 dp1에 대입
        for(int i = 1; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(a[i] > a[j] && dp1[i] < dp1[j] + 1) dp1[i] = dp1[j] + 1;
            }
        }
        // i가 n-1부터 시작해서 "0"까지 각 수의 LIS를 구해서 dp2에 대입
        for(int i = n-2; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                if(a[i] > a[j] && dp2[i] < dp2[j] + 1) dp2[i] = dp2[j] + 1;
            }
            // 각 수의 dp1[i]와 dp2[i]를 더한 값에서 중복되는 자기자신을 뺀(-1)값이 그 수의 바이토닉 수열.
            // 그 중 가장 큰 수를 리턴.
            answer = Math.max(answer, (dp1[i] + dp2[i] - 1));
        }
        return answer;
    }

    // 반례
    // 2
    // 2 1
    // 답 : 2
    // => n-1부터 "0"까지!!! 1까지 아님, 0까지 해야함!!!!!
}
