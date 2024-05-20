package study.baekjoon.sorting;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

// 카드
public class P11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            Long key = Long.decode(br.readLine());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        br.close();
        int max = 0;
        Long answer = 0L;
        for(Map.Entry<Long, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max || (entry.getValue() == max && entry.getKey() < answer)) {
                max = entry.getValue();
                answer = entry.getKey();
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
