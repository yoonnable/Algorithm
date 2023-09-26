package study.intro.section09;

import java.util.*;

class Section0907 {
    // 7. 원더랜드(최소 스패닝 트리 - 크루스칼 : Uion&Find 이용)

    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int cost; // 도시 v1과 도시 v2를 연결한 간선의 비용
        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost; // 비용 기준 오름차순 정렬(낮은 비용을 먼저!)
        }
    }

    static int[] unf;

    static int Find(int v) {
        if(unf[v] == v) return v;
        else return unf[v] = Find(unf[v]);
    }

    static void Union(int fv1, int fv2) {
        unf[fv1] = fv2;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int v = kb.nextInt(); // 도시의 갯수
        int e = kb.nextInt(); // 도로의 갯수
        unf = new int[v + 1];
        for(int i = 0; i < v; i++) unf[i] = i;
        ArrayList<Edge> list = new ArrayList<>();
        for(int i = 0; i < e; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            list.add(new Edge(a, b, c));
        }
        Collections.sort(list); // 이때 Edge의 compareTo()를 사용하여 리스트를 정렬시킴

        int answer = 0, cnt = 0;

        for(Edge od : list) {
            int fv1 = Find(od.v1);
            int fv2 = Find(od.v2);
            if(fv1 != fv2) {
                answer += od.cost;
                Union(fv1, fv2);
                cnt++;
            }
            if(cnt == v - 1) break;
        }

        System.out.println(answer);


    }
}