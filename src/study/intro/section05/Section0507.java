package study.intro.section05;

import java.util.*;

public class Section0507 {
    public String solution(String a, String b) {
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();
        for(char c : a.toCharArray()) q.offer(c);
        for(char c : b.toCharArray()) {
            if(q.contains(c)) {
                if(c != q.poll()) return "NO";
            }
        }
        if(!q.isEmpty()) return "NO";

        return answer;
    }
    public static void main(String[] args) {
        Section0507 s5 = new Section0507();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();
        System.out.println(s5.solution(a, b));
    }
}