package study.baekjoon.stack;

import java.util.Scanner;
import java.util.Stack;

// 쇠막대기
public class P10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int answer = 0;
        char pre = ' ';
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if(current == '(') stack.add(current);
            else {
                stack.pop();
                if(pre == '(') answer += stack.size();
                else answer += 1;
            }
            pre = current;
        }
        System.out.println(answer);
    }
}
