package study.intro.section08;

import java.util.*;

class Section0808 {
    static int[] p, b, ch; // 정답 담을 배열 p, 콤비 담을 배열 b, 체크 배열 ch
    static int n, f;
    int[][] by = new int[35][35];
    boolean flag = false;

    // 7. 조합수(메모이제이션) 참고
    public int combi(int n, int r) {
        if(r == 0 || r == (n)) {
            return 1;
        } else {
            return combi(n - 1, r - 1) + combi(n - 1, r);
        }
    }

    // 6. 순열 구하기 참고
    // DFS(0) 부터 시작해서 DFS(n)까지 가지치기로 Go
    public void DFS(int L, int sum) {
        if(flag) return;
        if(L == n) {
            if(sum == f) {
                for(int i : p) System.out.print(i + " ");
                flag = true;
            }
        } else {
            // i를 요소의 값으로 잡고 하기(어짜피 1~n까지의 숫자들의 조합이므로)
            for(int i = 1; i <= n; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    p[L] = i;
                    DFS(L + 1, sum + (b[L] * p[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Section0808 s8 = new Section0808();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        f = kb.nextInt();
        // b 만들기
        b = new int[n];
        for(int i = 0; i < n; i++) {
            b[i] = s8.combi(n - 1, i);
        }

        // p 구하기(최종 답)
        ch = new int[n + 1]; // 인덱스 번호를 0이 아닌 1부터 시작해서 n까지의 숫자를 파악하는 용도로 사용할 것이므로
        p = new int[n];
        s8.DFS(0, 0);
    }
}