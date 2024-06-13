package study.baekjoon.stack;

import java.io.*;
import java.util.*;

// 에디터
public class P1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for(char c : str.toCharArray()) leftStack.add(c); // O(m)

        int n = Integer.parseInt(br.readLine());
        for(long i = 0; i < n; i++) { // O(n)
            String s = br.readLine();
            char order = s.charAt(0);
            if('L' == order) {
                if(!leftStack.isEmpty()) rightStack.add(leftStack.pop());
            }
            else if('D' == order) {
                if(!rightStack.isEmpty()) leftStack.add(rightStack.pop());
            }
            else if('B' == order) {
                if(!leftStack.isEmpty()) leftStack.pop();
            }
            else {
                leftStack.add(s.charAt(2));
            }
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        while (!leftStack.isEmpty()) sb.append(leftStack.pop());
        sb.reverse();
        while (!rightStack.isEmpty()) sb.append(rightStack.pop());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
