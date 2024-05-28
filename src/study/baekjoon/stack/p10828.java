package study.baekjoon.stack;

import java.io.*;
import java.util.Stack;
// 스택
public class p10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            String[] words = br.readLine().split(" ");
            switch (words[0]) {
                case "push" : stack.push(Integer.parseInt(words[1])); break;
                case "pop" : sb.append(stack.empty()? "-1" : stack.pop()).append("\n"); break;
                case "size" : sb.append(stack.size()).append("\n"); break;
                case "empty" : sb.append(stack.empty()? "1" : "0").append("\n"); break;
                case "top" : sb.append(stack.empty()? "-1" : stack.peek()).append("\n"); break;
            }
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
