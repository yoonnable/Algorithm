package study.baekjoon.queue;

import java.io.*;
import java.util.*;

// 요세푸스 문제
public class P1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }
        StringBuffer sb = new StringBuffer().append("<");
        while (queue.size() > 1) {
            for(int i = 1; i <= k; i++) {
                if(i == k) {
                    sb.append(queue.poll()).append(", "); break;
                }
                queue.add(queue.poll());
            }
        }
        sb.append(queue.poll()).append(">");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
