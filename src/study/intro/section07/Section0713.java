package study.intro.section07;

import java.util.*;

class Section0713 {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public void DFS(int v) {
        if(v == n) answer++; // 1 ~ n까지 도달하는 방법이 몇개인지 구하는 거니까 도달 노드가 n이면 방법 1 추가 시킨다.
        else {
            for(int i : graph.get(v)) {
                if(ch[i] == 0) { // v에서 이동할 수 있는 노드 중에 아직 들리지 않은 곳이라면 들릴 수 있다!
                    ch[i] = 1; // 이제 들릴거니까 발자취 남기기
                    DFS(i); // 들리는 중
                    ch[i] = 0; // 이 루트에선 i를 들려 n까지 도달하는 방법을 다 탐색하고 왔으니 발자취 남긴거 지워주자.
                }
            }
        }
    }
    public static void main(String[] args) {
        Section0713 s7 = new Section0713();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++) { // 인덱스 값을 각 노드의 번호로 생각하고 구현할거라 n까지 포함해서 리스트를 만들어야 한다.
            graph.add(new ArrayList<>());
        }
        ch = new int[n + 1]; // 발자취 남기는 배열도 마찬가지로 인덱스 = 노드로 할 것이므로 갯수를 n + 1로 해서 유효한 인덱스에 n을 포함시킨다.
        for(int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1; // 노드 1을 이미 지나감을 표시
        s7.DFS(1);
        System.out.println(answer);
    }
}