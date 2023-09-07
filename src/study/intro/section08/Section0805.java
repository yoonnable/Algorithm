package intro.study.section08;

import java.util.*;

class Section0805 {
    static int answer = Integer.MAX_VALUE, n, m;

    public void DFS(int L, int sum, Integer[] arr) {
        if(sum > m) return; // 반복문 멈추기!
        if(L >= answer) return; // 불필요한 반복 하지 않기!
        if(sum == m) {
            answer = Math.min(answer, L);
        } else {
            for(int i = 0; i < n; i++) DFS(L + 1, sum + arr[i], arr);
        }
    }

    public static void main(String[] args) {
        Section0805 s8 = new Section0805();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        Arrays.sort(arr, Collections.reverseOrder()); // 실행 시간을 단축 시키기 위한 배열 뒤집기
        // 큰 수부터 시작해야 금세 적은 갯수의 조합으로 거스름돈을 만들 수 있기 때문이다.

        m = kb.nextInt();
        
        s8.DFS(0, 0, arr); //0개의 동전의 합, 0원 에서부터 출발~!
        
        System.out.println(answer);
    }
}