package study.intro.section07;

import java.util.*;

class Section0714 {
    // 노드 1에서부터 각 노드까지의 최단 거리를 구해라
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;
    public void BFS(int v) {
        // 탐색해야할 노드를 체크하기 위해 queue에 탐색 대상이 되는 노드를 넣어준다.
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        // 탐색을 했다는 표시 즉 발자취를 남긴다.
        ch[v] = 1;
        while(!q.isEmpty()) { // q에 남은 값이 없을 때까지 계속 반복!
            int nv = q.poll(); // q에 담긴 값중 제일 먼저 담겨진 값을 꺼낸다. 이제 이 꺼낸 값(노드)를 탐색할 거임!
            for(int i : graph.get(nv)) { // 탐색 중인 노드에서 갈 수 있는 노드가 있으면 q에 담는다
                if(ch[i] == 0) { // 물론 발자취가 남겨지지 않은 (탐색 전인) 노드여야 탐색함.
                    ch[i] = 1;
                    q.offer(i);
                    // 그리고 이 노드 전 노드보다 1단계 +된 노드 이므로
                    dis[i] = dis[nv] + 1; // 로 거리를 담는다.
                }
            }
        }
    }
    public static void main(String[] args) {
        Section0714 s7 = new Section0714();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        // 노드 연결 구성
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        // 노드 발자취 남기는 배열 셋팅
        ch = new int[n + 1];
        // 최종 구하는 값 넣을 배열 셋팅
        dis = new int[n + 1];
        s7.BFS(1);
        for(int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}