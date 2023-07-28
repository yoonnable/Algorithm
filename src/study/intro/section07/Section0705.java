package study.intro.section07;

import java.util.*;

public class Section0705 {
    // 이진트리 순회
    // 1. 전위순회 : 부모 -> 왼쪽 자식 -> 오른쪽 자식
    // 2. 중위순회 : 왼쪽 자식 -> 부모 -> 오른쪽 자식
    // 3. 후위순회 : 왼쪽 자식 -> 오른쪽 자식 -> 부모

    public static class Node {
        int data;
        Node lt, rt;
        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }
    
    Node root;

    public void DFS(Node root) {
        if(root == null) return;
        else {
            // System.out.print(root.data + " "); // 전위순회
            DFS(root.lt); //왼쪽 자식
            // System.out.print(root.data + " "); // 중위순회
            DFS(root.rt); //오른쪽 자식
            System.out.print(root.data + " "); // 후위순회
        }
    }

    public static void main(String[] args) {
        Section0705 tree = new Section0705();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        
        tree.DFS(tree.root);
    }
}