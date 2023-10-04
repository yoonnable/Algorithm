package study.intro.section10;

import java.util.*;

class Section1001 {
    // 크기가 엄청 큰 문제를 문제의 본질은 그대로 두고 크기를 작게(직관적인 크기로) 줄여서 푼다.
    // 그리고 문제를 풀면서 조금씩 확장해서 이 전에 작은 상태로 구한 문제의 답을 메모이제이션하여
    // 다음 확장 문제에 사용.... 동적계획법
    static int[] dy;

    public int solution(int n) {
        // 가장 작은 단위로 줄였을 때의 문제의 답을 일단 푼다.
        dy[1] = 1; // 계단 1칸을 오르는 방법은 1개
        dy[2] = 2; // 계단 2칸을 오르는 방법은 2개
        for(int i = 3; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1]; // 계단 3칸부터는 규칙이 보임.
        }
        return dy[n];
    }

    public static void main(String[] args) {
        Section1001 s10 = new Section1001();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 계단의 갯수 입력 받음
        dy = new int[n + 1]; // 각 계단별 오르는 방법 갯수 넣을 배열 만들기
        // n + 1개인 이유 : 계단은 1부터 n까지 이므로 배열 요소(인덱스)가 1~n으로 있어야 함
        System.out.println(s10.solution(n));
    }
}
