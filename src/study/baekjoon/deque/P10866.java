package study.baekjoon.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// Deque
public class P10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++) {
            String current = br.readLine();
            if(current.contains("push")) {
                String[] strings = current.split(" ");
                Integer integer = Integer.parseInt(strings[1]);
                switch (strings[0]) {
                    case "push_front" : deque.addFirst(integer); break;
                    case "push_back" : deque.addLast(integer); break;
                }
                continue;
            }
            switch (current) {
                case "pop_front" : sb.append(deque.isEmpty()? "-1" : deque.pollFirst()).append("\n"); break;
                case "pop_back" : sb.append(deque.isEmpty()? "-1" : deque.pollLast()).append("\n"); break;
                case "size" : sb.append(deque.size()).append("\n"); break;
                case "empty" : sb.append(deque.isEmpty()? "1": "0").append("\n"); break;
                case "front" : sb.append(deque.isEmpty()? "-1" : deque.peekFirst()).append("\n");break;
                case "back" : sb.append(deque.isEmpty()? "-1" : deque.peekLast()).append("\n"); break;
            }
        }
        br.close();
        System.out.println(sb.toString());
    }
}
