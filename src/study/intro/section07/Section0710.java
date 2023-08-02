package study.intro.section07;

import java.util.*;

class Section0710 {

    static class Node {
        int data;
        Node lt, rt;

        Node(int data) {
            this.data = data;
            lt = rt = null;
        }
    }

    public int BFS(Node root) { // 루트노드(레벨 0)를 인수로 가져옴
        int L = 0; //레벨
        Queue<Node> q = new LinkedList<>();
        q.offer(root); // 루트 노드를 Queue에 담고 탐색 시작
        while(!q.isEmpty()) { //노드가 담긴 Queue에 값이 하나도 없을 시 반복문 종료
            int len = q.size(); // 현 레벨에 있는 노드 갯수
            for(int i = 0; i < len; i++) { // 현 레벨에 있는 노드들 돌아가면서 탐색하기
                Node cur = q.poll(); // 노드 하나 꺼내서 그 노드의 자식들 있나 없나 탐색하기
                if(cur.lt == null && cur.rt == null) return L; // 자식 노드가 하나도 없으면 최단 말단노드로 레벨 반환
                if(cur.lt != null) q.offer(cur.lt); // 왼쪽 자식 노드 Queue에 담기
                if(cur.rt != null) q.offer(cur.rt); // 오른쪽 자식 노드 Queue에 담기
            }
            L++; // 레벨 업
        }
        return L;
    }
    public static void main(String[] args) {
        Section0710 s7 = new Section0710();
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(s7.BFS(root));
    }
}