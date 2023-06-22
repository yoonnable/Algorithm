package study.intro.section05;

import java.util.*;

class Section0501 {
    public String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(c == '(') stack.push(c);
            else {
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return "NO";
        return answer;
    }
    public static void main(String[] args) {
        Section0501 s5 = new Section0501();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(s5.solution(str));
    }
}
