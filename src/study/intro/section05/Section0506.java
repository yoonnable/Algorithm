package study.intro.section05;

import java.util.*;

public class Section0506 {
    public int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList();
        for(int i = 1; i <= n; i++) {
            q.offer(i);
        }
        while(!q.isEmpty()) {
            for(int i = 1; i < k; i++) {
                q.offer(q.poll());
            }
            q.poll();
            if(q.size() == 1) answer = q.poll();
        }
        return answer;
    }
    public static void main(String[] args) {
        Section0506 s5 = new Section0506();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        System.out.println(s5.solution(n, k));
    }
}