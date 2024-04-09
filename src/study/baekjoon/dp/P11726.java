package study.baekjoon.dp;

import java.util.Scanner;

public class P11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P11726 m = new P11726();
        int n = sc.nextInt(); // 1 <= n <= 1,000
        System.out.println(m.solution(n));
    }
    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1; // 2 * 1 직사각형의 타일 채우는 방법의 수
        // n이 1이면 dp[2]는 런타임 에러 발생
        if(n > 1) dp[2] = 2; // 2 * 2 직사각형의 타일 채우는 방법의 수
        //타일을 채우는 첫 시작은 2*1을 하느냐, 2*2를 하느냐 두 가지로부터 시작하므로
        // 첫 1~2칸을 채운 뒤 나머지 칸(n-1, n-2)의 채우는 방법의 수를 합치면 된다.
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
            // 10,0007로 나눈 나머지를 구하는 이유
            // 저장할 수 있는 수의 범위가 없다면, 마지막이 아닌 중간에 %10007을 하는 것과 마지막에 %10007을 하는 것의 결과가 똑같음을 증명할 수 있습니다.
            //  => %는 다음과 같은 분배법칙이 성립합니다. A few distributive properties of modulo are as follows: ( a + b) % c = ( ( a % c ) + ( b % c ) ) % c
            // 여기서는 수가 int 범위까지만 갈 수 있기 때문에 중간에 %10007을 안 하면 오히려 잘못된 값으로 오버플로우하게 됩니다.
            // 직감적으로 와닿지 않는다면 10진수의 수에서 일의 자리만 구하는 경우를 생각해보시면 됩니다.
            // 덧셈과 곱셈만으로 이루어진 연산들에서 10의 자리를 넘어가는 건 아무 의미가 없으니, 매 연산마다 그 1의 자리 하나만 추적하고 있어도 결과는 똑같이 나옵니다.
            // 마찬가지로, 이 수를 10007진수라고 생각하고 끝자리 한 자리만 추적해도 결과는 같습니다.
            System.out.println(i + " = " + dp[i]);
        }
        return dp[n];
    }
}
