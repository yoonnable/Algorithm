package study.intro.section07;

import java.util.*;

public class Section0708 {
    int[] dis = {1, -1, 5};

    public int solution(int s, int e) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        int L = 0;
        int[] ch = new int[10001];
        ch[s] = 1;
        while(!Q.isEmpty()) {
            int n = Q.size();
            for(int i = 0; i < n; i++) {
                int x = Q.poll();
                for(int j = 0; j < dis.length; j++) {
                    int next = x + dis[j];
                    if(next == e) return L + 1;
                    if(next > 0 && ch[next] == 0) {
                        Q.offer(next);
                        ch[next] = 1;
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Section0708 s7 = new Section0708();
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.print(s7.solution(s, e));
    }
}