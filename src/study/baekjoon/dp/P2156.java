package study.baekjoon.dp;

import java.util.Scanner;

public class P2156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P2156 m = new P2156();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(m.solution(n, arr));
    }
    public int solution(int n, int[] arr) {
        // int[] arr : 주어진 포도주가 담긴 배열
        // int[] dp : 각 index 까지의 포도주가 있을 때 최대로 마실 수 있는 포도주 양을 담은 배열

        // 포도주를 1부터 n까지 탐색할 때,
        // 각 해당 포도주를 마셨을 때, 최대 양을 파악하는 경우는 3가지다.
        // 1. 직전 포도주를 마시고, 이번 잔을 마신 경우 (ㅁxoo) dp[n-3] + arr[n-1] + arr[n] (dp[n - 3] 더하는건 n > 2일때만)
        // 2. 직전의 포도주를 마시지 않고, 이번 잔을 마신 경우 (ㅁxo) dp[n-2] + arr[n]
        // 3. 직전 두 번 연속 포도주를 마시지 않고, 이번 잔을 마신 경우 (ㅁxxo) dp[n-3] + arr[n] (n > 2 일때만)
        // 그리고 해당 포도주를 마시지 않는게 더 큰 경우일 수도 있다!!
        // 4. 직전 두 번 연속 포도주를 마시던 안마시던, 이번 잔을 마시지 않는 경우
        // 위 1~3번의 경우는 각각의 배열을 만들어 넣어주고.
        // 4번은 n일 때의 최댓값과, 이미 n-1까지 탐색한 것들 중의 최댓값을 비교하면 된다.

        int[] dp = new int[n];
        dp[0] = arr[0];
        if(n > 1) dp[1] = dp[0] + arr[1];
//        System.out.println("0 " + dp[0]);
//        System.out.println("1 " + dp[1]);

        for(int i = 2; i < n; i++) {
            // 먼저, 1~3중에서 최댓값 선별
            int pre = 0;
            if(i > 2) pre = dp[i - 3];
//            dp[i] = Math.max(Math.max(pre + arr[i-1] + arr[i], dp[i-2] + arr[i]), pre + arr[i]);
            // 근데 여기서 보면 3번 식은 1번식에서 arr[i-1]만 빠진 값이므로 무조건 1번식이 클테니 3번 연산은 할 필요가 없어졌다.
//            dp[i] = Math.max(pre + arr[i-1] + arr[i], dp[i-2] + arr[i]);

            // 선별한 최댓값과 4. 이번 잔을 마시지 않은 경우와 비교후 최댓값 dp[]에 대입
//            dp[i] = Math.max(dp[i], dp[i-1]);
            // 결국 1,2,4 중 최댓값 구하는 것이므로 한줄로 정리 가능.
            dp[i] = Math.max(Math.max(pre + arr[i-1] + arr[i], dp[i-2] + arr[i]), dp[i-1]);

        }
        // 마지막 dp[n-1] 리턴
        return dp[n-1];
    }
    // 틀림 : 중간에 두번 연속 포도주를 마시지 않는 게 더 큰 경우
//    public int solution (int n, int[] arr) {
//        int[] direct = new int[n];
//        int[] space = new int[n];
//        direct[0] = arr[0];
//        space[0] = arr[0];
//        int max = arr[0];
//        if(n > 1) {
//            direct[1] = space[0] + arr[1];
//            space[1] = arr[1];
//            max = direct[1];
//        }
//        for(int i = 2; i < n; i++) {
//            direct[i] = space[i-1] + arr[i];
//            space[i] = direct[i-2] + arr[i];
//            int temp = Integer.max(direct[i], space[i]);
//            max = Integer.max(temp, max);
//        }
//        return max;
//    }
}
