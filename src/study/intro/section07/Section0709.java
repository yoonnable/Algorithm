package study.intro.section07;

class Section0709 {
    // 말단 노드까지의 가장 짧은 경로 DFS
    
    static class Node {
        int data;
        Node lt, rt;
        public Node(int data) {
            this.data = data;
            lt = rt = null;
        }
    }
    
    public int DFS(int L, Node root) {
        if(root.lt == null && root.rt == null) return L;
        else {
            return Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt));
        }
    }
    public static void main(String[] args) {
        Section0709 s7 = new Section0709();
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(s7.DFS(0, root));
    }
}