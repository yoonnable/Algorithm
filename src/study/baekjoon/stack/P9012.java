package study.baekjoon.stack;

import java.util.Scanner;
import java.util.Stack;

// 괄호
public class P9012 {
    public static void main(String[] args) {
        P9012 m = new P9012();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < T; i++) {
            String str = sc.next();
            sb.append(m.solution(str)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private String solution(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') stack.add(ch);
            else {
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if(stack.isEmpty()) return "YES";
        else return "NO";
    }
}
