package study.intro.section08;

import java.util.*;

class Section0807 {
    static int[][] arr;
    public int DFS(int n, int r) {
        if(arr[n][r] > 0) return arr[n][r];
        if(n == r || r == 0) return 1;
        else return arr[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
    }
    public static void main(String[] args) {
        Section0807 s8 = new Section0807();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int r = kb.nextInt();
        arr = new int[n + 1][r + 1];
        System.out.println(s8.DFS(n, r));
        
    }
}