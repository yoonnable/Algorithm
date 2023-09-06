package study.intro.section08;

import java.util.*;

public class Section0804 {
    static int n, m;
    static int[] pm;

    public void DFS(int L) {
        if(L == m) {
            for(int i : pm) System.out.print(i + " ");
            System.out.println();
        } else {
            for(int i = 1; i <= n; i++) {
                pm[L] = i;
                DFS(L + 1);
            }
        }
    }

    public static void main(String[] args) {
        Section0804 s8 = new Section0804();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        pm = new int[m];
        s8.DFS(0);
    }
}