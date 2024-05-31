package study.baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 큐
public class P10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<String> queue = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        String pre = "";
        for(int i = 0; i < n; i++) {
           String line = br.readLine();
           switch (line) {
               case "pop" : sb.append(queue.isEmpty()? "-1" : queue.poll()).append("\n"); break;
               case "size": sb.append(queue.size()).append("\n"); break;
               case "empty": sb.append(queue.isEmpty()? "1" : "0").append("\n"); break;
               case "front": sb.append(queue.isEmpty()? "-1" : queue.peek()).append("\n"); break;
               case "back" : sb.append(queue.isEmpty()? "-1" : pre).append("\n"); break;
               default: {
                   pre = line.split(" ")[1];
                   queue.add(pre);
               } break;
           }
        }
        br.close();
        System.out.println(sb.toString());
    }
}
