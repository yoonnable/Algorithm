package study.intro.section09;

import java.util.*;

class Section0905 {
    // 다익스트라 가중치는 무조건 양수!
    // O(n) -> logn
    static class Edge implements Comparable<Edge> {
        int point;
        int cost;
        public Edge(int point, int cost) {
            this.point = point;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    public void solution() {
        PriorityQueue<Edge> pQ = new PriorityQueue<>(); // 자동으로 요소들을 정렬해서 담아주는 Queue
        dis[1] = 0;
        pQ.offer(new Edge(1, 0));
        while(!pQ.isEmpty()) {
            Edge e = pQ.poll();
            int nowPoint = e.point;
            int nowCost = e.cost;
            if(nowCost > dis[nowPoint]) continue; // 이미 탐색해서 넣은 비용보다 높은 비용이면 이 포인트를 지나는 모든 포인트는 무조건 큰 비용을 지불해야하므로 아래 작업이 필요 없으므로 continue로 반복문을 다음으로 넘겨버린다.
            for(Edge op : graph.get(nowPoint)) {
                if(dis[op.point] > nowCost + op.cost) {
                    dis[op.point] = nowCost + op.cost;
                    pQ.offer(new Edge(op.point, nowCost + op.cost)); // dis에 담긴 비용보다 nowCost + op.cost 한 비용이 더 싸므로 이 경로를 이용해 도달하는 포인트들도 탐색이 필요하므로 pQ에 nowCost + op.cost 값을 넣어준다.
                }
            }
        }
    }

    public static void main(String[] args) {
        Section0905 s9 = new Section0905();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE); // 배열 모든 요소에 한번에 같은 값 넣기
        for(int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new Edge(b, c));
        }
        s9.solution();

        for(int i = 2; i <= n; i++) {
            if(dis[i] == Integer.MAX_VALUE) System.out.println(i + " : Impossible");
            else System.out.println(i + " : " + dis[i]);
        }
    }
}