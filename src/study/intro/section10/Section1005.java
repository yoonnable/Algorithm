package study.intro.section10;

import java.util.*;

class Section1005 {

    static int n, m;

    public int solution(int[] coin) {
        int[] dy = new int[m + 1];
        Arrays.fill(dy, Integer.MAX_VALUE); // 일단 dy의 모든 값을 제일 큰 값으로 초기화
        dy[0] = 0; // 첫번째 값은 일단 거스름돈 0일 때니까 0으로 초기화
        for(int i = 0; i < n; i++) { // 동전 갯수만큼 반복
            for(int j = coin[i]; j <= m; j++) { // 해당 동전부터 거슬러줄 금액까지 반복
                if(dy[j] > dy[j - coin[i]] + 1) { // 이미 담겨진 값보다,
                    // 현재 탐색중인 동전으로 바꿨을 때의 최소 동전 갯수가 더 작으면
                    // 더 작은 값으로 체인지!
                    dy[j] = dy[j - coin[i]] + 1;

                }
            }
        }
        return dy[m];
    }
    public static void main(String[] args) {
        Section1005 s10 = new Section1005();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt(); // 동전의 종류 갯수 입력
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt(); // 주어진 동전 종류 입력
        m = kb.nextInt(); // 거슬러 줄 금액 입력
        System.out.println(s10.solution(arr));
    }
}