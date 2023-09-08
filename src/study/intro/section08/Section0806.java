package study.intro.section08;

import java.util.*;

class Section0806 {
    static int n, m;
    static int[] arr, pm, ch;
    public void DFS(int L) {
        if(L == m) {
            for(int i : pm) System.out.print(i + " ");
            System.out.println();
            L = 0;
        } else {
            for(int i = 0; i < n; i++) {
                if(ch[i] == 0) {
                    pm[L] = arr[i];
                    ch[i] = 1;
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Section0806 s8 = new Section0806();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        pm= new int[m];
        ch = new int[n];
        s8.DFS(0);
    }
}