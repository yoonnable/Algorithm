package study.baekjoon.dp;

import java.util.*;

// 스티커
public class P9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P9465 m = new P9465();
        int T = sc.nextInt();
        int[] list = new int[T];
        for(int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[][] arr  = new int[2][n];
            for(int j = 0; j < 2; j++) {
                for(int x = 0; x < n; x++) {
                    arr[j][x] = sc.nextInt();
                }
            }
            list[i] = m.solution(arr);
        }
        for(int i = 0; i < T; i++) System.out.println(list[i]);
    }
    public int solution(int[][] arr) {
        int n = arr[0].length;
        // arr[2][n]에서 n이 1일 때부터 차례대로 차근차근 살펴보면
        // arr[2][1]에선 각 자리별 자기 자신이 최대 값이니, 각 자리까지의 최댓값을 dp[][]배열을 만들어 따로 저장시킨다.
        // 그럼, 만약 arr[2][3]이라고 했을 때,
        // arr[0][2]까지의 최대값을 구하려면 우선 arr[1][2]와 arr[0][1]은 제외 시켜야한다.
        // 그리고 남은 arr[1][1], arr[0][0], arr[1][0]인데, 여기서 arr[0][0]의 최댓값까지 확인할 필요가 있을까? 없다.
        // arr[0][0]은 arr[1][1]이 흡수할 수 있는 녀석이므로 arr[1][1]을 탐색하면 굳이 arr[0][0]은 탐색할 필요가 없다.
        // 만약 arr[1][1]이 arr[0][0]을 흡수하지 않았더라도, 그럼 최댓값이 아니라는게 이미 증명된거니 이또한 굳이 탐색할 필요가 없다.
        // 즉 arr[0][p]이면, arr[1][p-1]과 arr[1][p-2]만 탐색하면 됨!
        // 그리고 나서 마지막에 arr[0][n-1]과 arr[1][n-1]중에 큰 수를 출력하면 된다.
//        int[][] dp = new int[2][n];
//        dp[0][0] = arr[0][0];
//        dp[1][0] = arr[1][0];
//
//        for(int w = 1; w < n; w++) {
//            for(int h = 0; h < 2; h++) {
//                int allowH = h == 0? 1 : 0;
//                int max = dp[allowH][w - 1];
//                if(w > 1) {
//                    max = Integer.max(max, dp[allowH][w - 2]);
//                }
//                dp[h][w] = max + arr[h][w];
//            }
//        }
//        return Integer.max(dp[0][n - 1], dp[1][n - 1]);
        
        // 간결한 코드(성능은 차이 없음 ㅠ)
        if(n > 1) {
            arr[0][1] += arr[1][0];
            arr[1][1] += arr[0][0];
        }
        for(int i = 2; i < n; i++) {
            arr[0][i] += Integer.max(arr[1][i - 1], arr[1][i - 2]);
            arr[1][i] += Integer.max(arr[0][i - 1], arr[0][i - 2]);
        }
        return Integer.max(arr[0][n - 1], arr[1][n - 1]);
    }
}
