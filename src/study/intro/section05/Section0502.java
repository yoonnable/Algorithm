package study.intro.section05;

import java.util.*;

public class Section0502 {
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(c == ')') {
                while(stack.pop() != '(');
            } else stack.push(c);
        }
        for(char c : stack) answer += c;
        return answer;
    }
    public static void main(String[] args) {
        Section0502 s5 = new Section0502();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(s5.solution(str));
    }
}