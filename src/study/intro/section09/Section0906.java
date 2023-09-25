package study.intro.section09;

import java.util.*;

class Section0906 {
    // Disjoint-Set : Uinon & Find
    // 서로소 집합
    // 학생 : 노드, 친구 관계 : 간선 이라고 생각할 때 연결되어 있으면 친구!

    static int[] unf;
    
    static public int Find(int v) {
        if(unf[v] == v) return v;
        else return unf[v] = Find(unf[v]); // 경로 압축시켜 실행 속도 빠르게 단축하기, 연결된 모든 노드 같은 값으로 일치시켜 친구 관계임.
    }

    // 친구 관계를 연결시켜주는 작업을 하는 메서드
    static public void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        unf = new int[n + 1];
        for(int i = 1; i <= n; i++) unf[i] = i; // 일단 본인은 본인만 연결되어 있는 상태로 셋팅한다. => 그래야 친구 관계 연결할때 친구가 아니라는 걸 체크할 수 있음.
        for(int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            Union(a, b); // 친구 관계 다 연결 해주고,
        }

        int a = kb.nextInt();
        int b = kb.nextInt();
        int fa = Find(a);
        int fb = Find(b);
        if(fa == fb) System.out.println("YES");
        else System.out.println("NO");
    }
}