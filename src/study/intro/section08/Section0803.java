package study.intro.section08;

import java.util.*;

public class Section0803 {
    static int answer = Integer.MIN_VALUE, n, m;

    public void DFS(int num, int sum, int time, int[] ps, int[] pt) {
        if(time > m) return;
        if(num == n) {
            answer = Math.max(sum, answer);
        } else {
            DFS(num + 1, sum + ps[num], time + pt[num], ps, pt);
            DFS(num + 1, sum, time, ps, pt);
        }
    }

    public static void main(String[] args) {
        Section0803 s8 = new Section0803();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        int[] ps = new int[n];
        int[] pt = new int[n];
        for(int i = 0; i < n; i++) {
            ps[i] = kb.nextInt();
            pt[i] = kb.nextInt();
        }
        s8.DFS(0, 0, 0, ps, pt);
        System.out.println(answer);
    }
}