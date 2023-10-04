package study.intro.section10;

import java.util.*;

class Section1002 {
    // Section1001문제랑 똑같음
    // 단, 돌다리를 건너는 방법은 돌다리 갯수가 아닌 돌다리를 넘어간 갯수로
    // 돌다리 갯수 + 1 의 갯수를 구해야 한다.
    static int[] dy;

    public int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for(int i = 3; i <= n + 1; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }
        return dy[n + 1];
    }

    public static void main(String[] args) {
        Section1002 s10 = new Section1002();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 돌다리 갯수 입력 받음
        dy = new int[n + 2]; // 돌다리 건너는 방법 갯수 넣을 배열 만들기
        // n + 2개인 이유 : 돌다리는 1부터 n까지로 돌다리를 "건너는" 방법은 돌다리 갯수 뒤의 땅까지 세어주어야하므로 배열 요소(인덱스)가 1~n+1로 있어야 함
        System.out.println(s10.solution(n));
    }
}
