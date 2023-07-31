package study.intro.section07;

import java.util.*;

public class Section0707 {
    Node root;

    static class Node {
        int data;
        Node lt, rt;

        public Node(int val) {
            data = val;
            lt=rt=null;
        }
    }
    
    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0; // 첫번째 Node인 root의 레벨은 0
        //레벨이란? 헌재 원소에서 root로 갈 때 거쳐가는 횟 수

        while(!Q.isEmpty()) { // Q가 빈 값이 아니면 반복문 실행!
            int n = Q.size();
            System.out.print("레벨 " + L + " : ");
            for(int i = 0; i < n; i++) {
                Node current = Q.poll();
                System.out.print(current.data + " ");

                if(current.lt != null) Q.offer(current.lt);
                if(current.rt != null) Q.offer(current.rt);
            }
            L++;
            System.out.println();

        }
    }

    public static void main(String[] args) {
        Section0707 tree = new Section0707();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}