package study.intro.section09;

import java.util.*;

class Section0908 {
    // 8. 원더랜드(최소 스패닝 트리 - 프림 : PriorityQueue 활용)
    // priorityQueue는 제일 작은 값이 우선이다

    static class Edge implements Comparable<Edge> {
        int vex; // 도시
        int cost; // 도로 비용
        public Edge (int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) { // priorityQueue가 자동으로 정렬할 때 사용
            return this.cost - o.cost; // 비용 낮은게 먼저!
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int v = kb.nextInt();
        int e = kb.nextInt();
        int[] ch = new int[v + 1]; // 최소 비용으로 이미 연결된 도시 체크하는 배열
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(); // 제일 상위 리스트의 index 가 출발 도시 번호 그 인덱스 번호의 도시에서 뻗어가는 도로비용과 연결된 도시 정보를 하위 리스트로 담음
        for(int i = 0; i <= v; i++) graph.add(new ArrayList<Edge>());
        for(int i = 0; i < e; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new Edge(b, c)); // a도시를 출발지로, b도시를 도착지로
            graph.get(b).add(new Edge(a, c)); // b도시를 출발지로, a도시를 도착지로
        }

        int answer = 0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>(); // 여기에 Edge 인스턴스를 담을 때마다 Edge의 compareTo()를 호출해 자동으로 정렬된다.

        ch[1] = 1;
        for(Edge od : graph.get(1)) {
            pQ.offer(od);
        }

        while(!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            if(ch[tmp.vex] == 0) {
                ch[tmp.vex] = 1;
                answer += tmp.cost;
                for(Edge od : graph.get(tmp.vex)) {
                    if(ch[od.vex] == 0) pQ.offer(od);
                }
            }
        }

        System.out.println(answer);

    }
}