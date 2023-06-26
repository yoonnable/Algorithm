package study.intro.section05;

import java.util.*;

public class Section0505 {
    public int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') stack.push(str.charAt(i));
            else {
                if(str.charAt(i - 1) == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Section0505 s5 = new Section0505();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(s5.solution(str));
    }
}